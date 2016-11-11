package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

/**
 * Created by Kaine on 10/8/2016.
 */

@TeleOp(name = "Encoders: NullOp", group = "Encoders")public class Kain_Test_2 extends LinearOpMode {

    DcMotor FR;
    DcMotor FL;
    DcMotor BR;
    DcMotor BL;
    int i = 1;

    @Override
    public void runOpMode() throws InterruptedException {

        FR = hardwareMap.dcMotor.get("FR");
        FL = hardwareMap.dcMotor.get("FL");
        BR = hardwareMap.dcMotor.get("BR");
        BL = hardwareMap.dcMotor.get("BL");

        FR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        BR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        FL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        BL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        FL.setDirection(DcMotorSimple.Direction.REVERSE);
        BL.setDirection(DcMotorSimple.Direction.REVERSE);

        Thread.sleep(500);
/*

        FR.setPower(.5);
        FL.setPower(.5);
        BR.setPower(.5);
        BL.setPower(.5);

        Thread.sleep(5000);

        FR.setPower(-.5);
        FL.setPower(.5);
        BR.setPower(-.5);
        BL.setPower(.5);

        Thread.sleep(5000);

        FR.setPower(.5);
        FL.setPower(-.5);
        BR.setPower(.5);
        BL.setPower(-.5);

        Thread.sleep(5000);

        FR.setPower(-.5);
        FL.setPower(-.5);
        BR.setPower(-.5);
        BL.setPower(-.5);

        Thread.sleep(5000);

        FR.setPower(-.5);
        FL.setPower(.5);
        BR.setPower(.5);
        BL.setPower(-.5);

        Thread.sleep(5000);

        FR.setPower(.5);
        FL.setPower(-.5);
        BR.setPower(-.5);
        BL.setPower(.5);

        Thread.sleep(5000);
*/

        FL.setPower(.5);
        BL.setPower(.5);
        FR.setPower(.5);
        BR.setPower(.5);

        FL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        BL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        FR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        BR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        Thread.sleep(500);


        /*if(!FL.isBusy()&&!FR.isBusy()&&!BR.isBusy()&&!BL.isBusy()) {

            //1400 per rotation
            FL.setTargetPosition(2800);
            BL.setTargetPosition(2800);
            FR.setTargetPosition(2800);
            BR.setTargetPosition(2800);

        }

        Thread.sleep(500);

        if(!FL.isBusy()&&!FR.isBusy()&&!BR.isBusy()&&!BL.isBusy()){



        }*/
        switch (i) {
            case 1: {

                // action

                FL.setTargetPosition(2800);
                BL.setTargetPosition(2800);
                FR.setTargetPosition(2800);
                BR.setTargetPosition(2800);
                i++;


            }
            break;
            case 2: {
                //action
                if (!FL.isBusy() && !FR.isBusy() && !BR.isBusy() && !BL.isBusy()) {

                FL.setTargetPosition(-2800);
                BL.setTargetPosition(-2800);
                FR.setTargetPosition(-2800);
                BR.setTargetPosition(-2800);}
                i++;

            }
            break;
            case 3: {
                //action
                if (!FL.isBusy() && !FR.isBusy() && !BR.isBusy() && !BL.isBusy()) {


                    FL.setTargetPosition(2800);
                    BL.setTargetPosition(-2800);
                    FR.setTargetPosition(-2800);
                    BR.setTargetPosition(2800);
                    i++;
                }

            }
            break;
            case 4: {
                //action
                if (!FL.isBusy() && !FR.isBusy() && !BR.isBusy() && !BL.isBusy()) {

                FL.setTargetPosition(-2800);
                BL.setTargetPosition(2800);
                FR.setTargetPosition(2800);
                BR.setTargetPosition(-2800);
                i++;}


            }
            break;

            default: {
                FL.setPower(0);
                BL.setPower(0);
                FR.setPower(0);
                BR.setPower(0);
            }

            break;


        }
    }
}
