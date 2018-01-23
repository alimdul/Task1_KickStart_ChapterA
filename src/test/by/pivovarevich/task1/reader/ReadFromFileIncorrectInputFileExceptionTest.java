package test.by.pivovarevich.task1.reader;

import by.pivovarevich.task1.exception.IncorrectInputFileException;
import by.pivovarevich.task1.reader.ReadFromFile;
import org.testng.annotations.Test;

import java.io.File;

public class ReadFromFileIncorrectInputFileExceptionTest {

    @Test(expectedExceptions = IncorrectInputFileException.class)
    public void readFromFileIncorrectInputFileExceptionTest() throws IncorrectInputFileException {

        final String DEFAULT_FILE = "data/wrongFile1.txt";
        final String FILE = "data/wrongFile2.txt";

        File defaultFile = new File(DEFAULT_FILE);
        File file = new File(FILE);

        ReadFromFile readFromFile = new ReadFromFile();
        readFromFile.readData(file, defaultFile);
    }
}
