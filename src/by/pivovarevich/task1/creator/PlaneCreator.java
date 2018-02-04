package by.pivovarevich.task1.creator;

import by.pivovarevich.task1.entity.PlaneHolder;
import by.pivovarevich.task1.util.IdGenerator;
import by.pivovarevich.task1.observer.PlaneObserver;
import by.pivovarevich.task1.repository.PlaneRepository;
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

    public enum Coordinate {
        X1, Y1, Z1, X2, Y2, Z2, X3, Y3, Z3
    }

    public EntityPlane createPlane(List<Double> coordinatesString) throws IncorrectInputParametersException {

        if (InputParameterValidation.nullParameter(coordinatesString)) {
            throw new IncorrectInputParametersException("Incorrect input parameters!");
        }

        EntityPoint point1 = new EntityPoint(coordinatesString.get(Coordinate.X1.ordinal()),
                    coordinatesString.get(Coordinate.Y1.ordinal()),
                    coordinatesString.get(Coordinate.Z1.ordinal()));
        EntityPoint point2 = new EntityPoint(coordinatesString.get(Coordinate.X2.ordinal()),
                coordinatesString.get(Coordinate.Y2.ordinal()),
                coordinatesString.get(Coordinate.Z2.ordinal()));
        EntityPoint point3 = new EntityPoint(coordinatesString.get(Coordinate.X3.ordinal()),
                coordinatesString.get(Coordinate.Y3.ordinal()),
                coordinatesString.get(Coordinate.Z3.ordinal()));

        if(new CheckForThreePointsFormPlane().isPlane(point1, point2, point3)) {
            EntityPlane newPlane = new EntityPlane(point1, point2, point3);
            if(!PlaneRepository.getPlaneRepository().planeExist(newPlane)) {
                newPlane.setPlaneId(IdGenerator.countPlaneIdentifier());
                newPlane.addObserver(new PlaneObserver());
                PlaneHolder.getPlaneHolder().add(newPlane);
                PlaneRepository.getPlaneRepository().add(newPlane);
                return newPlane;
            }
            return null;
        }
        else {
            LOGGER.log(Level.WARN, "- These points: " + point1.toString() + point2.toString() + point3.toString() +
                    " do not form a plane.");
            return null;
        }
    }

}
