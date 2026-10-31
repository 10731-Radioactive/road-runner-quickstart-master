package org.firstinspires.ftc.teamcode;

import static java.lang.Thread.sleep;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
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
import kotlin.reflect.KFunction;


@Autonomous(name="10731 BioBuzz TEMPAUTO", group="Linear OpMode")
//@Disabled
public class TEMPBIOBUZZAUTO extends LinearOpMode {

    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();
    public DcMotorEx fLMotor = null;
    public DcMotorEx fRMotor = null;
    public DcMotorEx bLMotor = null;
    public DcMotorEx bRMotor = null;
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
        double ay = -gamepad1.left_stick_y;
        double ax = gamepad1.left_stick_x;
        double arx = gamepad1.right_stick_x;
        /*
        ay = Math.sin(90);
        ax = Math.cos(90);
        double fLPower = (ay + ax + arx);
        double bLPower = (ay - ax + arx);
        double fRPower = (ay - ax - arx);
        double bRPower = (ay + ax - arx);
        fLMotor.setPower(fLPower);
        fRMotor.setPower(fRPower);
        bLMotor.setPower(bLPower);
        bRMotor.setPower(bRPower);
        sleep(2350);

        fLMotor.setPower(0);
        fRMotor.setPower(0);
        bLMotor.setPower(0);
        bRMotor.setPower(0);

        while (opModeIsActive()) {


            //basic movement code


          if ((y == 0) && (x == 0) && (rx == 0)); {
                fLMotor.
                fRMotor.setPower(fRPower);
                bLMotor.setPower(bLPower);
                bRMotor.setPower(bRPower);
            }  scrapped brake code ^
          */

            /*
            double fLPower = (y + x + rx);
            double bLPower = (y - x + rx);
            double fRPower = (y - x - rx);
            double bRPower = (y + x - rx);


            fLMotor.setPower(fLPower);
            fRMotor.setPower(fRPower);
            bLMotor.setPower(bLPower);
            bRMotor.setPower(bRPower);
            */

            /*
             ay = Math.sin(180);
             ax = Math.cos(180);
             fLPower = (ay + ax);
             bLPower = (ay - ax);
             fRPower = (ay - ax);
             bRPower = (ay + ax);
            fLMotor.setPower(fLPower);
            fRMotor.setPower(fRPower);
            bLMotor.setPower(bLPower);
            bRMotor.setPower(bRPower);
            sleep(1000);
*/

        tmove(1, 0, 2000);
        tmove(1, -90, 1750);
        tmove(1, 180, 1750);
        tmove(1, 90, 1750);
        tmove(1, 180, 250);




            telemetry.addData("Nectar ShooterVel", Ndefaultshootervel);

            telemetry.addData("Pollen ShooterVel", Pdefaultshootervel);

            telemetry.addData("Actual Nectar ShooterVel", NsMotor.getVelocity());

            telemetry.addData("Actual Nectar ShooterVel", PsMotor.getVelocity());

            //end intake code -^
            telemetry.addData("LTrigger", gamepad2.left_trigger);
            telemetry.addData("RTrigger", gamepad2.right_trigger);
            telemetry.update();
            telemetry.clear();
        }
    public void tmove(double power, double angle, long time) {
        double ay = (power*(Math.sin(Math.toRadians(angle+90))));
        double ax = (power*(Math.cos(Math.toRadians(angle+90))));
        double fLPower = (ay + ax);
        double bLPower = (ay - ax);
        double fRPower = (ay - ax);
        double bRPower = (ay + ax);
        fLMotor.setPower(fLPower);
        fRMotor.setPower(fRPower);
        bLMotor.setPower(bLPower);
        bRMotor.setPower(bRPower);
        sleep(time);
        fLMotor.setPower(0);
        fRMotor.setPower(0);
        bLMotor.setPower(0);
        bRMotor.setPower(0);
    }
    }



