package by.pivovarevich.task1.action;

import by.pivovarevich.task1.entity.EntityPoint;
import by.pivovarevich.task1.exception.IncorrectInputParametersException;

public class CheckForWhetherPointsFormPlane {

    public boolean pointsFormPlane(EntityPoint point1, EntityPoint point2, EntityPoint point3) throws IncorrectInputParametersException {

        if (point1 == null || point2 == null || point3 == null) {
            throw new IncorrectInputParametersException("Incorrect input parameters!");
        }

        if(isPointsAreAllDifferent(point1, point2, point3)) {
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

        if (point1 == null || point2 == null || point3 == null) {
            throw new IncorrectInputParametersException("Incorrect input parameters!");
        }

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

    public boolean isPointsAreAllDifferent(EntityPoint point1, EntityPoint point2, EntityPoint point3) {

        if(!(point1.equals(point2) || point1.equals(point3) || point2.equals(point3))) {
            return true;
        }
        return false;
    }
}
