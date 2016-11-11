package org.firstinspires.ftc.teamcode;

import android.graphics.Color;

import com.qualcomm.hardware.modernrobotics.ModernRoboticsUsbDcMotorController;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.GyroSensor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.ColorSensor;

import org.firstinspires.ftc.robotcore.external.Telemetry;

/**
 * Created by Kaine on 10/9/2016.
 */
@TeleOp(name = "BasicAutonomous: NullOp", group = "BasicAutonomous")

public class BasicAtounomus extends OpMode {




    DcMotor FL;
    DcMotor BL;
    DcMotor FR;
    DcMotor BR;
    ElapsedTime time;

    static final double forwardTime2 = 3.2;
    static final double forwardTime = 2;
    static final double turnTime = .7;
    static final double ShootTime = 2.0;
    static final double turnTime2 = .3;
    int count = 0;

    enum State {drivingStraight, turning, turning2, stop, Red, PushButton, Shoot, drivingstraight2, done}
    State state;



    @Override
    public void init() {
        FL = hardwareMap.dcMotor.get("FL");
        BL = hardwareMap.dcMotor.get("BL");
        FR = hardwareMap.dcMotor.get("FR");
        BR = hardwareMap.dcMotor.get("BR");
        FR.setDirection(DcMotor.Direction.REVERSE);
        BR.setDirection(DcMotor.Direction.REVERSE);

        time = new ElapsedTime();
        state = State.drivingStraight;


    }

    @Override
    public void loop() {
        //move
        //while(not where i want to be){}
        //stop moving
        // telemetry.addData("voltage", controller.getVoltage());
        // controller.getVoltage();

        double currentTime = time.time();
        switch(state) {

            case drivingStraight:

                FL.setPower(0.5);
                BL.setPower(0.5);
                FR.setPower(0.5);
                BR.setPower(0.5);

                if (currentTime > forwardTime) {
                    state = State.turning;
                    time.reset();
                }

                break;

            case turning:

                FL.setPower(0.5);
                BL.setPower(0.5);
                FR.setPower(-0.5);
                BR.setPower(-0.5);

                if (currentTime > turnTime) {
                    state = State.turning2;
                    time.reset();
                }



                break;

            case turning2:

                FL.setPower(0.5);
                BL.setPower(0.5);
                FR.setPower(-0.5);
                BR.setPower(-0.5);

                if (currentTime > turnTime2) {
                    state = State.drivingstraight2;
                    time.reset();
                }



                break;

            case drivingstraight2:

                FL.setPower(0.5);
                BL.setPower(0.5);
                FR.setPower(0.5);
                BR.setPower(0.5);

                if (currentTime > forwardTime2) {
                    state = State.Shoot;
                    time.reset();
                }
                break;

            case Shoot:

                FL.setPower(0.5);
                BL.setPower(0.5);
                FR.setPower(0.5);
                BR.setPower(0.5);

                if (currentTime > ShootTime) {
                    state = State.done;
                }

            case done:

                FL.setPower(0);
                BL.setPower(0);
                FR.setPower(0);
                BR.setPower(0);
    }

    }


}

