package by.pivovarevich.task1.repository.specification;

import by.pivovarevich.task1.action.CheckForPerpendicularityOfPlaneToCoordinateAxis;
import by.pivovarevich.task1.entity.EntityPlane;

public class PlaneSpecificationByPerpendicularity implements PlaneSpecification {

    @Override
    public boolean specified(EntityPlane plane) {
        return new CheckForPerpendicularityOfPlaneToCoordinateAxis().isPlanePerpendicularToCoordinateAxisOx(plane);
    }
}
