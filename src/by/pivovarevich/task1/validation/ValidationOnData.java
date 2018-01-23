package by.pivovarevich.task1.validation;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationOnData {

    private static final String NINE_DOUBLE_NUMBERS = "([-]?\\d+\\.\\d+\\s+){8}[-]?\\d+\\.\\d+";
    private static final Logger LOGGER = LogManager.getLogger();

    public boolean validation(String string) {

        Pattern p = Pattern.compile(NINE_DOUBLE_NUMBERS);
        Matcher m = p.matcher(string);
        if (!m.matches()) {
            LOGGER.log(Level.ERROR, "- String \"" + string + "\" is not valid");
            return false;
        }
        else {
            return true;
        }
    }
}
