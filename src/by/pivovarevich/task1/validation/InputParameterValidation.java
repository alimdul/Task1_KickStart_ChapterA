package by.pivovarevich.task1.validation;

import by.pivovarevich.task1.entity.EntityPoint;

import java.util.List;

public class InputParameterValidation {

    private static final int NUMBER_OF_COORDINATES = 9;

    public static boolean nullParameter(List<Double> list) {
        return list == null || list.size() != NUMBER_OF_COORDINATES;
    }

    public static boolean nullParameter(String string) {
        return string == null;
    }

    public static boolean nullParameter(EntityPoint point1, EntityPoint point2, EntityPoint point3) {
        return point1 == null || point2 == null || point3 == null;
    }
}
