// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class navXSub extends SubsystemBase {
  /** Creates a new navXSub. */

  AHRS navX;
  public static SPI.Port navXPort = SPI.Port.kMXP;

  VictorSPX FRMotor,BRMotor, FLMotor, BLMotor;
  public navXSub() {

    navX = new AHRS(navXPort);

    FRMotor = new VictorSPX(Constants.FRMotor);
    FLMotor = new VictorSPX(Constants.FLMotor);
    BRMotor = new VictorSPX(Constants.BRMotor);
    BLMotor = new VictorSPX(Constants.BLMotor);

  }

  public void calibrateNavX(){
    navX.calibrate();
  }

  public void resetNavX(){
    navX.reset();
  }

  public double getNavXAngle(){
    return navX.getAngle();
  }

  public void setMotor(double power){
    FRMotor.set(ControlMode.PercentOutput, power);
    BRMotor.set(ControlMode.PercentOutput, power);
    FLMotor.set(ControlMode.PercentOutput, power);
    BLMotor.set(ControlMode.PercentOutput, power);
  }

  public void stopMotor(){
    FRMotor.set(ControlMode.PercentOutput, 0.0);
    BRMotor.set(ControlMode.PercentOutput, 0.0);
    FLMotor.set(ControlMode.PercentOutput, 0.0);
    BLMotor.set(ControlMode.PercentOutput, 0.0);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
