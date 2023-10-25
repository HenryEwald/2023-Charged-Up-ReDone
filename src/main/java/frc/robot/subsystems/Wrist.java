
package frc.robot.subsystems;

import frc.robot.commands.*;
import edu.wpi.first.wpilibj2.command.PIDSubsystem;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.math.MathUtil;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;

public class Wrist extends PIDSubsystem {

    private Encoder wristEncoder;
    private WPI_TalonFX wristMotor;
    private static final double kP = 1.0;
    private static final double kI = 0.0;
    private static final double kD = 0.0;
    private static final double kF = 0.0;

    public Wrist() {
        super(new PIDController(kP, kI, kD));
        getController().setTolerance(0.2);

        wristEncoder = new Encoder(0, 1, false, EncodingType.k4X);
        addChild("wristEncoder", wristEncoder);
        wristEncoder.setDistancePerPulse(1.0);

        wristMotor = new WPI_TalonFX(5);

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
        return wristEncoder.getRate();

    }

    @Override
    public void useOutput(double output, double setpoint) {
        output += setpoint * kF;
        wristMotor.set(output);

    }

}
