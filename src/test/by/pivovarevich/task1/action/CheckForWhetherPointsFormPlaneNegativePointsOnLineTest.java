package test.by.pivovarevich.task1.action;

import by.pivovarevich.task1.action.CheckForWhetherPointsFormPlane;
import by.pivovarevich.task1.entity.EntityPoint;
import by.pivovarevich.task1.exception.IncorrectInputParametersException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckForWhetherPointsFormPlaneNegativePointsOnLineTest {

    @Test
    public void checkForWhetherPointsFormPlaneNegativePointsOnLineTest() {

        boolean pointsFormPlane;

        EntityPoint point1 = new EntityPoint(3.0, -7.0, 8.0);
        EntityPoint point2 = new EntityPoint(-5.0, 4.0, 1.0);
        EntityPoint point3 = new EntityPoint(27.0, -40.0, 29.0);

        CheckForWhetherPointsFormPlane checkForWhetherPointsFormPlane = new CheckForWhetherPointsFormPlane();
        try {
            pointsFormPlane = checkForWhetherPointsFormPlane.pointsFormPlane(point1, point2, point3);
            Assert.assertEquals(pointsFormPlane, false);
        } catch (IncorrectInputParametersException e) {
            Assert.fail("Unexpected fail!");
        }
    }
}
