package test.by.pivovarevich.task1.action;
import by.pivovarevich.task1.creator.PlaneCreator;
import by.pivovarevich.task1.entity.EntityPlane;
import by.pivovarevich.task1.exception.IncorrectInputFileException;
import by.pivovarevich.task1.exception.IncorrectInputParametersException;
import by.pivovarevich.task1.parser.DataParser;
import by.pivovarevich.task1.reader.ReadFromFile;
import by.pivovarevich.task1.validation.ValidationOnData;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class BigTest {

    public static void main(String[] args) {

        List<EntityPlane> planeList = new ArrayList<>();

        String fileName = "data/data.txt";
        File file = new File(fileName);
        ReadFromFile readFromFile = new ReadFromFile();
        ValidationOnData validationOnData = new ValidationOnData();
        DataParser dataParser = new DataParser();
        PlaneCreator planeCreator = new PlaneCreator();
        String currentString;
        List<Double> coordinatesList;
        try {
            List<String> strings = readFromFile.readData(file);
            for(int i=0; i<strings.size(); i++) {
                currentString = strings.get(i);
                if(validationOnData.validation(currentString)) {
                    coordinatesList = dataParser.parseString(currentString);
                    EntityPlane newPlane = planeCreator.createPlane(coordinatesList);
                    if(newPlane != null) {
                        planeList.add(newPlane);
                    }
                }
            }

            for(int i=0; i<planeList.size(); i++) {
                System.out.println(planeList.get(i).toString());
            }

        } catch (IncorrectInputFileException | IncorrectInputParametersException e) {
            System.out.println("Error!");
        }
    }
}
