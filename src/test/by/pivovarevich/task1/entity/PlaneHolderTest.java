package test.by.pivovarevich.task1.entity;

import by.pivovarevich.task1.entity.EntityPlane;
import by.pivovarevich.task1.entity.EntityPoint;
import by.pivovarevich.task1.entity.PlaneHolder;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlaneHolderTest {

    @Test
    public void PlaneHolderAddTest() {

        int expectedSize = PlaneHolder.getPlaneHolder().size() + 1;

        EntityPoint point1 = new EntityPoint(1.0, 0.0, -2.0);
        EntityPoint point2 = new EntityPoint(1.0, 0.0, 3.0);
        EntityPoint point3 = new EntityPoint(0.0, 0.0, 1.0);
        EntityPlane plane = new EntityPlane(point1, point2, point3);

        PlaneHolder.getPlaneHolder().add(plane);
        int size = PlaneHolder.getPlaneHolder().size();
        Assert.assertEquals(size, expectedSize);
    }
}
