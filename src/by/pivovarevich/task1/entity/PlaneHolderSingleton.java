package by.pivovarevich.task1.entity;

import by.pivovarevich.task1.exception.IncorrectInputParametersException;
import by.pivovarevich.task1.parametersOfPlane.CreateListOfParameters;
import by.pivovarevich.task1.parametersOfPlane.ParametersOfPlane;

import java.util.*;

public class PlaneHolderSingleton {

    private static PlaneHolderSingleton planeHolderSingleton;
    private Map<Long, ParametersOfPlane<Double, Boolean>> parametersOfPlaneMap = new HashMap<>();
    private Map<Long, EntityPlane> planeMap = new HashMap<>();

    private CreateListOfParameters createListOfParameters;
    private ParametersOfPlane<Double, Boolean> parametersOfPlane;

    private PlaneHolderSingleton(){}

    public static PlaneHolderSingleton getPlaneHolderSingleton() {
        return planeHolderSingleton = (planeHolderSingleton == null) ? new PlaneHolderSingleton() : planeHolderSingleton;
    }

    public void addPlane(EntityPlane plane) throws IncorrectInputParametersException {
        createListOfParameters = new CreateListOfParameters();
        parametersOfPlane = createListOfParameters.findParameters(plane);
        parametersOfPlaneMap.put(plane.getId(), parametersOfPlane);
        planeMap.put(plane.getId(), plane);
    }

    public EntityPlane getPlane(long id) {
        return planeMap.get(id);
    }

    public void printPlaneMap() {
        for (Long id: parametersOfPlaneMap.keySet()) {
            System.out.println(id+ ": angle = " + parametersOfPlaneMap.get(id).getFirstParameter() + ", perpendicularity = " +
                    parametersOfPlaneMap.get(id).getSecondParameter());
        }
    }

    public void changeParameters(EntityPlane plane) throws IncorrectInputParametersException {
        createListOfParameters = new CreateListOfParameters();
        parametersOfPlane = createListOfParameters.findParameters(plane);
        parametersOfPlaneMap.replace(plane.getId(), parametersOfPlane);
    }

}
