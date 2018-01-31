package test.by.pivovarevich.task1.action;
import by.pivovarevich.task1.creator.PlaneCreator;
import by.pivovarevich.task1.entity.EntityPlane;
import by.pivovarevich.task1.entity.EntityPoint;
import by.pivovarevich.task1.entity.PlaneHolder;
import by.pivovarevich.task1.exception.IncorrectInputFileException;
import by.pivovarevich.task1.exception.IncorrectInputParametersException;
import by.pivovarevich.task1.parser.DataParser;
import by.pivovarevich.task1.planeRepository.PlaneRepository;
import by.pivovarevich.task1.planeRepository.PlaneSpecificationByPerpendicularity;
import by.pivovarevich.task1.planeRepository.PlaneSpecificationByRangeOfAngle;
import by.pivovarevich.task1.planeRepository.PlaneSpecificationSortByAngle;
import by.pivovarevich.task1.reader.ReadFromFile;
import by.pivovarevich.task1.validation.ValidationOnData;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class BigTest {

    public static void main(String[] args) {

        List<EntityPlane> planeList = new ArrayList<>();

        PlaneHolder planeHolder = PlaneHolder.getPlaneHolder();
        String fileName = "data/data.txt";
        File file = new File(fileName);
        ReadFromFile readFromFile = new ReadFromFile();
        ValidationOnData validationOnData = new ValidationOnData();
        DataParser dataParser = new DataParser();
        PlaneCreator planeCreator = new PlaneCreator();
        PlaneRepository planeRepository = PlaneRepository.getPlaneRepository();
        String currentString;
        List<Double> coordinatesList;
        try {
            List<String> strings = readFromFile.readData(file);
            for(int i=0; i<strings.size(); i++) {
                currentString = strings.get(i);
                if(validationOnData.validation(currentString)) {
                    coordinatesList = dataParser.parseString(currentString);
                    planeCreator.createPlane(coordinatesList);
                }
            }
//            System.out.println(planeList = planeRepository.query(new PlaneSpecificationByPerpendicularity()));
//            System.out.println(planeList = planeRepository.query(new PlaneSpecificationByRangeOfAngle()));
            System.out.println(planeList = planeRepository.sort(new PlaneSpecificationSortByAngle()));

//            System.out.println("-----------------------------");
//            planeHolder.printPlaneMap();
//            System.out.println("-----------------------------");
////            System.out.println(planeHolder.getPlane(2).getPoint2().toString());
////            planeHolder.getPlane(2).setPoint1(new EntityPoint(9.0, 0.0, 0.0));
////            System.out.println(planeHolder.getPlane(2).getPoint2().toString());
//            planeHolder.printPlaneMap();

        } catch (IncorrectInputFileException | IncorrectInputParametersException e) {
            System.out.println("Error!");
        }
    }
}
