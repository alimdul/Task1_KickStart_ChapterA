package by.pivovarevich.task1.reader;

import by.pivovarevich.task1.exception.IncorrectInputFileException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ReadFromFile {

    private static final Logger LOGGER = LogManager.getLogger();

    public List<String> readData(File file) throws IncorrectInputFileException {

        if(file == null || !file.exists() || file.length()==0) {
            throw new IncorrectInputFileException("Incorrect input parameters");
        }

        List<String> readStringsList = new ArrayList<>();
        try {
            Files.lines(Paths.get(file.getPath()), StandardCharsets.UTF_8).forEach(readStringsList::add);
        } catch (IOException e) {
            LOGGER.catching(Level.FATAL, e);
            throw new RuntimeException(e);
        }
        LOGGER.log(Level.INFO, "- Data is successfully read. List contains " + readStringsList.size() + " strings");
        return readStringsList;
    }
}
