package test.by.pivovarevich.task1.creator;

import by.pivovarevich.task1.creator.PlaneCreator;
import by.pivovarevich.task1.exception.IncorrectInputParametersException;
import org.testng.annotations.Test;
import java.util.List;

public class PlaneCreatorExceptionNullParameterCountTest {

    @Test(expectedExceptions = IncorrectInputParametersException.class)
    public void planeCreatorExceptionTest() throws IncorrectInputParametersException {

        List<Double> coordinatesList = null;
        PlaneCreator planeCreator = new PlaneCreator();
        planeCreator.createPlane(coordinatesList);
    }
}
