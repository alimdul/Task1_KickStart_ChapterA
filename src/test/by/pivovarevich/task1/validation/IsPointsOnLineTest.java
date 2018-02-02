package test.by.pivovarevich.task1.validation;

import by.pivovarevich.task1.entity.EntityPoint;
import by.pivovarevich.task1.exception.IncorrectInputParametersException;
import by.pivovarevich.task1.validation.CheckForThreePointsFormPlane;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IsPointsOnLineTest {

    @Test
    public void isPointsOnLinePositiveTest() {

        EntityPoint point1 = new EntityPoint(3.0, -7.0, 8.0);
        EntityPoint point2 = new EntityPoint(-5.0, 4.0, 1.0);
        EntityPoint point3 = new EntityPoint(27.0, -40.0, 29.0);

        try {
            boolean isPointsOnLine = new CheckForThreePointsFormPlane().isPointsOnLine(point1, point2, point3);
            Assert.assertEquals(isPointsOnLine, true);
        } catch (IncorrectInputParametersException e) {
            Assert.fail("Unexpected fail!");
        }
    }

    @Test
    public void isPointsOnLineNegativeTest() {

        EntityPoint point1 = new EntityPoint(0.0, 0.0, 0.0);
        EntityPoint point2 = new EntityPoint(1.0, 2.0, 3.0);
        EntityPoint point3 = new EntityPoint(-3.0, -2.0, -1.0);

        try {
            boolean isPointsOnLine = new CheckForThreePointsFormPlane().isPointsOnLine(point1, point2, point3);
            Assert.assertEquals(isPointsOnLine, false);
        } catch (IncorrectInputParametersException e) {
            Assert.fail("Unexpected fail!");
        }
    }

    @Test(expectedExceptions = IncorrectInputParametersException.class)
    public void isPointsOnLineExceptionTest() throws IncorrectInputParametersException {

        EntityPoint point1 = null;
        EntityPoint point2 = null;
        EntityPoint point3 = null;

        new CheckForThreePointsFormPlane().isPointsOnLine(point1, point2, point3);
    }

}
