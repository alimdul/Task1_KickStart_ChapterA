package by.pivovarevich.task1.action;

import by.pivovarevich.task1.entity.EntityPlane;
import by.pivovarevich.task1.exception.IncorrectInputParametersException;
import by.pivovarevich.task1.validation.InputParameterValidation;

import java.util.ArrayList;
import java.util.List;

public class FindAngleBetweenPlanes {

    private static final double COEFFICIENT_A2 = 1;
    private static final double COEFFICIENT_B2 = 0;
    private static final double COEFFICIENT_C2 = 0;

    private double coefficientA1;
    private double coefficientB1;
    private double coefficientC1;

    private List<Double> coefficientList;
    private double cosAngle;

    public List<Double> findCoefficients(EntityPlane plane) throws IncorrectInputParametersException {

        InputParameterValidation.nullParameter(plane);
        coefficientList = new ArrayList<>();

        coefficientA1 = ((plane.getPoint2().getY() - plane.getPoint1().getY()) *
                (plane.getPoint3().getZ() - plane.getPoint1().getZ())) -
                (((plane.getPoint2().getZ() - plane.getPoint1().getZ())) *
                        (plane.getPoint3().getY() - plane.getPoint1().getY()));
        if(coefficientA1 == -0) {
            coefficientA1 = 0;
        }
        coefficientList.add(coefficientA1);

        coefficientB1 = - (((plane.getPoint2().getX() - plane.getPoint1().getX()) *
                (plane.getPoint3().getZ() - plane.getPoint1().getZ())) -
                (((plane.getPoint2().getZ() - plane.getPoint1().getZ())) *
                        (plane.getPoint3().getX() - plane.getPoint1().getX())));
        if(coefficientB1 == -0) {
            coefficientB1 = 0;
        }
        coefficientList.add(coefficientB1);

        coefficientC1 = ((plane.getPoint2().getX() - plane.getPoint1().getX()) *
                (plane.getPoint3().getY() - plane.getPoint1().getY())) -
                (((plane.getPoint2().getY() - plane.getPoint1().getY())) *
                        (plane.getPoint3().getX() - plane.getPoint1().getX()));
        if(coefficientC1 == -0) {
            coefficientC1 = 0;
        }
        coefficientList.add(coefficientC1);

        return coefficientList;
    }

    public double findAngleBetweenPlaneAndCoordinatePlaneYOZ(EntityPlane plane) throws IncorrectInputParametersException {

        InputParameterValidation.nullParameter(plane);

        findCoefficients(plane);

        cosAngle = (Math.abs(coefficientA1 *COEFFICIENT_A2 + coefficientB1 *COEFFICIENT_B2 + coefficientC1 *COEFFICIENT_C2)) /
                ((Math.sqrt(Math.pow(coefficientA1, 2) + Math.pow(coefficientB1, 2) + Math.pow(coefficientC1, 2))) *
                        (Math.sqrt(Math.pow(COEFFICIENT_A2, 2) + Math.pow(COEFFICIENT_B2, 2) + Math.pow(COEFFICIENT_C2, 2))));

        return Math.rint(100.0 * (Math.toDegrees(cosAngle)) / 100.0);
    }
}
