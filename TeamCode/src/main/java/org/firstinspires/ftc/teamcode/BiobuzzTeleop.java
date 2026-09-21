package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name="10731 BioBuzz TeleOp", group="Linear OpMode")
//@Disabled
public class BiobuzzTeleop extends LinearOpMode {

    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotorEx fLMotor = null;
    private DcMotorEx fRMotor = null;
    private DcMotorEx bLMotor = null;
    private DcMotorEx bRMotor = null;
    private DcMotorEx sMotor = null;
    private DcMotorEx iMotor = null;


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
        //sMotor = hardwareMap.get(DcMotorEx.class, "shooterMotor");

        //1620 rpm motor 103.8ppm
        //iMotor = hardwareMap.get(DcMotorEx.class, "intakeMotor");



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

            //Shooter Code
            /*if(gamepad1.right_bumper){
                iMotor.setVelocity(103);
                if(gamepad1.right_trigger_pressed){
                    sMotor.setVelocity(28);
                    telemetry.addLine("Firing!");
                }
                else{
                    telemetry.addLine("Ready to Fire!");
                }
            }
            else{
                iMotor.setVelocity(0);
            }*/

            telemetry.update();
            telemetry.clear();
        }
    }
}
