package by.pivovarevich.task1.action;

import by.pivovarevich.task1.entity.EntityPlane;

import java.util.ArrayList;
import java.util.List;

public class FindAngleBetweenPlanes {

    private static final int NUMBER_COEFFICIENT_A1 = 0;
    private static final int NUMBER_COEFFICIENT_B1 = 1;
    private static final int NUMBER_COEFFICIENT_C1 = 2;

    private static final double COEFFICIENT_A2 = 1;
    private static final double COEFFICIENT_B2 = 0;
    private static final double COEFFICIENT_C2 = 0;

    public List<Double> findCoefficients(EntityPlane plane) {

        List<Double> coefficientList = new ArrayList<>();

        double coefficientA1 = ((plane.getPoint2().getY() - plane.getPoint1().getY()) *
                (plane.getPoint3().getZ() - plane.getPoint1().getZ())) -
                (((plane.getPoint2().getZ() - plane.getPoint1().getZ())) *
                        (plane.getPoint3().getY() - plane.getPoint1().getY()));
        if(coefficientA1 == -0) {
            coefficientA1 = 0;
        }
        coefficientList.add(coefficientA1);

        double coefficientB1 = - (((plane.getPoint2().getX() - plane.getPoint1().getX()) *
                (plane.getPoint3().getZ() - plane.getPoint1().getZ())) -
                (((plane.getPoint2().getZ() - plane.getPoint1().getZ())) *
                        (plane.getPoint3().getX() - plane.getPoint1().getX())));
        if(coefficientB1 == -0) {
            coefficientB1 = 0;
        }
        coefficientList.add(coefficientB1);

        double coefficientC1 = ((plane.getPoint2().getX() - plane.getPoint1().getX()) *
                (plane.getPoint3().getY() - plane.getPoint1().getY())) -
                (((plane.getPoint2().getY() - plane.getPoint1().getY())) *
                        (plane.getPoint3().getX() - plane.getPoint1().getX()));
        if(coefficientC1 == -0) {
            coefficientC1 = 0;
        }
        coefficientList.add(coefficientC1);

        return coefficientList;
    }

    public double findAngleBetweenPlaneAndCoordinatePlaneYOZ(EntityPlane plane) {

        List<Double> coefficientList = new FindAngleBetweenPlanes().findCoefficients(plane);
        double coefficientA1 = coefficientList.get(NUMBER_COEFFICIENT_A1);
        double coefficientB1 = coefficientList.get(NUMBER_COEFFICIENT_B1);
        double coefficientC1 = coefficientList.get(NUMBER_COEFFICIENT_C1);

        double cosAngle = (Math.abs(coefficientA1 *COEFFICIENT_A2 + coefficientB1 *COEFFICIENT_B2 + coefficientC1 *COEFFICIENT_C2)) /
                ((Math.sqrt(Math.pow(coefficientA1, 2) + Math.pow(coefficientB1, 2) + Math.pow(coefficientC1, 2))) *
                        (Math.sqrt(Math.pow(COEFFICIENT_A2, 2) + Math.pow(COEFFICIENT_B2, 2) + Math.pow(COEFFICIENT_C2, 2))));

        return Math.round(Math.toDegrees(cosAngle) * 10_000d) / 10_000d;
    }
}
