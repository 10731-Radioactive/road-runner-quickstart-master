package com.example.meepmeeptesting;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class MeepMeepTesting {
    public static void main(String[] args) {
        MeepMeep meepMeep = new MeepMeep(800);


        RoadRunnerBotEntity myBot = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                .setStartPose(new Pose2d(-61, -46, Math.toRadians(0)))
                .build();


        //Default Testing Pattern:
        //                .lineToX(30)
        //                .turn(Math.toRadians(90))
        //                .lineToY(30)
        //                .turn(Math.toRadians(90))
        //                .lineToX(0)
        //                .turn(Math.toRadians(90))
        //                .lineToY(0)
        //                .turn(Math.toRadians(90))
        //                .build());
        myBot.runAction(myBot.getDrive().actionBuilder(new Pose2d(-61, -46, 0))
                .strafeTo(new Vector2d(40, -40))
                .strafeTo(new Vector2d(40, 40))
                .strafeTo(new Vector2d(-40, 40))
                .strafeTo(new Vector2d(-40, -40))
                .strafeTo(new Vector2d(-61, -46))
                .build());
        {

            Image img = null;
            try {
                img = ImageIO.read(new File("C:\\Users\\talon\\Documents\\Programming\\Robotics\\road-runner-quickstart-master\\Resources\\bb teop.png"));
            } catch (IOException e) {
            }

            meepMeep.setBackground(img)
                    //meepMeep.setBackground(MeepMeep.Background.FIELD_POWERPLAY_OFFICIAL)
                    .setDarkMode(true)
                    .setBackgroundAlpha(0.95f)
                    .addEntity(myBot)
                    .start();
        }
    }
}