package by.pivovarevich.task1.creator;

import by.pivovarevich.task1.entity.PlaneHolder;
import by.pivovarevich.task1.util.IdGenerator;
import by.pivovarevich.task1.observer.PlaneObserver;
import by.pivovarevich.task1.planeRepository.PlaneRepository;
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

    private CheckForThreePointsFormPlane checkForThreePointsFormPlane = new CheckForThreePointsFormPlane();
    private EntityPlane newPlane;
    private PlaneObserver planeObserver;
    private EntityPoint point1;
    private EntityPoint point2;
    private EntityPoint point3;

    public enum Coordinate {
        X1(0), Y1(1), Z1(2), X2(3), Y2(4), Z2(5), X3(6), Y3(7), Z3(8);

        private int coordinatePosition;

        Coordinate(int coordinatePosition) {
            this.coordinatePosition = coordinatePosition;
        }

        public int getCoordinatePosition() {
            return coordinatePosition;
        }
    }

    public EntityPlane createPlane(List<Double> coordinatesString) throws IncorrectInputParametersException {

        InputParameterValidation.nullParameter(coordinatesString);

        point1 = new EntityPoint(coordinatesString.get(Coordinate.X1.getCoordinatePosition()),
                    coordinatesString.get(Coordinate.Y1.getCoordinatePosition()),
                    coordinatesString.get(Coordinate.Z1.getCoordinatePosition()));
        point2 = new EntityPoint(coordinatesString.get(Coordinate.X2.getCoordinatePosition()),
                coordinatesString.get(Coordinate.Y2.getCoordinatePosition()),
                coordinatesString.get(Coordinate.Z2.getCoordinatePosition()));
        point3 = new EntityPoint(coordinatesString.get(Coordinate.X3.getCoordinatePosition()),
                coordinatesString.get(Coordinate.Y3.getCoordinatePosition()),
                coordinatesString.get(Coordinate.Z3.getCoordinatePosition()));

        if(checkForThreePointsFormPlane.pointsFormPlane(point1, point2, point3)) {
            newPlane = new EntityPlane(point1, point2, point3);
            planeObserver = new PlaneObserver(newPlane);
            newPlane.setId(IdGenerator.countPlaneIdentifier());
            newPlane.addObserver(planeObserver);
            PlaneHolder.getPlaneHolder().add(newPlane);
            PlaneRepository.getPlaneRepository().add(newPlane);
            return newPlane;
        }
        else {
            LOGGER.log(Level.WARN, "- These points: " + point1.toString() + point2.toString() + point3.toString() +
                    " do not form a plane.");
            return null;
        }
    }

}
