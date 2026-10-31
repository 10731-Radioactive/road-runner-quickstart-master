package org.firstinspires.ftc.teamcode;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

import kotlin.math.UMathKt;

@Config
class ActiveConfig {
        public static double ShooterVel = 0;

}
@TeleOp(name="10731 BioBuzz TeleOp", group="Linear OpMode")
//@Disabled
public class BiobuzzTeleop extends LinearOpMode {

    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotorEx fLMotor = null;
    private DcMotorEx fRMotor = null;
    private DcMotorEx bLMotor = null;
    private DcMotorEx bRMotor = null;
    private DcMotorEx PsMotor = null;
    private DcMotorEx NsMotor = null;
    private DcMotorEx iMotor = null;
    private Servo FlowerServo = null;


    private Servo NServo = null;

    private Servo PServo = null;
    double Ndefaultshootervel = 1600;

    double Pdefaultshootervel = 1800;

    boolean FlowerCollectorOn = false;

    boolean NShooterOn = false;

    boolean PShooterOn = false;

    boolean IntakeOn = false;


    @Override
    public void runOpMode() {
        fLMotor = hardwareMap.get(DcMotorEx.class, "leftFront");
        fRMotor = hardwareMap.get(DcMotorEx.class, "rightFront");
        bLMotor = hardwareMap.get(DcMotorEx.class, "leftBack");
        bRMotor = hardwareMap.get(DcMotorEx.class, "rightBack");

        fLMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        bLMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        fLMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        fRMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        bLMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        bRMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);


        //6000 rpm motor 28ppm
        NsMotor = hardwareMap.get(DcMotorEx.class, "NshooterMotor");
        PsMotor = hardwareMap.get(DcMotorEx.class, "PshooterMotor");

        NServo = hardwareMap.get(Servo.class, "NectarServo");
        PServo = hardwareMap.get(Servo.class, "PollenServo");
        //1620 rpm motor 103.8pp 9m
        iMotor = hardwareMap.get(DcMotorEx.class, "intakeMotor");

        FlowerServo = hardwareMap.get(Servo.class, "FlowerServo");

        PServo.setPosition(0.75);
        NServo.setPosition(0.75);
        telemetry.addData("Status", "Initialized");
        telemetry.update();


        // Wait for the game to start (driver presses START)
        waitForStart();
        runtime.reset();

        while (opModeIsActive()) {


            //basic movement code
            double y = -gamepad1.left_stick_y;
            double x = gamepad1.left_stick_x;
            double rx = gamepad1.right_stick_x;

         /* if ((y == 0) && (x == 0) && (rx == 0)); {
                fLMotor.
                fRMotor.setPower(fRPower);
                bLMotor.setPower(bLPower);
                bRMotor.setPower(bRPower);
            }  scrapped brake code ^
          */


            double fLPower = (y + x + rx);
            double bLPower = (y - x + rx);
            double fRPower = (y - x - rx);
            double bRPower = (y + x - rx);

            fLMotor.setPower(fLPower);
            fRMotor.setPower(fRPower);
            bLMotor.setPower(bLPower);
            bRMotor.setPower(bRPower);

            //TestServo.setPosition(Math.sin(x));

            //start shooter Code -v
            // basic power shooter code -v
            //todo make better code for shooter; in progress
            /*
            if (gamepad1.left_bumper) {
                sMotor.setPower(5.5);
            } else if (gamepad1.left_trigger > 0.4) {
                sMotor.setPower(-5.5);
            } else {
                sMotor.setPower(0);
            }
            */

            //experimental velocity code, preferred if works -v
            if (gamepad2.leftBumperWasPressed()) {
                NShooterOn = !NShooterOn;
            }
            if (gamepad2.rightBumperWasPressed()) {
                PShooterOn = !PShooterOn;
            }
            if (gamepad1.bWasPressed()) {
                FlowerCollectorOn = !FlowerCollectorOn;
            }
            if (gamepad1.aWasPressed()) {
                IntakeOn = !IntakeOn;
            }



            if (gamepad2.dpadUpWasPressed()) {
                Ndefaultshootervel = Ndefaultshootervel += 10;
            }
            if (gamepad2.dpadDownWasPressed()) {
                Ndefaultshootervel = Ndefaultshootervel -= 10;
            }
            if (gamepad2.dpadRightWasPressed()) {
                Pdefaultshootervel = Pdefaultshootervel += 10;
            }
            if (gamepad2.dpadLeftWasPressed()) {
                Pdefaultshootervel = Pdefaultshootervel -= 10;
            }

            telemetry.addData("Nectar ShooterVel", Ndefaultshootervel);

            telemetry.addData("Pollen ShooterVel", Pdefaultshootervel);

            telemetry.addData("Actual Nectar ShooterVel", NsMotor.getVelocity());

            telemetry.addData("Actual Nectar ShooterVel", PsMotor.getVelocity());

            if (PShooterOn) {
                PsMotor.setVelocity(Pdefaultshootervel);
            } else {
                PsMotor.setPower(0);
            }

            if (NShooterOn) {
                NsMotor.setVelocity(-Ndefaultshootervel);
                //sMotor.setPower(-1);
            } else {
                NsMotor.setPower(0);
            }

            if (FlowerCollectorOn) {
                FlowerServo.setPosition(0.8);
            } else {
                FlowerServo.setPosition(0);
            }
            if (gamepad2.left_trigger > 0.15) {
                NServo.setPosition(0);
            } else {
                NServo.setPosition(0.8);
            }
            if (gamepad2.right_trigger > 0.15) {
                PServo.setPosition(0);
            } else {
                PServo.setPosition(0.75);
            }
            /*
            if (gamepad1.dpadLeftWasPressed()) {
                Pdefaultshootervel = Pdefaultshootervel -= 100;
            }
            */



            /*
            }
            if (gamepad1.left_bumper) {
                sMotor.setVelocity(defaultshootervel);
            } else if (gamepad1.left_trigger > 0.4) {
                sMotor.setVelocity(-defaultshootervel);
            } else {
                sMotor.setPower(0);
            }
            */
            //end shooter code -^

            //start intake code -v
            if (IntakeOn) {
                iMotor.setPower(-1);
            } else if (gamepad2.left_stick_button) {
                iMotor.setPower(1);
            } else {
                iMotor.setPower(0);
            }
            //end intake code -^
            telemetry.addData("LTrigger", gamepad2.left_trigger);
            telemetry.addData("RTrigger", gamepad2.right_trigger);
            telemetry.update();
            telemetry.clear();
        }
    }
}
