package test.by.pivovarevich.task1.creator;

import by.pivovarevich.task1.creator.PlaneCreator;
import by.pivovarevich.task1.exception.IncorrectInputParametersException;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class PlaneCreatorExceptionWrongCoordinatesCountTest {

    @Test(expectedExceptions = IncorrectInputParametersException.class)
    public void planeCreatorExceptionTest() throws IncorrectInputParametersException {

        List<Double> coordinatesList = Arrays.asList(1.0, 3.0, 3.0, 1.0, 3.0, 3.0, 3.0);
        PlaneCreator planeCreator = new PlaneCreator();
        planeCreator.createPlane(coordinatesList);
    }
}
