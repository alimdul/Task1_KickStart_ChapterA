package by.pivovarevich.task1.planeRepository;

import by.pivovarevich.task1.action.CheckForPerpendicularityOfPlaneToCoordinateAxis;
import by.pivovarevich.task1.entity.EntityPlane;
import by.pivovarevich.task1.exception.IncorrectInputParametersException;

public class PlaneSpecificationByPerpendicularity implements PlaneSpecificationImpl {

    private CheckForPerpendicularityOfPlaneToCoordinateAxis checkForPerpendicularity = new CheckForPerpendicularityOfPlaneToCoordinateAxis();

    @Override
    public boolean specified(EntityPlane plane) throws IncorrectInputParametersException {
        return checkForPerpendicularity.isPlanePerpendicularToCoordinateAxisOx(plane);
    }
}
