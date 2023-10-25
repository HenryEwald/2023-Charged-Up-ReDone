
package frc.robot;

import frc.robot.commands.*;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command.InterruptionBehavior;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.subsystems.*;

public class RobotContainer {

  private static RobotContainer m_robotContainer = new RobotContainer();

  public final Intake m_intake = new Intake();
  public final Wrist m_wrist = new Wrist();
  public final Arm m_arm = new Arm();
  public final DriveTrain m_driveTrain = new DriveTrain();

  private final Joystick joystick1 = new Joystick(0);

  SendableChooser<Command> m_chooser = new SendableChooser<>();

  private RobotContainer() {

    SmartDashboard.putData("Autonomous Command", new AutonomousCommand());
    SmartDashboard.putData("Set Arm", new SetArm(m_arm));
    SmartDashboard.putData("Set Wrist", new SetWrist(m_wrist));

    configureButtonBindings();

    m_chooser.setDefaultOption("Autonomous Command", new AutonomousCommand());

    SmartDashboard.putData("Auto Mode", m_chooser);
  }

  public static RobotContainer getInstance() {
    return m_robotContainer;
  }

  private void configureButtonBindings() {

  }

  public Joystick getJoystick1() {
    return joystick1;
  }

  public Command getAutonomousCommand() {
    return m_chooser.getSelected();
  }

}
