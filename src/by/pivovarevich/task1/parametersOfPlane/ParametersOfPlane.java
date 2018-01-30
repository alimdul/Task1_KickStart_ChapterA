package by.pivovarevich.task1.parametersOfPlane;

public class ParametersOfPlane<T1, T2> {

    private T1 firstParameter = null;
    private T2 secondParameter = null;

    public ParametersOfPlane() {
        this.firstParameter = firstParameter;
        this.secondParameter = secondParameter;
    }

    public T1 getFirstParameter() {
        return firstParameter;
    }

    public void setFirstParameter(T1 firstParameter) {
        this.firstParameter = firstParameter;
    }

    public T2 getSecondParameter() {
        return secondParameter;
    }

    public void setSecondParameter(T2 secondParameter) {
        this.secondParameter = secondParameter;
    }
}
