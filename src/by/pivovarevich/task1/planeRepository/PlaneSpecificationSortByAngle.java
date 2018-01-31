package by.pivovarevich.task1.planeRepository;

import by.pivovarevich.task1.action.FindAngleBetweenPlanes;
import by.pivovarevich.task1.entity.EntityPlane;
import by.pivovarevich.task1.exception.IncorrectInputParametersException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;

public class PlaneSpecificationSortByAngle implements Comparator<EntityPlane> {

    private static final Logger LOGGER = LogManager.getLogger();

    private FindAngleBetweenPlanes findAngle = new FindAngleBetweenPlanes();
    private double angleOfPlane1;
    private double angleOfPlane2;

    @Override
    public int compare(EntityPlane o1, EntityPlane o2) {
        try {
            angleOfPlane1 = findAngle.findAngleBetweenPlaneAndCoordinatePlaneYOZ(o1);
            angleOfPlane2 = findAngle.findAngleBetweenPlaneAndCoordinatePlaneYOZ(o2);
        } catch (IncorrectInputParametersException e) {
            LOGGER.log(Level.ERROR, "- Sorting can not be performed!", e);
        }
        if(angleOfPlane1 > angleOfPlane2) {
            return 1;
        }
        else if(angleOfPlane1 < angleOfPlane2) {
            return -1;
        }
        else {
            return 0;
        }
    }
}
