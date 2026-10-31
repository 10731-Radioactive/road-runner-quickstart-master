/*
package org.firstinspires.ftc.teamcode;


import androidx.annotation.NonNull;

// RR-specific imports
import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.SequentialAction;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;

// Non-RR imports
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import org.firstinspires.ftc.teamcode.MecanumDrive;
import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.canvas.Canvas;
import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.*;
import com.acmerobotics.roadrunner.AngularVelConstraint;
import com.acmerobotics.roadrunner.DualNum;
import com.acmerobotics.roadrunner.HolonomicController;
import com.acmerobotics.roadrunner.MecanumKinematics;
import com.acmerobotics.roadrunner.MinVelConstraint;
import com.acmerobotics.roadrunner.MotorFeedforward;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Pose2dDual;
import com.acmerobotics.roadrunner.ProfileAccelConstraint;
import com.acmerobotics.roadrunner.Time;
import com.acmerobotics.roadrunner.TimeTrajectory;
import com.acmerobotics.roadrunner.TimeTurn;
import com.acmerobotics.roadrunner.TrajectoryActionBuilder;
import com.acmerobotics.roadrunner.TurnConstraints;
import com.acmerobotics.roadrunner.VelConstraint;
import com.acmerobotics.roadrunner.ftc.DownsampledWriter;
import com.acmerobotics.roadrunner.ftc.Encoder;
import com.acmerobotics.roadrunner.ftc.FlightRecorder;
import com.acmerobotics.roadrunner.ftc.LazyHardwareMapImu;
import com.acmerobotics.roadrunner.ftc.LazyImu;
import com.acmerobotics.roadrunner.ftc.LynxFirmware;
import com.acmerobotics.roadrunner.ftc.OverflowEncoder;
import com.acmerobotics.roadrunner.ftc.PositionVelocityPair;
import com.acmerobotics.roadrunner.ftc.RawEncoder;
import com.qualcomm.hardware.lynx.LynxModule;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;
import com.qualcomm.robotcore.hardware.VoltageSensor;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.YawPitchRollAngles;
import org.firstinspires.ftc.teamcode.messages.DriveCommandMessage;
import org.firstinspires.ftc.teamcode.messages.MecanumCommandMessage;
import org.firstinspires.ftc.teamcode.messages.MecanumLocalizerInputsMessage;
import org.firstinspires.ftc.teamcode.messages.PoseMessage;

import java.lang.Math;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


@Config
@Autonomous(name = "BioBuzzAuto", group = "Autonomous")
public class BioBuzzAuto extends LinearOpMode {

    //Below is shooter / motor setup and action code.
    public class Shooters {
        private DcMotorEx ShooterP;
        private DcMotorEx ShooterN;
        private DcMotorEx ShooterTurn;

        public Shooters(HardwareMap hardwareMap) {
            ShooterP = hardwareMap.get(DcMotorEx.class, "ShooterP");
            ShooterP.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.FLOAT);
            ShooterP.setDirection(DcMotorEx.Direction.FORWARD);

            ShooterN = hardwareMap.get(DcMotorEx.class, "ShooterN");
            ShooterN.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.FLOAT);
            ShooterN.setDirection(DcMotorEx.Direction.FORWARD);

            ShooterTurn = hardwareMap.get(DcMotorEx.class, "ShooterTurn");
            ShooterTurn.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.FLOAT);
            ShooterTurn.setDirection(DcMotorEx.Direction.FORWARD);

        }
    }



    //Below is Servo setup and action code.
    public class FlowerArm {
        private Servo FlowerArm;


        public FlowerArm(HardwareMap hardwareMap) {
            FlowerArm = hardwareMap.get(Servo.class, "FlowerArm");
        }
    }




    @Override
    public void runOpMode() throws InterruptedException {
        // instantiate your MecanumDrive at a particular pose.
        Pose2d initialPose = new Pose2d(11.8, 61.7, Math.toRadians(90));
        MecanumDrive drive = new MecanumDrive(hardwareMap, initialPose);
        // Make Shooter Instances
        Shooters ShooterN = new Shooters(hardwareMap);
        Shooters ShooterP = new Shooters(hardwareMap);
        Shooters ShooterTurn = new Shooters(hardwareMap);
        // make Flower Instances
        FlowerArm FlowerArm = new FlowerArm(hardwareMap);

    }
}
 */
