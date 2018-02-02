package by.pivovarevich.task1.repository;

import by.pivovarevich.task1.entity.EntityPlane;
import by.pivovarevich.task1.exception.IncorrectInputParametersException;
import by.pivovarevich.task1.repository.specification.PlaneSpecification;
import by.pivovarevich.task1.repository.specification.PlaneSpecificationSortByAngle;

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

    public int size() {
        return planeList.size();
    }

    public List<EntityPlane> query(PlaneSpecification specification) throws IncorrectInputParametersException {
        List<EntityPlane> result = new ArrayList<>();
        for(EntityPlane plane: planeList) {
            if(specification.specified(plane)) {
                result.add(plane);
            }
        }
        return result;
    }

    public List<EntityPlane> sort(PlaneSpecificationSortByAngle specification) {
        List<EntityPlane> result;
        result = planeList;
        Collections.sort(result, specification);
        return result;
    }

}
