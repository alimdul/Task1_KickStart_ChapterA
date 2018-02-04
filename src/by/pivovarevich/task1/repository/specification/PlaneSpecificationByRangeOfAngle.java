package by.pivovarevich.task1.repository.specification;

import by.pivovarevich.task1.action.FindAngleBetweenPlanes;
import by.pivovarevich.task1.entity.EntityPlane;

public class PlaneSpecificationByRangeOfAngle implements PlaneSpecification {

    private static final double MIN_ANGLE = 0.;
    private static final double MAX_ANGLE = 45.;

    @Override
    public boolean specified(EntityPlane plane) {
        FindAngleBetweenPlanes findAngle = new FindAngleBetweenPlanes();
        return (Double.compare(findAngle.findAngleBetweenPlaneAndCoordinatePlaneYOZ(plane), MIN_ANGLE) == 1 ||
                        Double.compare(findAngle.findAngleBetweenPlaneAndCoordinatePlaneYOZ(plane), MIN_ANGLE) == 0) &&
                        (Double.compare(findAngle.findAngleBetweenPlaneAndCoordinatePlaneYOZ(plane), MAX_ANGLE) == -1 ||
                        Double.compare(findAngle.findAngleBetweenPlaneAndCoordinatePlaneYOZ(plane), MAX_ANGLE) == 0);
    }
}
