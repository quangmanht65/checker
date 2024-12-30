import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

public class TestRootFinding {
    public static void main(String[] args) {
        /* TODO
        Chạy các hàm test để test chương trình.
        Lưu kết quả chạy chương trình vào file text có tên <TenSinhVien_MaSinhVien_RootSolver>.txt
        (ví dụ, NguyenVanA_123456_RootSolver.txt).
        Nén tất cả các file source code và file kết quả chạy chương trình vào file zip có tên
        <TenSinhVien_MaSinhVien_RootSolver>.zip (ví dụ, NguyenVanA_123456_RootSolver.txt), và nộp bài
        lên classroom.
        */
        testRootSolver();
    }

    public static void testRootSolver() {
        /* TODO
         - Viết chương trình tìm nghiệm của hàm (sin(x).x - 3) theo các phương pháp đã cho (Bisection, Newton-Raphson, Secant) sử dụng
           UnivariateRealRootFinding. Các phương pháp tìm nghiệm có thể thay đổi ở thời gian chạy chương trình.
         - In ra phương pháp sử dụng, hàm và nghiệm tìm được trong khoảng [a, b] đã cho.
         */

        double lower = 5;
        double upper = 8;

        AbstractFunction function = new UnivariateRealFunction() {
            @Override
            public double evaluate(double x) {
                return Math.sin(x) * x - 3;
            }

            @Override
            public double derivative(double x) {
                return Math.cos(x) * x + Math.sin(x);
            }
        };

        // Khởi tạo UnivariateRealRootFinding với hàm đã cho
        UnivariateRealRootFinding rootFinding = new UnivariateRealRootFinding(function);


        RootSolver bisectionSolver = new BisectionSolver(1e-6, 1000);
        RootSolver newtonRaphsonSolver = new NewtonRaphsonSolver(1e-6, 1000);
        RootSolver secantSolver = new SecantSolver(1e-6, 1000);

        try (PrintWriter writer = new PrintWriter(new FileWriter("BuiMinhQuan_20002086_RootSolver.txt", StandardCharsets.UTF_8))) {
            // Test phương pháp Bisection
            writer.write("Phương pháp: Bisection Solver\n");
            rootFinding.setRootSolver(bisectionSolver);
            double resultBisection = rootFinding.solve(lower, upper);
            writer.write("Hàm: sin(x) * x - 3\n");
            writer.write("Nghiệm: " + resultBisection + "\n\n");

            // Test phương pháp Newton-Raphson
            writer.write("Phương pháp: Newton-Raphson Solver\n");
            rootFinding.setRootSolver(newtonRaphsonSolver);
            double resultNewton = rootFinding.solve(lower, upper);
            writer.write("Function: sin(x) * x - 3\n");
            writer.write("Nghiệm: " + resultNewton + "\n\n");

            // Test phương pháp Secant
            writer.write("Phương pháp: Secant Solver\n");
            rootFinding.setRootSolver(secantSolver);
            double resultSecant = rootFinding.solve(lower, upper);
            writer.write("Function: sin(x) * x - 3\n");
            writer.write("Nghiệm: " + resultSecant + "\n\n");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}
