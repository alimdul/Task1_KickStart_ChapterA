package by.pivovarevich.task1.entity;

import by.pivovarevich.task1.parameter.CreateListOfParameters;
import by.pivovarevich.task1.parameter.ParametersOfPlane;

import java.util.*;

public class PlaneHolder {

    private static PlaneHolder planeHolder;
    private Map<Long, ParametersOfPlane<Double, Boolean>> parametersOfPlaneMap = new HashMap<>();

    private PlaneHolder(){}

    public static PlaneHolder getPlaneHolder() {
        return planeHolder = (planeHolder == null) ? new PlaneHolder() : planeHolder;
    }

    public Map<Long, ParametersOfPlane<Double, Boolean>> getParametersOfPlaneMap() {
        return parametersOfPlaneMap;
    }

    public int size() {
        return parametersOfPlaneMap.size();
    }

    public void add(EntityPlane plane) {
        ParametersOfPlane<Double, Boolean> parametersOfPlane = new CreateListOfParameters().findParameters(plane);
        parametersOfPlaneMap.put(plane.getPlaneId(), parametersOfPlane);
    }

    public void changeParameters(EntityPlane plane) {
        ParametersOfPlane<Double, Boolean> parametersOfPlane = new CreateListOfParameters().findParameters(plane);
        parametersOfPlaneMap.replace(plane.getPlaneId(), parametersOfPlane);
    }

    public void printPlaneMap() {
        for (Long planeId: parametersOfPlaneMap.keySet()) {
            System.out.println(planeId+ ": angle = " + parametersOfPlaneMap.get(planeId).getFirst() + ", perpendicularity = " +
                    parametersOfPlaneMap.get(planeId).getSecond());
        }
    }
}
