package test.by.pivovarevich.task1.reader;

import by.pivovarevich.task1.exception.IncorrectInputFileException;
import by.pivovarevich.task1.reader.ReadFromFile;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class ReadFromDefaultFileTest {

    @Test
    public void readFromDefaultFileTest() {

        final String DEFAULT_FILE_NAME = "data/defaultData.txt";
        final String FILE_NAME = "data/wrongFile.txt";

        File file = new File(FILE_NAME);
        File defaultFile = new File(DEFAULT_FILE_NAME);

        int expectedStringsCount = 1;
        int stringsCount = 0;

        ReadFromFile readFromFile = new ReadFromFile();

        try {
            stringsCount = readFromFile.readData(file, defaultFile).size();
        } catch (IncorrectInputFileException e) {
            Assert.fail("Unexpected fail!");
        }
        Assert.assertEquals(stringsCount, expectedStringsCount);
    }
}
