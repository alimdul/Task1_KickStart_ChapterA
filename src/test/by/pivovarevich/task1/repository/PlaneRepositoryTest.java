package test.by.pivovarevich.task1.repository;

import by.pivovarevich.task1.creator.PlaneCreator;
import by.pivovarevich.task1.entity.EntityPlane;
import by.pivovarevich.task1.entity.EntityPoint;
import by.pivovarevich.task1.exception.IncorrectInputFileException;
import by.pivovarevich.task1.exception.IncorrectInputParametersException;
import by.pivovarevich.task1.parser.DataParser;
import by.pivovarevich.task1.reader.ReadFromFile;
import by.pivovarevich.task1.repository.PlaneRepository;
import by.pivovarevich.task1.repository.specification.PlaneSpecificationByPerpendicularity;
import by.pivovarevich.task1.repository.specification.PlaneSpecificationByRangeOfAngle;
import by.pivovarevich.task1.repository.specification.PlaneSpecificationSortByAngle;
import by.pivovarevich.task1.validation.ValidationOnData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlaneRepositoryTest {

    @Test
    public void planeRepositoryAddTest() {

        int expectedSize = PlaneRepository.getPlaneRepository().size() + 1;

        EntityPoint point1 = new EntityPoint(1.0, 0.0, -2.0);
        EntityPoint point2 = new EntityPoint(1.0, 0.0, 3.0);
        EntityPoint point3 = new EntityPoint(0.0, 0.0, 1.0);
        EntityPlane plane = new EntityPlane(point1, point2, point3);

        PlaneRepository.getPlaneRepository().add(plane);
        int size = PlaneRepository.getPlaneRepository().size();
        Assert.assertEquals(size, expectedSize);
    }

    @Test
    public void planeRepositoryQueryPerpendicularityTest() {

        String fileName = "data/data.txt";
        File file = new File(fileName);

        List<String> expectedList = Arrays.asList("((x=0.0, y=1.0, z=0.0), (x=0.0, y=1.0, z=3.0), (x=0.0, y=-2.0, z=1.0))",
                "((x=0.0, y=1.0, z=0.0), (x=0.0, y=1.0, z=3.0), (x=0.0, y=-2.0, z=1.0))");
        List<String> list = new ArrayList<>();

        try {
            List<String> strings = new ReadFromFile().readData(file);
            createAllPlanes(strings);
            List<EntityPlane> planeList = PlaneRepository.getPlaneRepository().query(new PlaneSpecificationByPerpendicularity());
            for (EntityPlane plane: planeList) {
                list.add(plane.toString());
            }
            Assert.assertEquals(list, expectedList);
        } catch (IncorrectInputFileException | IncorrectInputParametersException e) {
            Assert.fail("Unexpected fail!");
        }
    }

    @Test
    public void planeRepositoryQueryRangeOfAngleTest() {

        String fileName = "data/data.txt";
        File file = new File(fileName);

        List<String> expectedList = Arrays.asList("((x=0.0, y=0.0, z=0.0), (x=1.0, y=2.0, z=3.0), (x=-3.0, y=-2.0, z=-1.0))");
        List<String> list = new ArrayList<>();

        try {
            List<String> strings = new ReadFromFile().readData(file);
            createAllPlanes(strings);
            List<EntityPlane> planeList = PlaneRepository.getPlaneRepository().query(new PlaneSpecificationByRangeOfAngle());
            for (EntityPlane plane: planeList) {
                list.add(plane.toString());
            }
            Assert.assertEquals(list, expectedList);
        } catch (IncorrectInputFileException | IncorrectInputParametersException e) {
            Assert.fail("Unexpected fail!");
        }
    }

    @Test
    public void planeRepositorySortByAngleTest() {

        String fileName = "data/data.txt";
        File file = new File(fileName);

        List<String> expectedList = Arrays.asList("((x=0.0, y=0.0, z=0.0), (x=1.0, y=2.0, z=3.0), (x=-3.0, y=-2.0, z=-1.0))",
                "((x=0.0, y=1.0, z=0.0), (x=0.0, y=1.0, z=3.0), (x=0.0, y=-2.0, z=1.0))",
                "((x=0.0, y=1.0, z=0.0), (x=0.0, y=1.0, z=3.0), (x=0.0, y=-2.0, z=1.0))");
        List<String> list = new ArrayList<>();

        try {
            List<String> strings = new ReadFromFile().readData(file);
            createAllPlanes(strings);
            List<EntityPlane> planeList = PlaneRepository.getPlaneRepository().sort(new PlaneSpecificationSortByAngle());
            for (EntityPlane plane: planeList) {
                list.add(plane.toString());
            }
            Assert.assertEquals(list, expectedList);
        } catch (IncorrectInputFileException | IncorrectInputParametersException e) {
            Assert.fail("Unexpected fail!");
        }
    }

    public void createAllPlanes(List<String> strings) throws IncorrectInputParametersException {
        String currentString;
        ValidationOnData validationOnData = new ValidationOnData();
        DataParser dataParser = new DataParser();
        PlaneCreator planeCreator = new PlaneCreator();
        List<Double> coordinatesList;

        for(int i=0; i<strings.size(); i++) {
            currentString = strings.get(i);
            if(validationOnData.validation(currentString)) {
                coordinatesList = dataParser.parseString(currentString);
                planeCreator.createPlane(coordinatesList);
            }
        }
    }
}
