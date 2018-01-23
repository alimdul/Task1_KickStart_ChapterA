package test.by.pivovarevich.task1.action;

import by.pivovarevich.task1.action.FindingAngleBetweenPlanes;
import by.pivovarevich.task1.entity.EntityPlane;
import by.pivovarevich.task1.entity.EntityPoint;
import by.pivovarevich.task1.exception.IncorrectInputParametersException;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Arrays;
import java.util.List;

public class FindingCoefficientsTest {

    @Test
    public void findingCoefficientsTest() {

        List<Double> coefficientList;
        List<Double> expectedCoefficientList = Arrays.asList(0.0, -5.0, 0.0);

        EntityPoint point1 = new EntityPoint(1.0, 0.0, -2.0);
        EntityPoint point2 = new EntityPoint(1.0, 0.0, 3.0);
        EntityPoint point3 = new EntityPoint(0.0, 0.0, 1.0);

        EntityPlane plane = new EntityPlane(point1, point2, point3);

        FindingAngleBetweenPlanes findingAngleBetweenPlanes = new FindingAngleBetweenPlanes();
        try {
            coefficientList = findingAngleBetweenPlanes.findingCoefficients(plane);
            Assert.assertEquals(coefficientList, expectedCoefficientList);
        } catch (IncorrectInputParametersException e) {
            Assert.fail("Unexpected fail!");
        }
    }
}
