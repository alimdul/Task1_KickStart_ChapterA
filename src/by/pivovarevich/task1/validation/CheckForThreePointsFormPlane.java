package by.pivovarevich.task1.validation;

import by.pivovarevich.task1.entity.EntityPoint;
import by.pivovarevich.task1.exception.IncorrectInputParametersException;

public class CheckForThreePointsFormPlane {

    public boolean pointsFormPlane(EntityPoint point1, EntityPoint point2, EntityPoint point3) throws IncorrectInputParametersException {

        InputParameterValidation.nullParameter(point1, point2, point3);

        if(isPointsAllDifferent(point1, point2, point3)) {
            if(isPointsOnLine(point1, point2, point3)) {
                return false;
            }
            else {
                return true;
            }
        }
        return false;
    }

    public boolean isPointsOnLine(EntityPoint point1, EntityPoint point2, EntityPoint point3) throws IncorrectInputParametersException {

        InputParameterValidation.nullParameter(point1, point2, point3);

        if((point1.getX()==0 || point1.getY()==0 || point1.getZ()==0) &&
                point2.getX()-point1.getX()==point3.getX()-point1.getX() &&
                point2.getY()-point1.getY()==point3.getY()-point1.getY() &&
                point2.getZ()-point1.getZ()==point3.getZ()-point1.getZ()) {
            return true;
        }
        else{
            if((((point2.getX()-point1.getX()) / (point3.getX()-point1.getX())) ==
                    ((point2.getY()-point1.getY()) / (point3.getY()-point1.getY()))) &&
                    ((point2.getY()-point1.getY()) / (point3.getY()-point1.getY()) ==
                    ((point2.getZ()-point1.getZ()) / (point3.getZ()-point1.getZ())))) {
                return true;
            }
        }
        return false;
    }

    private boolean isPointsAllDifferent(EntityPoint point1, EntityPoint point2, EntityPoint point3) {
        return !(point1.equals(point2) || point1.equals(point3) || point2.equals(point3));
    }
}
