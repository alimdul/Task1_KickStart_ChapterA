package by.pivovarevich.task1.validation;

import by.pivovarevich.task1.entity.EntityPlane;
import by.pivovarevich.task1.entity.EntityPoint;
import by.pivovarevich.task1.exception.IncorrectInputParametersException;

import java.util.List;

public class InputParameterValidation {

    private static final int NUMBER_OF_COORDINATES = 9;

    public static void nullParameter(EntityPlane plane) throws IncorrectInputParametersException {
        if (plane == null) {
            throw new IncorrectInputParametersException("Incorrect input parameters!");
        }
    }

    public static void nullParameter(List<Double> list) throws IncorrectInputParametersException {
        if (list == null || list.size() != NUMBER_OF_COORDINATES) {
            throw new IncorrectInputParametersException("Incorrect input parameters!");
        }
    }

    public static void nullParameter(String string) throws IncorrectInputParametersException {
        if (string == null) {
            throw new IncorrectInputParametersException("Incorrect input parameters!");
        }
    }

    public static void nullParameter(EntityPoint point1, EntityPoint point2, EntityPoint point3) throws IncorrectInputParametersException {
        if (point1 == null || point2 == null || point3 == null) {
            throw new IncorrectInputParametersException("Incorrect input parameters!");
        }
    }

}
