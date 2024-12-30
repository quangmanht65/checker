public class UnivariateRealFunction implements AbstractFunction {
    @Override
    public double evaluate(double x) {
        return MyMath.sin(x) * x - 3;
    }

    @Override
    public double derivative(double x) {
        return MyMath.cos(x) * x + MyMath.sin(x);
    }
}
