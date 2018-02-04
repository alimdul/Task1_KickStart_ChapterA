package test.by.pivovarevich.task1.action;

import by.pivovarevich.task1.action.FindAngleBetweenPlanes;
import by.pivovarevich.task1.entity.EntityPlane;
import by.pivovarevich.task1.entity.EntityPoint;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class FindCoefficientsTest {

    @Test
    public void findCoefficientsTest() {

        List<Double> expectedCoefficientList = Arrays.asList(0.0, -5.0, 0.0);

        EntityPoint point1 = new EntityPoint(1.0, 0.0, -2.0);
        EntityPoint point2 = new EntityPoint(1.0, 0.0, 3.0);
        EntityPoint point3 = new EntityPoint(0.0, 0.0, 1.0);
        EntityPlane plane = new EntityPlane(point1, point2, point3);

        List<Double> coefficientList = new FindAngleBetweenPlanes().findCoefficients(plane);
        Assert.assertEquals(coefficientList, expectedCoefficientList);
    }
}
