// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class navXCommand extends CommandBase {
  /** Creates a new navXCommand. */
  public navXCommand() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.mnavXSub);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    RobotContainer.mnavXSub.calibrateNavX();
    RobotContainer.mnavXSub.resetNavX();

/*
    if(RobotContainer.mnavXSub.getNavXAngle() < 10.0){
      RobotContainer.mnavXSub.setMotor();
      System.out.println("NavX reading: "+RobotContainer.mnavXSub.getNavXAngle());
    }
    else{
      RobotContainer.mnavXSub.stopMotor();
    }
  
  */
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(RobotContainer.mnavXSub.getNavXAngle() < 90.0){
      RobotContainer.mnavXSub.setMotor(0.4);
      System.out.println("NavX reading: "+RobotContainer.mnavXSub.getNavXAngle());
    }
    else if(RobotContainer.mnavXSub.getNavXAngle() >45.0){
      RobotContainer.mnavXSub.setMotor(-0.4);

    }
    else{
      RobotContainer.mnavXSub.stopMotor();
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.mnavXSub.stopMotor();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
