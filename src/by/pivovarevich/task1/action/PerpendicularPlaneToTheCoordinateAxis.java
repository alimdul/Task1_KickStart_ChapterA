package by.pivovarevich.task1.action;

import by.pivovarevich.task1.entity.EntityPlane;
import by.pivovarevich.task1.exception.IncorrectInputParametersException;

import java.util.ArrayList;
import java.util.List;

public class PerpendicularPlaneToTheCoordinateAxis {

    private static final int NUMBER_OF_COEFFICIENT_A = 0;
    private static final int NUMBER_OF_COEFFICIENT_B = 1;
    private static final int NUMBER_OF_COEFFICIENT_C = 2;

    private double coefficientA;
    private double coefficientB;
    private double coefficientC;

    private CheckForWhetherPointsFormPlane checkForWhetherPointsFormPlane = new CheckForWhetherPointsFormPlane();
    private FindingAngleBetweenPlanes findingAngleBetweenPlanes = new FindingAngleBetweenPlanes();
    private List<Double> coefficientList = new ArrayList<>();

    public boolean isPlanePerpendicularToCoordinateAxisOx(EntityPlane plane) throws IncorrectInputParametersException {

        if (plane == null || (!checkForWhetherPointsFormPlane.pointsFormPlane(plane.getPoint1(), plane.getPoint2(), plane.getPoint3()))){
            throw new IncorrectInputParametersException("Incorrect input parameters! These points do not form a plane");
        }

        coefficientList = findingAngleBetweenPlanes.findingCoefficients(plane);
        coefficientA = coefficientList.get(NUMBER_OF_COEFFICIENT_A);
        coefficientB = coefficientList.get(NUMBER_OF_COEFFICIENT_B);
        coefficientC = coefficientList.get(NUMBER_OF_COEFFICIENT_C);

        if(coefficientA != 0 && coefficientB == 0 && coefficientC == 0) {
            return true;
        }
        return false;
    }
}
