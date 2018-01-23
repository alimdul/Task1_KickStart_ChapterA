package test.by.pivovarevich.task1.action;

import by.pivovarevich.task1.action.CheckForWhetherPointsFormPlane;
import by.pivovarevich.task1.entity.EntityPoint;
import by.pivovarevich.task1.exception.IncorrectInputParametersException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckForWhetherPointsFormPlanePositiveTest {

    @Test
    public void checkForWhetherPointsFormPlanePositiveTest() {

        boolean pointsFormPlane;

        EntityPoint point1 = new EntityPoint(0.0, 0.0, 0.0);
        EntityPoint point2 = new EntityPoint(1.0, 2.0, 3.0);
        EntityPoint point3 = new EntityPoint(-3.0, -2.0, -1.0);

        CheckForWhetherPointsFormPlane checkForWhetherPointsFormPlane = new CheckForWhetherPointsFormPlane();
        try {
            pointsFormPlane = checkForWhetherPointsFormPlane.pointsFormPlane(point1, point2, point3);
            Assert.assertEquals(pointsFormPlane, true);
        } catch (IncorrectInputParametersException e) {
            Assert.fail("Unexpected fail!");
        }
    }
}
