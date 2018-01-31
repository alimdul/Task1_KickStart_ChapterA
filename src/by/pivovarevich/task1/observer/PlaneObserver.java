package by.pivovarevich.task1.observer;

import by.pivovarevich.task1.entity.EntityPlane;
import by.pivovarevich.task1.entity.PlaneHolder;
import by.pivovarevich.task1.exception.IncorrectInputParametersException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Observable;
import java.util.Observer;

public class PlaneObserver implements Observer {

    private static final Logger LOGGER = LogManager.getLogger();

    private EntityPlane plane;
    private PlaneHolder planeHolder = PlaneHolder.getPlaneHolder();

    public PlaneObserver(EntityPlane plane) {
        this.plane = plane;
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o == plane) {
            try {
                planeHolder.changeParameters(plane);
            } catch (IncorrectInputParametersException e) {
                LOGGER.log(Level.ERROR, "- Parameters of plane " + plane.toString() + " are not changed!");
            }
        }
    }
}
