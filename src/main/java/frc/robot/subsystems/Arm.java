
package frc.robot.subsystems;

import frc.robot.commands.*;
import edu.wpi.first.wpilibj2.command.PIDSubsystem;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.math.MathUtil;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj.AnalogPotentiometer;

public class Arm extends PIDSubsystem {

    private AnalogPotentiometer armPotentiometer;
    private WPI_TalonFX armMotor;
    private static final double kP = 1.0;
    private static final double kI = 0.0;
    private static final double kD = 0.0;
    private static final double kF = 0.0;

    public Arm() {
        super(new PIDController(kP, kI, kD));
        getController().setTolerance(0.2);

        armPotentiometer = new AnalogPotentiometer(0, 1.0, 0.0);
        addChild("armPotentiometer", armPotentiometer);

        armMotor = new WPI_TalonFX(4);

    }

    @Override
    public void periodic() {
        super.periodic();

    }

    @Override
    public void simulationPeriodic() {

    }

    @Override
    public double getMeasurement() {
        return armPotentiometer.get();

    }

    @Override
    public void useOutput(double output, double setpoint) {
        output += setpoint * kF;
        armMotor.set(output);

    }

}
