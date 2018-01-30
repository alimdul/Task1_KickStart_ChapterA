package by.pivovarevich.task1.identifierCounter;

public class CountIdentifier {

    private static long planeId = 1;

    public static long countPlaneIdentifier() {
        return planeId++;
    }
}
