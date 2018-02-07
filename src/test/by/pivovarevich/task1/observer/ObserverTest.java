package test.by.pivovarevich.task1.observer;

import by.pivovarevich.task1.creator.PlaneCreator;
import by.pivovarevich.task1.entity.EntityPlane;
import by.pivovarevich.task1.entity.EntityPoint;
import by.pivovarevich.task1.entity.PlaneHolder;
import by.pivovarevich.task1.exception.IncorrectInputParametersException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class ObserverTest {

    @Test
    public void observerUpdateTest() {

        List<String> expectedParameters = Arrays.asList("46.473", "false");

        List<Double> coordinatesList1 = Arrays.asList(0.0, 1.0, 0.0, 0.0, 1.0, 3.0, 0.0, -2.0, 1.0);
        List<Double> coordinatesList2 = Arrays.asList(1.0, 1.0, 2.0, 0.0, 1.0, 3.0, 0.0, -2.0, 1.0);
        EntityPoint newPoint = new EntityPoint(-2.0, -1.0, 5.0);

        try {
            new PlaneCreator().createPlane(coordinatesList1);
            EntityPlane plane2 = new PlaneCreator().createPlane(coordinatesList2);
            plane2.setPoint1(newPoint);
            List<String> parameters = Arrays.asList(PlaneHolder.getPlaneHolder().getParametersOfPlaneMap().get(plane2.getPlaneId()).getFirst().toString(),
                    PlaneHolder.getPlaneHolder().getParametersOfPlaneMap().get(plane2.getPlaneId()).getSecond().toString());
            Assert.assertEquals(parameters, expectedParameters);
        } catch (IncorrectInputParametersException e) {
            Assert.fail("Unexpected fail!");
        }
    }
}
