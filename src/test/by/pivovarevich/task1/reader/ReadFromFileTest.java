package test.by.pivovarevich.task1.reader;

import by.pivovarevich.task1.exception.IncorrectInputFileException;
import by.pivovarevich.task1.reader.ReadFromFile;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class ReadFromFileTest {

    @Test
    public void readFromFileTest() {

        try {
            final String DEFAULT_FILE = "data/defaultData.txt";
            final String FILE = "data/data.txt";

            File file = new File(FILE);
            File defaultFile = new File(DEFAULT_FILE);

            int expectedStringsCount = 3;

            ReadFromFile readFromFile = new ReadFromFile();
            int stringsCount = readFromFile.readData(file, defaultFile).size();

            Assert.assertEquals(stringsCount, expectedStringsCount);
        } catch (IncorrectInputFileException e) {
            Assert.fail("Unexpected fail!", e);
        }
    }
}
