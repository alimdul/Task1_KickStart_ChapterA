package by.pivovarevich.task1.parametersOfPlane;

import by.pivovarevich.task1.action.CheckForPerpendicularityOfPlaneToCoordinateAxis;
import by.pivovarevich.task1.action.FindAngleBetweenPlanes;
import by.pivovarevich.task1.entity.EntityPlane;
import by.pivovarevich.task1.exception.IncorrectInputParametersException;

public class CreateListOfParameters {

    private ParametersOfPlane<Double, Boolean> parametersOfPlane;
    private Double angle;
    private boolean perpendicularity;

    private FindAngleBetweenPlanes findAngleBetweenPlanes;
    private CheckForPerpendicularityOfPlaneToCoordinateAxis checkForPerpendicularityOfPlaneToCoordinateAxis;

    public ParametersOfPlane<Double, Boolean> findParameters(EntityPlane plane) throws IncorrectInputParametersException {

        findAngleBetweenPlanes = new FindAngleBetweenPlanes();
        checkForPerpendicularityOfPlaneToCoordinateAxis = new CheckForPerpendicularityOfPlaneToCoordinateAxis();
        parametersOfPlane = new ParametersOfPlane<>();

        angle = findAngleBetweenPlanes.findAngleBetweenPlaneAndCoordinatePlaneYOZ(plane);
        perpendicularity = checkForPerpendicularityOfPlaneToCoordinateAxis.isPlanePerpendicularToCoordinateAxisOx(plane);

        parametersOfPlane.setFirstParameter(angle);
        parametersOfPlane.setSecondParameter(perpendicularity);

        return parametersOfPlane;
    }
}
