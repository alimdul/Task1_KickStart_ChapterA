package test.by.pivovarevich.task1.action;

import by.pivovarevich.task1.action.CheckForWhetherPointsFormPlane;
import by.pivovarevich.task1.entity.EntityPoint;
import by.pivovarevich.task1.exception.IncorrectInputParametersException;
import org.testng.annotations.Test;

public class CheckForWhetherPointsFormPlaneExceptionTest {

    @Test(expectedExceptions = IncorrectInputParametersException.class)
    public void checkForWhetherPointsFormPlanePositiveTest() throws IncorrectInputParametersException {

        EntityPoint point1 = null;
        EntityPoint point2 = null;
        EntityPoint point3 = null;

        CheckForWhetherPointsFormPlane checkForWhetherPointsFormPlane = new CheckForWhetherPointsFormPlane();
        checkForWhetherPointsFormPlane.pointsFormPlane(point1, point2, point3);
    }
}
