package by.pivovarevich.task1.observer;

import by.pivovarevich.task1.entity.EntityPlane;
import by.pivovarevich.task1.entity.PlaneHolder;

import java.util.Observable;
import java.util.Observer;

public class PlaneObserver implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        PlaneHolder.getPlaneHolder().changeParameters((EntityPlane) o);
    }
}
