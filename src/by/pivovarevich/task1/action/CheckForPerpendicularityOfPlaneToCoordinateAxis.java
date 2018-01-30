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

    private double coefficientA;
    private double coefficientB;
    private double coefficientC;

    private FindAngleBetweenPlanes findAngleBetweenPlanes;
    private List<Double> coefficientList = new ArrayList<>();

    public boolean isPlanePerpendicularToCoordinateAxisOx(EntityPlane plane) throws IncorrectInputParametersException {

        InputParameterValidation.nullParameter(plane);
        findAngleBetweenPlanes = new FindAngleBetweenPlanes();

        coefficientList = findAngleBetweenPlanes.findCoefficients(plane);
        coefficientA = coefficientList.get(NUMBER_COEFFICIENT_A);
        coefficientB = coefficientList.get(NUMBER_COEFFICIENT_B);
        coefficientC = coefficientList.get(NUMBER_COEFFICIENT_C);

        if(coefficientA != 0 && coefficientB == 0 && coefficientC == 0) {
            return true;
        }
        return false;
    }
}
