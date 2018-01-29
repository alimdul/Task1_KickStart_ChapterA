package by.pivovarevich.task1.entity;

public class EntityPoint {

    private double x;
    private double y;
    private double z;

    public EntityPoint(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public double getZ() {
        return z;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntityPoint point = (EntityPoint) o;
        return Double.compare(point.x, x) == 0 &&
                Double.compare(point.y, y) == 0 &&
                Double.compare(point.z, z) == 0;
    }

    @Override
    public int hashCode() {
        final int prime = 37;
        int result = 1;

        result = result * prime + (int)(Double.doubleToLongBits(x) - (Double.doubleToLongBits(x) >>> 32));
        result = result * prime + (int)(Double.doubleToLongBits(y) - (Double.doubleToLongBits(y) >>> 32));
        result = result * prime + (int)(Double.doubleToLongBits(z) - (Double.doubleToLongBits(z) >>> 32));

        return result;
    }

    @Override
    public String toString() {
        return "(" + "x=" + x + ", y=" + y + ", z=" + z + ')';
    }
}
