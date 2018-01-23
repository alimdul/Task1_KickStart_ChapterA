package test.by.pivovarevich.task1.reader;

import by.pivovarevich.task1.exception.IncorrectInputFileException;
import by.pivovarevich.task1.reader.ReadFromFile;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class ReadFromDefaultFileTest {

    @Test
    public void readFromDefaultFileTest() {

        try {
            final String DEFAULT_FILE_NAME = "data/defaultData.txt";
            final String FILE_NAME = "data/dat.txt";

            File file = new File(FILE_NAME);
            File defaultFile = new File(DEFAULT_FILE_NAME);

            int expectedStringsCount = 1;

            ReadFromFile readFromFile = new ReadFromFile();
            int stringsCount = readFromFile.readData(file, defaultFile).size();

            Assert.assertEquals(stringsCount, expectedStringsCount);
        } catch (IncorrectInputFileException e) {
            Assert.fail("Unexpected fail!", e);
        }
    }
}
