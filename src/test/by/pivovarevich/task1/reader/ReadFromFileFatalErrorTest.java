package test.by.pivovarevich.task1.reader;

import by.pivovarevich.task1.exception.IncorrectInputFileException;
import by.pivovarevich.task1.reader.ReadFromFile;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class ReadFromFileFatalErrorTest {

    @Test(expectedExceptions = RuntimeException.class)
    public void readFromFileFatalErrorTest() {

        try {
            final String DEFAULT_FILE = "data/wrongFile1.txt";
            final String FILE = "data/wrongFile2.txt";

            File defaultFile = new File(DEFAULT_FILE);
            File file = new File(FILE);

            ReadFromFile readFromFile = new ReadFromFile();
            readFromFile.readData(file, defaultFile);
        } catch (IncorrectInputFileException e) {
            Assert.fail("Unexpected fail!", e);
        }
    }
}
