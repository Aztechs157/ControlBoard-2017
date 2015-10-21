
package org.usfirst.frc.team157.robot.commands;

import org.usfirst.frc.team157.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class MotorCommand extends Command {

    public MotorCommand() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.motorSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        System.out.println("MotorCommand.initialize");
        Robot.motorSubsystem.setVoltage(6.0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        //System.out.println("MotorCommand.execute");
        Robot.motorSubsystem.setVoltage(6.0);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
