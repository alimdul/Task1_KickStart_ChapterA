package by.pivovarevich.task1.planeRepository;

import by.pivovarevich.task1.action.FindAngleBetweenPlanes;
import by.pivovarevich.task1.entity.EntityPlane;
import by.pivovarevich.task1.exception.IncorrectInputParametersException;

public class PlaneSpecificationByRangeOfAngle implements PlaneSpecificationImpl {

    private static final double MIN_ANGLE = 0.0;
    private static final double MAX_ANGLE = 45.0;

    private FindAngleBetweenPlanes findAngle = new FindAngleBetweenPlanes();

    @Override
    public boolean specified(EntityPlane plane) throws IncorrectInputParametersException {
        return (Double.compare(findAngle.findAngleBetweenPlaneAndCoordinatePlaneYOZ(plane), MIN_ANGLE) == 1 ||
                        Double.compare(findAngle.findAngleBetweenPlaneAndCoordinatePlaneYOZ(plane), MIN_ANGLE) == 0) &&
                        (Double.compare(findAngle.findAngleBetweenPlaneAndCoordinatePlaneYOZ(plane), MAX_ANGLE) == -1 ||
                        Double.compare(findAngle.findAngleBetweenPlaneAndCoordinatePlaneYOZ(plane), MAX_ANGLE) == 0);
    }
}
