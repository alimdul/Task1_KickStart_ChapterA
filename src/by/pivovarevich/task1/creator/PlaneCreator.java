package by.pivovarevich.task1.creator;

import by.pivovarevich.task1.entity.PlaneHolderSingleton;
import by.pivovarevich.task1.identifierCounter.CountIdentifier;
import by.pivovarevich.task1.observer.PlaneObserver;
import by.pivovarevich.task1.validation.CheckForThreePointsFormPlane;
import by.pivovarevich.task1.entity.EntityPlane;
import by.pivovarevich.task1.entity.EntityPoint;
import by.pivovarevich.task1.exception.IncorrectInputParametersException;
import by.pivovarevich.task1.validation.InputParameterValidation;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class PlaneCreator {

    private static final Logger LOGGER = LogManager.getLogger();

    private static final int X1 = 0;
    private static final int Y1 = 1;
    private static final int Z1 = 2;
    private static final int X2 = 3;
    private static final int Y2 = 4;
    private static final int Z2 = 5;
    private static final int X3 = 6;
    private static final int Y3 = 7;
    private static final int Z3 = 8;

    private PlaneHolderSingleton planeHolderSingleton = PlaneHolderSingleton.getPlaneHolderSingleton();
    private CheckForThreePointsFormPlane checkForThreePointsFormPlane = new CheckForThreePointsFormPlane();
    private EntityPlane newPlane;
    private PlaneObserver planeObserver;
    private EntityPoint point1;
    private EntityPoint point2;
    private EntityPoint point3;

    public EntityPlane createPlane(List<Double> coordinatesString) throws IncorrectInputParametersException {

        InputParameterValidation.nullParameter(coordinatesString);

        point1 = new EntityPoint(coordinatesString.get(X1), coordinatesString.get(Y1), coordinatesString.get(Z1));
        point2 = new EntityPoint(coordinatesString.get(X2), coordinatesString.get(Y2), coordinatesString.get(Z2));
        point3 = new EntityPoint(coordinatesString.get(X3), coordinatesString.get(Y3), coordinatesString.get(Z3));

        if(checkForThreePointsFormPlane.pointsFormPlane(point1, point2, point3)) {
            newPlane = new EntityPlane(point1, point2, point3);
            planeObserver = new PlaneObserver(newPlane);
            newPlane.setId(CountIdentifier.countPlaneIdentifier());
            newPlane.addObserver(planeObserver);
            planeHolderSingleton.addPlane(newPlane);
            return newPlane;
        }
        else {
            LOGGER.log(Level.WARN, "- These points: " + point1.toString() + point2.toString() + point3.toString() +
                    " do not form a plane.");
            return null;
        }
    }

}
