package by.pivovarevich.task1.entity;

import by.pivovarevich.task1.exception.IncorrectInputParametersException;
import by.pivovarevich.task1.parametersOfPlane.CreateListOfParameters;
import by.pivovarevich.task1.parametersOfPlane.ParametersOfPlane;

import java.util.*;

public class PlaneHolder {

    private static PlaneHolder planeHolder;
    private Map<Long, ParametersOfPlane<Double, Boolean>> parametersOfPlaneMap = new HashMap<>();

    private CreateListOfParameters createListOfParameters;
    private ParametersOfPlane<Double, Boolean> parametersOfPlane;

    private PlaneHolder(){}

    public static PlaneHolder getPlaneHolder() {
        return planeHolder = (planeHolder == null) ? new PlaneHolder() : planeHolder;
    }

    public void add(EntityPlane plane) throws IncorrectInputParametersException {
        createListOfParameters = new CreateListOfParameters();
        parametersOfPlane = createListOfParameters.findParameters(plane);
        parametersOfPlaneMap.put(plane.getId(), parametersOfPlane);
    }

    public void changeParameters(EntityPlane plane) throws IncorrectInputParametersException {
        createListOfParameters = new CreateListOfParameters();
        parametersOfPlane = createListOfParameters.findParameters(plane);
        parametersOfPlaneMap.replace(plane.getId(), parametersOfPlane);
    }

    public void printPlaneMap() {
        for (Long id: parametersOfPlaneMap.keySet()) {
            System.out.println(id+ ": angle = " + parametersOfPlaneMap.get(id).getFirstParameter() + ", perpendicularity = " +
                    parametersOfPlaneMap.get(id).getSecondParameter());
        }
    }

}
