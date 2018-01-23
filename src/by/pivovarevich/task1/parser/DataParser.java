package by.pivovarevich.task1.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataParser {

    private static final String DOUBLE_NUMBER = "[-]?\\d+\\.\\d+";

    private List<Double> coordinatesString = new ArrayList<>();

    public List<Double> parseString (String string) {

        Pattern p = Pattern.compile(DOUBLE_NUMBER);
        Matcher m = p.matcher(string);
        while(m.find()) {
            coordinatesString.add(Double.parseDouble(string.substring(m.start(), m.end())));
        }
        return coordinatesString;
    }
}
