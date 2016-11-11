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
@TeleOp(name = "KainTestStateMachine: NullOp", group = "KainTestStateMachine")

public class KainTestStateMachine extends OpMode {


    ColorSensor colorsensor;
    ColorSensor linesensor;

    DcMotor FL;
    DcMotor BL;
    DcMotor FR;
    DcMotor BR;
    ElapsedTime time;
    ModernRoboticsUsbDcMotorController controller;
    GyroSensor gyrosensor;

    static final double forwardTime2 = 3;
    static final double forwardTime = 2;
    static final double turnTime = 1.0;
    static final double stopTime = 0.1;
    static final double PushRed = 0.1;
    static final double PushRed2 = 0.1;
    int count = 0;

    enum State {drivingStraight, turning, stop, Red, PushButton, PushButton2, drivingstraight2, done}
    State state;



    @Override
    public void init() {
        FL = hardwareMap.dcMotor.get("FL");
        BL = hardwareMap.dcMotor.get("BL");
        FR = hardwareMap.dcMotor.get("FR");
        BR = hardwareMap.dcMotor.get("BR");
        FL.setDirection(DcMotor.Direction.REVERSE);
        BL.setDirection(DcMotor.Direction.REVERSE);

        colorsensor = hardwareMap.colorSensor.get("colorsensor");
        linesensor = hardwareMap.colorSensor.get("linesesnsor");

        gyrosensor = hardwareMap.gyroSensor.get("gyrosensor");
        gyrosensor.calibrate();

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

                while (gyrosensor.equals(0-89)){}

                setSpeed(0,0,0,0);

                state = State.drivingstraight2;

                break;

            case drivingstraight2:

                FL.setPower(0.5);
                BL.setPower(0.5);
                FR.setPower(0.5);
                BR.setPower(0.5);

                while (linesensor.equals(16)){

                }

                break;

            case stop:
                FL.setPower(0);
                BL.setPower(0);
                FR.setPower(0);
                BR.setPower(0);

                if (currentTime > stopTime) {
                    state = State.Red;
                }

                break;

            case Red:
                telemetry.addData("red", colorsensor.red());
                telemetry.addData("green", colorsensor.green());
                telemetry.addData("blue", colorsensor.blue());

                if( colorsensor.red()>colorsensor.blue()&&colorsensor.red()>colorsensor.green()) {
                    state = State.PushButton;
                }

                break;

            case PushButton:

                FL.setPower(.5);
                BL.setPower(.5);
                FR.setPower(-.5);
                BR.setPower(-.5);

                while (gyrosensor.equals(0-89)){}

                setSpeed(0,0,0,0);

                state = State.done;

                break;

            case PushButton2:

                FL.setPower(.5);
                BL.setPower(.5);
                FR.setPower(.5);
                BR.setPower(.5);

                if(currentTime > PushRed2) {
                    state = State.done;
                }

                break;

            case done:

                setSpeed(0,0,0,0);
                }

        }

    public void setSpeed(double FrontRight,double FrontLeft,double BackLeft,double BackRight){

        FL.setPower(FrontLeft);
        BL.setPower(BackLeft);
        FR.setPower(FrontRight);
        BR.setPower(BackRight);

    }

    }

