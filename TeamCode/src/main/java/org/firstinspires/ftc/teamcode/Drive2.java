package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.Range;

/**
 * Created by Kain on 9/19/2016.
 */

@TeleOp(name = "Driver2", group = "Driver2")
public class Drive2 extends OpMode {

    DcMotor FL;
    DcMotor BL;
    DcMotor FR;
    DcMotor BR;
    DcMotor flapper;
    DcMotor leftpulley;
    DcMotor rightpulley;
    DcMotor spinner;

    public Drive2() {

    }

    @Override
    public void init() {

        //Left Drive
        FL = hardwareMap.dcMotor.get("FL");
        BL = hardwareMap.dcMotor.get("BL");
        FL.setDirection(DcMotor.Direction.REVERSE);
        BL.setDirection(DcMotor.Direction.REVERSE);
        FR = hardwareMap.dcMotor.get("FR");
        BR = hardwareMap.dcMotor.get("BR");
        FR.setDirection(DcMotor.Direction.FORWARD);
        BR.setDirection(DcMotor.Direction.FORWARD);
        //flapper
        flapper = hardwareMap.dcMotor.get("flapper");
        flapper.setDirection(DcMotor.Direction.REVERSE);
        //pulley
        rightpulley = hardwareMap.dcMotor.get("rightpulley");
        leftpulley = hardwareMap.dcMotor.get("leftpulley");
        leftpulley.setDirection(DcMotor.Direction.REVERSE);
        //spinner
        spinner = hardwareMap.dcMotor.get("spinner");


    }

    public void loop() {

        float A = gamepad1.left_stick_y; //Left Up and Down
        float B = gamepad1.left_stick_x; //Left Side to Side
        float C = gamepad1.right_stick_x; //Turn CounterClockwise and Clockwise

        if (gamepad2.y) {
            spinner.setPower(.1);
        }
        else {
            spinner.setPower(0);
        }

        if (gamepad2.dpad_up) {
            leftpulley.setPower(1);
            rightpulley.setPower(-1);
        }
        else {
            leftpulley.setPower(0);
            rightpulley.setPower(0);
        }
        if (gamepad2.dpad_up) {
            leftpulley.setPower(1);
            rightpulley.setPower(-1);
        }
        else {
            leftpulley.setPower(0);
            rightpulley.setPower(0);
        }
        if (gamepad1.a) {
            flapper.setPower(1);
        }
        if (gamepad1.b) {
            flapper.setPower(-1);
        }
        if(gamepad1.x) {
            flapper.setPower(0);
        }

        A = (float) scaleInput(A);
        B = (float) scaleInput(B);
        C = (float) scaleInput(C);


        FL.setPower(Range.clip(((A - B) - C), -1, 1));
        FR.setPower(Range.clip(((A + B) + C), -1, 1));
        BL.setPower(Range.clip(((A - B) + C), -1, 1));
        BR.setPower(Range.clip(((A + B) - C), -1, 1));


    }

    public double scaleInput(double dVal) {
        double[] scaleArray = {0.0, 0.0, 0.2, 0.22, 0.28, 0.35, 0.40, 0.45,
                0.50, 0.55, 0.60, 0.65, 0.72, 0.85, 0.90, 1.0, 1.0
        };
        int index = (int) (dVal * 15.0);
        if (index < 0) {
            index = -index;
        }
        if (index > 15) {
            index = 15;
        }
        double dScale = 0.0;
        if (dVal < 0) {
            dScale = -scaleArray[index];
        } else {
            dScale = scaleArray[index];
        }
        if (dVal < -1) {
            dVal = -1;
        }
        if (dVal > 1) {
            dVal = 1;
        }


        return dScale;
    }
}
