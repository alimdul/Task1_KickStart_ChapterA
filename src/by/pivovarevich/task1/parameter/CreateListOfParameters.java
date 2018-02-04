package by.pivovarevich.task1.parameter;

import by.pivovarevich.task1.action.CheckForPerpendicularityOfPlaneToCoordinateAxis;
import by.pivovarevich.task1.action.FindAngleBetweenPlanes;
import by.pivovarevich.task1.entity.EntityPlane;

public class CreateListOfParameters {

    public ParametersOfPlane<Double, Boolean> findParameters(EntityPlane plane) {

        ParametersOfPlane<Double, Boolean> parametersOfPlane = new ParametersOfPlane<>();
        FindAngleBetweenPlanes findAngle = new FindAngleBetweenPlanes();
        CheckForPerpendicularityOfPlaneToCoordinateAxis checkForPerpendicularity = new CheckForPerpendicularityOfPlaneToCoordinateAxis();

        double angle = findAngle.findAngleBetweenPlaneAndCoordinatePlaneYOZ(plane);
        boolean perpendicularity = checkForPerpendicularity.isPlanePerpendicularToCoordinateAxisOx(plane);

        parametersOfPlane.setFirst(angle);
        parametersOfPlane.setSecond(perpendicularity);

        return parametersOfPlane;
    }
}
