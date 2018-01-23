package test.by.pivovarevich.task1.action;

import by.pivovarevich.task1.action.CheckForWhetherPointsFormPlane;
import by.pivovarevich.task1.entity.EntityPoint;
import by.pivovarevich.task1.exception.IncorrectInputParametersException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckForWhetherPointsFormPlaneNegativeAllPointsAreNotDifferentTest {

    @Test
    public void checkForWhetherPointsFormPlaneNegativeAllPointsAreNotDifferentTest() {

        boolean pointsFormPlane;

        EntityPoint point1 = new EntityPoint(1.0, 3.0, 3.0);
        EntityPoint point2 = new EntityPoint(1.0, 3.0, 3.0);
        EntityPoint point3 = new EntityPoint(3.0, 3.0, 3.0);

        CheckForWhetherPointsFormPlane checkForWhetherPointsFormPlane = new CheckForWhetherPointsFormPlane();
        try {
            pointsFormPlane = checkForWhetherPointsFormPlane.pointsFormPlane(point1, point2, point3);
            Assert.assertEquals(pointsFormPlane, false);
        } catch (IncorrectInputParametersException e) {
            Assert.fail("Unexpected fail!");
        }
    }
}
