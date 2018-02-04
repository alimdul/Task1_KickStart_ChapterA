package by.pivovarevich.task1.repository;

import by.pivovarevich.task1.action.FindAngleBetweenPlanes;
import by.pivovarevich.task1.entity.EntityPlane;
import by.pivovarevich.task1.repository.specification.PlaneSpecification;

import java.util.ArrayList;
import java.util.Comparator;
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

    public boolean planeExist(EntityPlane newPlane) {
        for(EntityPlane plane: planeList) {
            if(newPlane.equals(plane)) {
                return true;
            }
        }
        return false;
    }

    public List<EntityPlane> query(PlaneSpecification specification) {
        List<EntityPlane> result = new ArrayList<>();
        for(EntityPlane plane: planeList) {
            if(specification.specified(plane)) {
                result.add(plane);
            }
        }
        return result;
    }

    public List<EntityPlane> sortByAngle() {

        FindAngleBetweenPlanes findAngle = new FindAngleBetweenPlanes();
        List<EntityPlane> result;
        result = planeList;
        result.sort(Comparator.comparingDouble(plane -> findAngle.findAngleBetweenPlaneAndCoordinatePlaneYOZ(plane)));

        return result;
    }
}
