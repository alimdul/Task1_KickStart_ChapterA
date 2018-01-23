package test.by.pivovarevich.task1.action;

import by.pivovarevich.task1.action.FindingAngleBetweenPlanes;
import by.pivovarevich.task1.entity.EntityPlane;
import by.pivovarevich.task1.entity.EntityPoint;
import by.pivovarevich.task1.exception.IncorrectInputParametersException;
import org.testng.annotations.Test;

public class FindingAngleBetweenPlanesExceptionTest {

    @Test(expectedExceptions = IncorrectInputParametersException.class)
    public void checkForWhetherPointsFormPlanePositiveTest() throws IncorrectInputParametersException {

        EntityPoint point1 = new EntityPoint(3.0, -7.0, 8.0);
        EntityPoint point2 = new EntityPoint(-5.0, 4.0, 1.0);
        EntityPoint point3 = new EntityPoint(27.0, -40.0, 29.0);

        EntityPlane plane = new EntityPlane(point1, point2, point3);

        FindingAngleBetweenPlanes findingAngleBetweenPlanes = new FindingAngleBetweenPlanes();
        findingAngleBetweenPlanes.findingAngleBetweenPlaneAndCoordinatePlaneYOZ(plane);
    }
}