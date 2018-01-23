package test.by.pivovarevich.task1.creator;

import by.pivovarevich.task1.creator.PlaneCreator;
import by.pivovarevich.task1.entity.EntityPlane;
import by.pivovarevich.task1.entity.EntityPoint;
import by.pivovarevich.task1.exception.IncorrectInputParametersException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class PlaneCreatorTest {

    @Test
    public void validationOnDataNegativeTest() {

        EntityPoint point1 = new EntityPoint(0.0, 1.0, 0.0);
        EntityPoint point2 = new EntityPoint(0.0, 1.0, 3.0);
        EntityPoint point3 = new EntityPoint(0.0, -2.0, 1.0);
        EntityPlane expectedPlane = new EntityPlane(point1, point2, point3);

        List<Double> coordinatesList = Arrays.asList(0.0, 1.0, 0.0, 0.0, 1.0, 3.0, 0.0, -2.0, 1.0);
        PlaneCreator planeCreator = new PlaneCreator();

        try {
            EntityPlane plane = planeCreator.createPlane(coordinatesList);
            Assert.assertEquals(plane, expectedPlane);
        } catch (IncorrectInputParametersException e) {
            Assert.fail("Unexpected fail!");
        }
    }
}
