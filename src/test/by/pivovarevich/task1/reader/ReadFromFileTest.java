package test.by.pivovarevich.task1.reader;

import by.pivovarevich.task1.exception.IncorrectInputFileException;
import by.pivovarevich.task1.reader.ReadFromFile;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class ReadFromFileTest {

    @Test
    public void readFromFileTest() {

        final String DEFAULT_FILE = "data/defaultData.txt";
        final String FILE = "data/data.txt";

        File file = new File(FILE);
        File defaultFile = new File(DEFAULT_FILE);

        int expectedStringsCount = 3;
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
