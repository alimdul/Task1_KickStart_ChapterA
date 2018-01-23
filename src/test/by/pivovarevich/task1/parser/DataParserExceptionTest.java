package test.by.pivovarevich.task1.parser;

import by.pivovarevich.task1.exception.IncorrectInputParametersException;
import by.pivovarevich.task1.parser.DataParser;
import org.testng.annotations.Test;

public class DataParserExceptionTest {

    @Test(expectedExceptions = IncorrectInputParametersException.class)
    public void checkForWhetherPointsFormPlanePositiveTest() throws IncorrectInputParametersException {

        String string = null;

        DataParser dataParser = new DataParser();
        dataParser.parseString(string);
    }
}
