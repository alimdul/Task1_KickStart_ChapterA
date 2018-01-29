package test.by.pivovarevich.task1.parser;

import by.pivovarevich.task1.exception.IncorrectInputParametersException;
import by.pivovarevich.task1.parser.DataParser;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class DataParserTest {

    @Test
    public void dataParserPositiveTest() {

        List<Double> coordinatesString;
        List<Double> expectedCoordinatesString = Arrays.asList(1.0, 1.0, 1.0, 2.0, 2.0, 2.0, 3.0, 3.0, 3.0);

        String string = "1.0 1.0 1.0 2.0 2.0 2.0 3.0 3.0 3.0";

        DataParser dataParser = new DataParser();
        try {
            coordinatesString = dataParser.parseString(string);
            Assert.assertEquals(coordinatesString, expectedCoordinatesString);
        } catch (IncorrectInputParametersException e) {
            e.printStackTrace();
        }
    }

    @Test(expectedExceptions = IncorrectInputParametersException.class)
    public void dataParserExceptionTest() throws IncorrectInputParametersException {

        String string = null;

        DataParser dataParser = new DataParser();
        dataParser.parseString(string);
    }

}
