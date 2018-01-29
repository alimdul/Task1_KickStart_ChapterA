package test.by.pivovarevich.task1.action;

import by.pivovarevich.task1.action.FindAngleBetweenPlanes;
import by.pivovarevich.task1.entity.EntityPlane;
import by.pivovarevich.task1.entity.EntityPoint;
import by.pivovarevich.task1.exception.IncorrectInputParametersException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FindAngleBetweenPlanesTest {

    @Test(expectedExceptions = IncorrectInputParametersException.class)
    public void findAngleBetweenPlanesExceptionTest() throws IncorrectInputParametersException {

        EntityPlane plane = null;

        FindAngleBetweenPlanes findingAngleBetweenPlanes = new FindAngleBetweenPlanes();
        findingAngleBetweenPlanes.findAngleBetweenPlaneAndCoordinatePlaneYOZ(plane);
    }

    @Test
    public void findAngleBetweenPlanesPositiveTest() {

        double angle;

        EntityPoint point1 = new EntityPoint(0.0, 0.0, 0.0);
        EntityPoint point2 = new EntityPoint(1.0, 2.0, 3.0);
        EntityPoint point3 = new EntityPoint(-3.0, -2.0, -1.0);

        EntityPlane plane = new EntityPlane(point1, point2, point3);

        FindAngleBetweenPlanes findingAngleBetweenPlanes = new FindAngleBetweenPlanes();
        try {
            angle = findingAngleBetweenPlanes.findAngleBetweenPlaneAndCoordinatePlaneYOZ(plane);
            Assert.assertEquals(angle, 23.0);
        } catch (IncorrectInputParametersException e) {
            Assert.fail("Unexpected fail!");
        }
    }

}
