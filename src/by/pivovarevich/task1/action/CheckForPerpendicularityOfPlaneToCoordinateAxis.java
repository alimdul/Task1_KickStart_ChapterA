package by.pivovarevich.task1.action;

import by.pivovarevich.task1.entity.EntityPlane;
import java.util.List;

public class CheckForPerpendicularityOfPlaneToCoordinateAxis {

    private static final int NUMBER_COEFFICIENT_A = 0;
    private static final int NUMBER_COEFFICIENT_B = 1;
    private static final int NUMBER_COEFFICIENT_C = 2;

    public boolean isPlanePerpendicularToCoordinateAxisOx(EntityPlane plane) {

        List<Double> coefficientList = new FindAngleBetweenPlanes().findCoefficients(plane);
        double coefficientA = coefficientList.get(NUMBER_COEFFICIENT_A);
        double coefficientB = coefficientList.get(NUMBER_COEFFICIENT_B);
        double coefficientC = coefficientList.get(NUMBER_COEFFICIENT_C);

        return coefficientA != 0 && coefficientB == 0 && coefficientC == 0;
    }
}
