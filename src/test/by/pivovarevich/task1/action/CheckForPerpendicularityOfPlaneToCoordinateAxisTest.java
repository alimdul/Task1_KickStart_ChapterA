package test.by.pivovarevich.task1.action;

import by.pivovarevich.task1.action.CheckForPerpendicularityOfPlaneToCoordinateAxis;
import by.pivovarevich.task1.entity.EntityPlane;
import by.pivovarevich.task1.entity.EntityPoint;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckForPerpendicularityOfPlaneToCoordinateAxisTest {

    @Test
    public void checkForPerpendicularityOfPlaneToCoordinateAxisNegativeTest() {

        EntityPoint point1 = new EntityPoint(1.0, 0.0, -2.0);
        EntityPoint point2 = new EntityPoint(1.0, 0.0, 3.0);
        EntityPoint point3 = new EntityPoint(0.0, 0.0, 1.0);
        EntityPlane plane = new EntityPlane(point1, point2, point3);

        boolean isPerpendicular = new CheckForPerpendicularityOfPlaneToCoordinateAxis().isPlanePerpendicularToCoordinateAxisOx(plane);
        Assert.assertEquals(isPerpendicular, false);
    }

    @Test
    public void checkForPerpendicularityOfPlaneToCoordinateAxisPositiveTest() {

        EntityPoint point1 = new EntityPoint(0.0, 1.0, 0.0);
        EntityPoint point2 = new EntityPoint(0.0, 1.0, 3.0);
        EntityPoint point3 = new EntityPoint(0.0, -2.0, 1.0);
        EntityPlane plane = new EntityPlane(point1, point2, point3);

        boolean isPerpendicular = new CheckForPerpendicularityOfPlaneToCoordinateAxis().isPlanePerpendicularToCoordinateAxisOx(plane);
        Assert.assertEquals(isPerpendicular, true);
    }

}
