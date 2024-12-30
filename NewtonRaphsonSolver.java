public class NewtonRaphsonSolver implements RootSolver {
    private double tolerance;
    private int maxIterations;

    /**
     * Khởi tạo giá trị các tham số.
     * @param tolerance
     * @param maxIterations
     */
    public NewtonRaphsonSolver(double tolerance, int maxIterations) {
        this.tolerance = tolerance;
        this.maxIterations = maxIterations;
    }

    /**
     * Tìm nghiệm của hàm một biến sử dụng phương pháp Newton-Raphson.
     * @param function
     * @param lower
     * @param upper
     * @return nghiệm của hàm.
     */
    @Override
    public double solve(AbstractFunction function, double lower, double upper) {
        double x0 = (lower + upper) / 2;
        for (int i = 0; i < maxIterations; i++) {
            double fValue = function.evaluate(x0);
            double fDerivative = function.derivative(x0);
            // if (Math.abs(fDerivative) < 1e-10) {
            //     return Double.NaN; // Trả về giá trị không xác định
            // }
            double x1 = x0 - fValue / fDerivative;
            if (Math.abs(x1 - x0) < tolerance) {
                return x1;
            }
            x0 = x1;
        }
        return Double.NaN; // Trả về giá trị không xác định khi vượt quá số vòng lặp
    }
}
