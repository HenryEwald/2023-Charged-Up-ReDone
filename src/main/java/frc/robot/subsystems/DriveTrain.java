
package frc.robot.subsystems;

import frc.robot.commands.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

public class DriveTrain extends SubsystemBase {

    private WPI_TalonFX frontRightMotor;
    private WPI_TalonFX backRightMotor;
    private MotorControllerGroup rightControllerGroup;
    private WPI_TalonFX frontLeftMotor;
    private WPI_TalonFX backLeftMotor;
    private MotorControllerGroup leftControllerGroup;
    private DifferentialDrive differentialDrive;
    private AnalogGyro analogGyro1;

    public DriveTrain() {
        frontRightMotor = new WPI_TalonFX(0);

        backRightMotor = new WPI_TalonFX(1);

        rightControllerGroup = new MotorControllerGroup(frontRightMotor, backRightMotor);
        addChild("rightControllerGroup", rightControllerGroup);

        frontLeftMotor = new WPI_TalonFX(2);

        backLeftMotor = new WPI_TalonFX(3);

        leftControllerGroup = new MotorControllerGroup(frontLeftMotor, backLeftMotor);
        addChild("leftControllerGroup", leftControllerGroup);

        differentialDrive = new DifferentialDrive(leftControllerGroup, rightControllerGroup);
        addChild("differentialDrive", differentialDrive);
        differentialDrive.setSafetyEnabled(true);
        differentialDrive.setExpiration(0.1);
        differentialDrive.setMaxOutput(1.0);

        analogGyro1 = new AnalogGyro(1);
        addChild("AnalogGyro 1", analogGyro1);
        analogGyro1.setSensitivity(0.007);

    }

    @Override
    public void periodic() {

    }

    @Override
    public void simulationPeriodic() {

    }

}
