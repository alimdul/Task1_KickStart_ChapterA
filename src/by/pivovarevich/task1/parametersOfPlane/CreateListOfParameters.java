package by.pivovarevich.task1.parametersOfPlane;

import by.pivovarevich.task1.action.CheckForPerpendicularityOfPlaneToCoordinateAxis;
import by.pivovarevich.task1.action.FindAngleBetweenPlanes;
import by.pivovarevich.task1.entity.EntityPlane;
import by.pivovarevich.task1.exception.IncorrectInputParametersException;

public class CreateListOfParameters {

    private ParametersOfPlane<Double, Boolean> parametersOfPlane;
    private Double angle;
    private boolean perpendicularity;

    private FindAngleBetweenPlanes findAngle;
    private CheckForPerpendicularityOfPlaneToCoordinateAxis checkForPerpendicularity;

    public ParametersOfPlane<Double, Boolean> findParameters(EntityPlane plane) throws IncorrectInputParametersException {

        findAngle = new FindAngleBetweenPlanes();
        checkForPerpendicularity = new CheckForPerpendicularityOfPlaneToCoordinateAxis();
        parametersOfPlane = new ParametersOfPlane<>();

        angle = findAngle.findAngleBetweenPlaneAndCoordinatePlaneYOZ(plane);
        perpendicularity = checkForPerpendicularity.isPlanePerpendicularToCoordinateAxisOx(plane);

        parametersOfPlane.setFirstParameter(angle);
        parametersOfPlane.setSecondParameter(perpendicularity);

        return parametersOfPlane;
    }
}
