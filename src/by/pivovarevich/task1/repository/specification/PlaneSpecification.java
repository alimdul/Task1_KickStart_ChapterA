package by.pivovarevich.task1.repository.specification;

import by.pivovarevich.task1.entity.EntityPlane;
import by.pivovarevich.task1.exception.IncorrectInputParametersException;

public interface PlaneSpecification {

    boolean specified(EntityPlane entityPlane) throws IncorrectInputParametersException;
}
