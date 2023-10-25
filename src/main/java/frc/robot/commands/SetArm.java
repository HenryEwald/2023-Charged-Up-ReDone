

package frc.robot.commands;

import java.util.function.DoubleSupplier;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.Arm;


public class SetArm extends Command {
    private final Arm m_arm;
    private double m_setpoint;
    
    public SetArm(Arm subsystem) {
        this(0, subsystem);
    }

    public SetArm(double setpoint, Arm subsystem) {
        super();
        this.m_setpoint = setpoint;

        m_setpoint = setpoint;

        m_arm = subsystem;
        addRequirements(m_arm);

    }

    @Override
    public void initialize() {
        m_arm.enable();
        m_arm.setSetpoint(m_setpoint);
    }

    @Override
    public void execute() {
    }

    @Override
    public boolean isFinished() {
        return m_arm.getController().atSetpoint();
    }

    @Override
    public void end(boolean interrupted) {
    
    }
   
}
