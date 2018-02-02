package by.pivovarevich.task1.parser;

import by.pivovarevich.task1.exception.IncorrectInputParametersException;
import by.pivovarevich.task1.validation.InputParameterValidation;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataParser {

    private static final String DOUBLE_NUMBER = "[-]?\\d+\\.\\d+";

    public List<Double> parseString (String string) throws IncorrectInputParametersException {

        if (InputParameterValidation.nullParameter(string)) {
            throw new IncorrectInputParametersException("Incorrect input parameters!");
        }

        List<Double> coordinatesString = new ArrayList<>();

        Pattern p = Pattern.compile(DOUBLE_NUMBER);
        Matcher m = p.matcher(string);
        while(m.find()) {
            coordinatesString.add(Double.parseDouble(string.substring(m.start(), m.end())));
        }
        return  coordinatesString;
    }
}
