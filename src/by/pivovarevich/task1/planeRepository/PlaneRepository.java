package by.pivovarevich.task1.planeRepository;

import by.pivovarevich.task1.entity.EntityPlane;
import by.pivovarevich.task1.exception.IncorrectInputParametersException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlaneRepository {

    private static PlaneRepository planeRepository;
    private List<EntityPlane> planeList = new ArrayList<>();

    private PlaneRepository(){}

    public static PlaneRepository getPlaneRepository() {
        return planeRepository = (planeRepository == null) ? new PlaneRepository() : planeRepository;
    }

    public void add(EntityPlane entityPlane) {
        planeList.add(entityPlane);
    }

    public List<EntityPlane> query(PlaneSpecificationImpl specification) throws IncorrectInputParametersException {
        List<EntityPlane> result = new ArrayList<>();
        for(EntityPlane plane: planeList) {
            if(specification.specified(plane)) {
                result.add(plane);
            }
        }
        return result;
    }

    public List<EntityPlane> sort(PlaneSpecificationSortByAngle specification) {
        List<EntityPlane> result = new ArrayList<>();
        result = planeList;
        Collections.sort(result, specification);
        return result;
    }

}
