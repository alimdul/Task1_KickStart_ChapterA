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
    public void readFromFileEqualSizeTest() {

        String fileName = "data/data.txt";
        File file = new File(fileName);

        int expectedStringsCount = 5;
        try {
            int stringsCount = new ReadFromFile().readData(file).size();
            Assert.assertEquals(stringsCount, expectedStringsCount);
        } catch (IncorrectInputFileException e) {
            Assert.fail("Unexpected fail!");
        }
    }

    @Test
    public void readFromFileEqualStringsTest() {

        String fileName = "data/data.txt";
        File file = new File(fileName);

        List<String> expectedStrings = Arrays.asList("0.0 1.0 0.0 0.0 1.0 3.0 0.0 -2.0 1.0", "0.0 0.0 0.0 1.0 2.0 3.0 -3.0 -2.0 -1.0",
                "0.0 1.0 0.0 0.0 1.0 3.0 0.0 -2.0 1.0", "1.0  1.0 1.0 2.0 2.0 2.0 3.0 3.0 3.0",
                "1.0 1.0 1.z0 2.0 2.0 2.0 3.0 3.0 3.0");
        try {
            List<String> strings = new ReadFromFile().readData(file);
            Assert.assertEquals(strings, expectedStrings);
        } catch (IncorrectInputFileException e) {
            Assert.fail("Unexpected fail!");
        }
    }

    @Test(expectedExceptions = IncorrectInputFileException.class)
    public void readFromFileIsNullExceptionTest() throws IncorrectInputFileException {

        File file = null;
        new ReadFromFile().readData(file);
    }

    @Test(expectedExceptions = IncorrectInputFileException.class)
    public void readFromFileIsNotExistExceptionTest() throws IncorrectInputFileException {

        String FILE = "data/wrongFile.txt";
        File file = new File(FILE);
        new ReadFromFile().readData(file);
    }

    @Test(expectedExceptions = IncorrectInputFileException.class)
    public void readFromFileIsEmptyExceptionTest() throws IncorrectInputFileException {

        String FILE = "data/empty.txt";
        File file = new File(FILE);
        new ReadFromFile().readData(file);
    }
}
