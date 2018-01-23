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

            List<String> expectedReadStringsList = Arrays.asList("1.0 1.0 1.0 2.0 2.0 2.0 3.0 3.0 3.0",
                    "1.0 1.0 1.z0 2.0 2.0 2.0 3.0 3.0 3.0", "1.0  1.0 1.0 2.0 2.0 2.0 3.0 3.0 3.0");

            List<String> readStringsList;

            ReadFromFile readFromFile = new ReadFromFile();
            readStringsList = readFromFile.readData(file, defaultFile);

            Assert.assertEquals(readStringsList, expectedReadStringsList);
        } catch (IncorrectInputFileException e) {
            Assert.fail("Unexpected fail!", e);
        }
    }
}
