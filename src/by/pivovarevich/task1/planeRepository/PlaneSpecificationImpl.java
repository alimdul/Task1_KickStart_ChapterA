package by.pivovarevich.task1.planeRepository;

import by.pivovarevich.task1.entity.EntityPlane;
import by.pivovarevich.task1.exception.IncorrectInputParametersException;

public interface PlaneSpecificationImpl {

    boolean specified(EntityPlane entityPlane) throws IncorrectInputParametersException;
}
