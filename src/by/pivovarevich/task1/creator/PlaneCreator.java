package by.pivovarevich.task1.creator;

import by.pivovarevich.task1.action.CheckForWhetherPointsFormPlane;
import by.pivovarevich.task1.entity.EntityPlane;
import by.pivovarevich.task1.entity.EntityPoint;
import by.pivovarevich.task1.exception.IncorrectInputParametersException;

import java.util.List;

public class PlaneCreator {

    private static final int NUMBER_OF_COORDINATES = 9;

    private static final int X1 = 0;
    private static final int Y1 = 1;
    private static final int Z1 = 2;
    private static final int X2 = 3;
    private static final int Y2 = 4;
    private static final int Z2 = 5;
    private static final int X3 = 6;
    private static final int Y3 = 7;
    private static final int Z3 = 8;

    private CheckForWhetherPointsFormPlane checkForWhetherPointsFormPlane = new CheckForWhetherPointsFormPlane();
    private EntityPoint point1;
    private EntityPoint point2;
    private EntityPoint point3;

    public EntityPlane createPlane(List<Double> coordinatesString) throws IncorrectInputParametersException {

        if(coordinatesString == null || coordinatesString.size() != NUMBER_OF_COORDINATES) {
            throw new IncorrectInputParametersException("Incorrect input parameters");
        }

        point1 = new EntityPoint(coordinatesString.get(X1), coordinatesString.get(Y1), coordinatesString.get(Z1));
        point2 = new EntityPoint(coordinatesString.get(X2), coordinatesString.get(Y2), coordinatesString.get(Z2));
        point3 = new EntityPoint(coordinatesString.get(X3), coordinatesString.get(Y3), coordinatesString.get(Z3));

        if(!checkForWhetherPointsFormPlane.pointsFormPlane(point1, point2, point3)) {
            throw new IncorrectInputParametersException("Incorrect input parameters. These points do not form a plane.");
        }

        return new EntityPlane(point1, point2, point3);
    }
}
