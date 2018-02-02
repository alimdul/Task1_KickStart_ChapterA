package test.by.pivovarevich.task1.creator;

import by.pivovarevich.task1.creator.PlaneCreator;
import by.pivovarevich.task1.entity.EntityPlane;
import by.pivovarevich.task1.entity.EntityPoint;
import by.pivovarevich.task1.entity.PlaneHolder;
import by.pivovarevich.task1.exception.IncorrectInputParametersException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class PlaneCreatorTest {

    @Test
    public void planeCreatorPositiveTest() {

        EntityPoint point1 = new EntityPoint(0.0, 1.0, 0.0);
        EntityPoint point2 = new EntityPoint(0.0, 1.0, 3.0);
        EntityPoint point3 = new EntityPoint(0.0, -2.0, 1.0);
        EntityPlane expectedPlane = new EntityPlane(point1, point2, point3);

        List<Double> coordinatesList = Arrays.asList(0.0, 1.0, 0.0, 0.0, 1.0, 3.0, 0.0, -2.0, 1.0);
        try {
            EntityPlane plane = new PlaneCreator().createPlane(coordinatesList);
            Assert.assertEquals(plane, expectedPlane);
        } catch (IncorrectInputParametersException e) {
            Assert.fail("Unexpected fail!");
        }
    }

    @Test(expectedExceptions = IncorrectInputParametersException.class)
    public void planeCreatorNullParameterExceptionTest() throws IncorrectInputParametersException {

        List<Double> coordinatesList = null;
        new PlaneCreator().createPlane(coordinatesList);
    }

    @Test(expectedExceptions = IncorrectInputParametersException.class)
    public void planeCreatorWrongCoordinatesCountExceptionTest() throws IncorrectInputParametersException {

        List<Double> coordinatesList = Arrays.asList(1.0, 3.0, 3.0, 1.0, 3.0, 3.0, 3.0);
        new PlaneCreator().createPlane(coordinatesList);
    }

}
