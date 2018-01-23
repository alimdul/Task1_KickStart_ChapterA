package by.pivovarevich.task1.action;

import by.pivovarevich.task1.entity.EntityPlane;
import by.pivovarevich.task1.exception.IncorrectInputParametersException;

import java.util.ArrayList;
import java.util.List;

public class FindingAngleBetweenPlanes {

    private static final double COEFFICIENT_A2 = 1;
    private static final double COEFFICIENT_B2 = 0;
    private static final double COEFFICIENT_C2 = 0;

    private double coefficientA_1;
    private double coefficientB_1;
    private double coefficientC_1;

    private CheckForWhetherPointsFormPlane checkForWhetherPointsFormPlane = new CheckForWhetherPointsFormPlane();
    private List<Double> coefficientList = new ArrayList<>();
    private double cosAngle;

    public List<Double> findingCoefficients(EntityPlane plane) throws IncorrectInputParametersException {

        if (plane == null || (!checkForWhetherPointsFormPlane.pointsFormPlane(plane.getPoint1(), plane.getPoint2(), plane.getPoint3()))){
            throw new IncorrectInputParametersException("Incorrect input parameters! These points do not form a plane");
        }

        coefficientA_1 = ((plane.getPoint2().getY() - plane.getPoint1().getY()) *
                (plane.getPoint3().getZ() - plane.getPoint1().getZ())) -
                (((plane.getPoint2().getZ() - plane.getPoint1().getZ())) *
                        (plane.getPoint3().getY() - plane.getPoint1().getY()));
        if(coefficientIcMinusNull(coefficientA_1)) {
            coefficientA_1 = 0;
        }
        coefficientList.add(coefficientA_1);

        coefficientB_1 = - (((plane.getPoint2().getX() - plane.getPoint1().getX()) *
                (plane.getPoint3().getZ() - plane.getPoint1().getZ())) -
                (((plane.getPoint2().getZ() - plane.getPoint1().getZ())) *
                        (plane.getPoint3().getX() - plane.getPoint1().getX())));
        if(coefficientIcMinusNull(coefficientB_1)) {
            coefficientB_1 = 0;
        }
        coefficientList.add(coefficientB_1);

        coefficientC_1 = ((plane.getPoint2().getX() - plane.getPoint1().getX()) *
                (plane.getPoint3().getY() - plane.getPoint1().getY())) -
                (((plane.getPoint2().getY() - plane.getPoint1().getY())) *
                        (plane.getPoint3().getX() - plane.getPoint1().getX()));
        if(coefficientIcMinusNull(coefficientC_1)) {
            coefficientC_1 = 0;
        }
        coefficientList.add(coefficientC_1);

        return coefficientList;
    }

    public double findingAngleBetweenPlaneAndCoordinatePlaneYOZ(EntityPlane plane) throws IncorrectInputParametersException {

        if (plane == null || (!checkForWhetherPointsFormPlane.pointsFormPlane(plane.getPoint1(), plane.getPoint2(), plane.getPoint3()))){
            throw new IncorrectInputParametersException("Incorrect input parameters! These points do not form a plane");
        }

        findingCoefficients(plane);

        cosAngle = (Math.abs(coefficientA_1*COEFFICIENT_A2 + coefficientB_1*COEFFICIENT_B2 + coefficientC_1*COEFFICIENT_C2)) /
                ((Math.sqrt(Math.pow(coefficientA_1, 2) + Math.pow(coefficientB_1, 2) + Math.pow(coefficientC_1, 2))) *
                        (Math.sqrt(Math.pow(COEFFICIENT_A2, 2) + Math.pow(COEFFICIENT_B2, 2) + Math.pow(COEFFICIENT_C2, 2))));

        return Math.rint(100.0 * (Math.toDegrees(cosAngle)) / 100.0);
    }

    public boolean coefficientIcMinusNull(double coefficient) {
        return coefficient == -0;
    }
}
