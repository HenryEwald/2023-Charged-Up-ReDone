
package frc.robot.commands;

import java.util.function.DoubleSupplier;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.Wrist;

public class SetWrist extends Command {

    private final Wrist m_wrist;
    private double m_setpoint;

    public SetWrist(Wrist subsystem) {
        this(0, subsystem);
    }

    public SetWrist(double setpoint, Wrist subsystem) {
        super();
        this.m_setpoint = setpoint;

        m_setpoint = setpoint;

        m_wrist = subsystem;
        addRequirements(m_wrist);

    }

    @Override
    public void initialize() {
        m_wrist.enable();
        m_wrist.setSetpoint(m_setpoint);

    }

    @Override
    public void execute() {
    }

    @Override
    public boolean isFinished() {
        return m_wrist.getController().atSetpoint();

    }

    @Override
    public void end(boolean interrupted) {

    }

}
