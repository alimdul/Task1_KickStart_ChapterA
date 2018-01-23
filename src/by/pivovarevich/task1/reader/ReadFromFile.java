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

    private List<String> readStringsList = new ArrayList<>();

    public List<String> readData(File file, File defaultFile) throws IncorrectInputFileException {

        if(file.exists() && file.length() != 0) {
            try {
                Files.lines(Paths.get(file.getPath()), StandardCharsets.UTF_8).forEach((String currentString) -> {
                    readStringsList.add(currentString);
                });
            } catch (IOException e) {
                throw new IncorrectInputFileException("- Problems with reading file " + file.getPath(), e);
            }
        }
        else {
            defaultRead(defaultFile);
        }
        LOGGER.log(Level.INFO, "- Data is successfully read. List contains " + readStringsList.size() + " strings");
        return readStringsList;
    }

    public void defaultRead(File defaultFile) {

        if (defaultFile.exists() && defaultFile.length() != 0) {
            try {
                Files.lines(Paths.get(defaultFile.getPath()), StandardCharsets.UTF_8).forEach((String currentString) -> {
                    readStringsList.add(currentString);
                });
            } catch (IOException e) {
                LOGGER.log(Level.FATAL, "- Fatal error! File not found.");
                throw new RuntimeException();
            }
        } else {
            LOGGER.log(Level.FATAL, "- Fatal error! File not found.");
            throw new RuntimeException();
        }
    }
}
