public class BisectionSolver implements RootSolver {
    private double tolerance;
    private int maxIterations;

    /**
     * Khởi tạo giá trị các tham số.
     * @param tolerance
     * @param maxIterations
     */
    public BisectionSolver(double tolerance, int maxIterations) {
        this.tolerance = tolerance;
        this.maxIterations = maxIterations;
    }

    /**
     * Tìm nghiệm của hàm một biến theo phương pháp chia đôi (Bisection)
     * @param function
     * @param lower
     * @param upper
     * @return nghiệm của hàm.
     */
    @Override
    public double solve(AbstractFunction function, double lower, double upper) {
        double x0 = lower;
        double x1 = upper;
        
        // Kiểm tra điều kiện ban đầu
        double f0 = function.evaluate(x0);
        double f1 = function.evaluate(x1);
        
        if (Math.abs(f0) < tolerance) {
            return x0;
        }
        if (Math.abs(f1) < tolerance) {
            return x1;
        }

        if (f0 * f1 > 0) {
            return Double.NaN;  
        }
        
        for (int i = 0; i < maxIterations; i++) {
            double x2 = (x0 + x1) / 2;  
            double f2 = function.evaluate(x2);

            if (Math.abs(f2) < tolerance) {
                return x2;
            }
            
            // Nếu f0 và f2 có dấu khác nhau, thì nghiệm nằm trong đoạn [x0, x2]
            if (f0 * f2 < 0) {
                x1 = x2;
                f1 = f2;
            } else {
                // Nếu f2 và f1 có dấu khác nhau, thì nghiệm nằm trong đoạn [x2, x1]
                x0 = x2;
                f0 = f2;
            }
        }
        
        return Double.NaN;  
    }
}
