package by.pivovarevich.task1.action;

import by.pivovarevich.task1.entity.EntityPlane;
import by.pivovarevich.task1.exception.IncorrectInputParametersException;
import by.pivovarevich.task1.validation.InputParameterValidation;

import java.util.ArrayList;
import java.util.List;

public class CheckForPerpendicularityOfPlaneToCoordinateAxis {

    private static final int NUMBER_COEFFICIENT_A = 0;
    private static final int NUMBER_COEFFICIENT_B = 1;
    private static final int NUMBER_COEFFICIENT_C = 2;

    public boolean isPlanePerpendicularToCoordinateAxisOx(EntityPlane plane) throws IncorrectInputParametersException {

        if(InputParameterValidation.nullParameter(plane)) {
            throw new IncorrectInputParametersException("Incorrect input parameters!");
        }

        List<Double> coefficientList = new FindAngleBetweenPlanes().findCoefficients(plane);
        double coefficientA = coefficientList.get(NUMBER_COEFFICIENT_A);
        double coefficientB = coefficientList.get(NUMBER_COEFFICIENT_B);
        double coefficientC = coefficientList.get(NUMBER_COEFFICIENT_C);

        if(coefficientA != 0 && coefficientB == 0 && coefficientC == 0) {
            return true;
        }
        return false;
    }
}
