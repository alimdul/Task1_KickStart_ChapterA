package test.by.pivovarevich.task1.parameter;

import by.pivovarevich.task1.creator.PlaneCreator;
import by.pivovarevich.task1.entity.EntityPlane;
import by.pivovarevich.task1.exception.IncorrectInputParametersException;
import by.pivovarevich.task1.parameter.CreateListOfParameters;
import by.pivovarevich.task1.parameter.ParametersOfPlane;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class CreateListOfParametersTest {

    @Test
    public void createListOfParametersPositiveTest() {

        List<String> expectedList = Arrays.asList("23.3909", "false");

        List<Double> coordinatesList = Arrays.asList(0.0, 0.0, 0.0, 1.0, 2.0, 3.0, -3.0, -2.0, -1.0);
        try {
            EntityPlane plane = new PlaneCreator().createPlane(coordinatesList);
            ParametersOfPlane<Double, Boolean> parametersOfPlane = new CreateListOfParameters().findParameters(plane);
            List<String> list = Arrays.asList(parametersOfPlane.getFirst().toString(), parametersOfPlane.getSecond().toString());
            Assert.assertEquals(list, expectedList);
        } catch (IncorrectInputParametersException e) {
            Assert.fail("Unexpected fail!");
        }
    }
}
