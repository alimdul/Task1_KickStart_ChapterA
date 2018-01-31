package by.pivovarevich.task1.util;

public class IdGenerator {

    private static long planeId = 1;

    public static long countPlaneIdentifier() {
        return planeId++;
    }
}
