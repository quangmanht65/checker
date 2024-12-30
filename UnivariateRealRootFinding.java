public class UnivariateRealRootFinding {
    private AbstractFunction function;
    private RootSolver rootSolver;

    /**
     * Khởi tạo hàm.
     * @param function
     */
    public UnivariateRealRootFinding(AbstractFunction function) {
        this.function = function;
    }

    /**
     * Khởi tạo hàm và phương pháp tìm nghiệm.
     * @param function
     * @param rootSolver
     */
    public UnivariateRealRootFinding(AbstractFunction function, RootSolver rootSolver) {
        this.function = function;
        this.rootSolver = rootSolver;
    }

    public void setFunction(AbstractFunction function) {
        this.function = function;
    }

    public void setRootSolver(RootSolver rootSolver) {
        this.rootSolver = rootSolver;
    }

    /**
     * Tìm nghiệm của hàm trong đoạn [lower, upper].
     * @param lower
     * @param upper
     * @return nghiệm của hàm.
     */
    public double solve(double lower, double upper) {
        if (rootSolver == null) {
            return Double.NaN; // Trả về giá trị không hợp lệ nếu rootSolver chưa được thiết lập.
        }
        return rootSolver.solve(function, lower, upper);
    }
}
