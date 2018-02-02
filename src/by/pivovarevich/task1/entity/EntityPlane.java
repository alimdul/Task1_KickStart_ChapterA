package by.pivovarevich.task1.entity;

import java.util.Objects;
import java.util.Observable;

public class EntityPlane extends Observable {

    private long planeId;
    private EntityPoint point1;
    private EntityPoint point2;
    private EntityPoint point3;

    public EntityPlane(EntityPoint point1, EntityPoint point2, EntityPoint point3) {
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
    }

    public EntityPoint getPoint1() {
        return point1;
    }

    public EntityPoint getPoint2() {
        return point2;
    }

    public EntityPoint getPoint3() {
        return point3;
    }

    public long getPlaneId() {
        return planeId;
    }

    public void setPoint1(EntityPoint point) {
        point1 = point;
        setChanged();
        notifyObservers();
    }

    public void setPoint2(EntityPoint point) {
        point2 = point;
        setChanged();
        notifyObservers();
    }

    public void setPoint3(EntityPoint point) {
        point3 = point;
        setChanged();
        notifyObservers();
    }

    public void setPlaneId(long planeId) {
        this.planeId = planeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntityPlane plane = (EntityPlane) o;
        return Objects.equals(point1, plane.point1) &&
                Objects.equals(point2, plane.point2) &&
                Objects.equals(point3, plane.point3);
    }

    @Override
    public int hashCode() {
        final int prime = 37;
        int result = 1;

        result = result * prime + (point1.hashCode());
        result = result * prime + (point2.hashCode());
        result = result * prime + (point3.hashCode());

        return result;
    }

    @Override
    public String toString() {
        return "(" + point1 + ", " + point2 + ", " + point3 + ')';
    }
}
