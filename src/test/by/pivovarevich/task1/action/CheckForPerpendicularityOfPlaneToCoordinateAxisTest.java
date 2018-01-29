package test.by.pivovarevich.task1.action;

import by.pivovarevich.task1.action.CheckForPerpendicularityOfPlaneToCoordinateAxis;
import by.pivovarevich.task1.entity.EntityPlane;
import by.pivovarevich.task1.entity.EntityPoint;
import by.pivovarevich.task1.exception.IncorrectInputParametersException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckForPerpendicularityOfPlaneToCoordinateAxisTest {

    @Test(expectedExceptions = IncorrectInputParametersException.class)
    public void checkForPerpendicularityOfPlaneToCoordinateAxisExceptionTest() throws IncorrectInputParametersException {

        EntityPlane plane = null;

        CheckForPerpendicularityOfPlaneToCoordinateAxis perpendicularPlaneToTheCoordinateAxis = new CheckForPerpendicularityOfPlaneToCoordinateAxis();
        perpendicularPlaneToTheCoordinateAxis.isPlanePerpendicularToCoordinateAxisOx(plane);
    }

    @Test
    public void checkForPerpendicularityOfPlaneToCoordinateAxisNegativeTest() {

        boolean isPerpendicular;

        EntityPoint point1 = new EntityPoint(1.0, 0.0, -2.0);
        EntityPoint point2 = new EntityPoint(1.0, 0.0, 3.0);
        EntityPoint point3 = new EntityPoint(0.0, 0.0, 1.0);

        EntityPlane plane = new EntityPlane(point1, point2, point3);

        CheckForPerpendicularityOfPlaneToCoordinateAxis perpendicularPlaneToTheCoordinateAxis = new CheckForPerpendicularityOfPlaneToCoordinateAxis();
        try {
            isPerpendicular = perpendicularPlaneToTheCoordinateAxis.isPlanePerpendicularToCoordinateAxisOx(plane);
            Assert.assertEquals(isPerpendicular, false);
        } catch (IncorrectInputParametersException e) {
            Assert.fail("Unexpected fail!");
        }
    }

    @Test
    public void checkForPerpendicularityOfPlaneToCoordinateAxisPositiveTest() {

        boolean isPerpendicular;

        EntityPoint point1 = new EntityPoint(0.0, 1.0, 0.0);
        EntityPoint point2 = new EntityPoint(0.0, 1.0, 3.0);
        EntityPoint point3 = new EntityPoint(0.0, -2.0, 1.0);

        EntityPlane plane = new EntityPlane(point1, point2, point3);

        CheckForPerpendicularityOfPlaneToCoordinateAxis perpendicularPlaneToTheCoordinateAxis = new CheckForPerpendicularityOfPlaneToCoordinateAxis();
        try {
            isPerpendicular = perpendicularPlaneToTheCoordinateAxis.isPlanePerpendicularToCoordinateAxisOx(plane);
            Assert.assertEquals(isPerpendicular, true);
        } catch (IncorrectInputParametersException e) {
            Assert.fail("Unexpected fail!");
        }
    }

}
