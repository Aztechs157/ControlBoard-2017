
package org.usfirst.frc.team157.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

import org.usfirst.frc.team157.robot.commands.ExampleCommand;
import org.usfirst.frc.team157.robot.commands.MotorCommand;
import org.usfirst.frc.team157.robot.subsystems.ExampleSubsystem;
import org.usfirst.frc.team157.robot.subsystems.MotorSubsystem;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static final ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
	public static final MotorSubsystem motorSubsystem = new MotorSubsystem();
	public static OI oi;

    public static Command autonomousCommand;
    public static Command motorCommand;

    public static NetworkTable dataTable;
    
    public static int count = 0;
    public static int value = 0;
    
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        System.out.println("Robot.robotInit");
        
		oi = new OI();
        // instantiate the command used for the autonomous period
        //autonomousCommand = new ExampleCommand();
        //motorCommand = new MotorCommand();
        
        dataTable = NetworkTable.getTable("datatable");
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
        System.out.println("Robot.autonomousInit");
        
        // schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
        System.out.println("Robot.teleopInit");

        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
        if (motorCommand != null) 
        {
            System.out.println("motorCommand.start");
            motorCommand.start();
        }
        else
        {
            System.out.println("BUG CHECK: Robot.teleopInit -- motorCommand is null");
        }
        
        count = 0;
        value = 0;
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit()
    {
        System.out.println("Robot.disabledInit");
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        //System.out.println("Robot.teleopPeriodic");
        Scheduler.getInstance().run();
        
        count++;
        if (count > 500)
        {
            count = 0;
            value++;
            dataTable.putNumber("value", value);
        }
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}


