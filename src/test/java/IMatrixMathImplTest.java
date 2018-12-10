import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class IMatrixMathImplTest {

  private static final double[][] VALID_MATRIX_1 = {
      new double[]{1, 2, 3},
      new double[]{0, 1, 4},
      new double[]{5, 8, 0},
  };

  private static final double[][] VALID_MATRIX_2 = {
      new double[]{1, 2, 3},
      new double[]{1, 2, 3},
      new double[]{1, 2, 3},
  };

  @Test
  void testInverseMatrix() throws InvalidDimensionException {
    double[][] inversedMatrix = {
        new double[]{-4, 3, 0.625},
        new double[]{2.5, -1.875, -0.5},
        new double[]{-0.625, 0.25, 0.125},
    };

    IMatrixMath iMatrixMath = new IMatrixMathImpl();
    IMatrix iMatrix = new IMatrixImpl();

    iMatrix.setMatrixValues(VALID_MATRIX_1);
    assertEquals(Arrays.deepToString(inversedMatrix),
        Arrays.deepToString(iMatrixMath.inverseMatrix(iMatrix).getMatrix()));
  }

  @Test
  void testAddMatrix() throws InvalidDimensionException {
    double[][] addedMatrix = {
        new double[]{2, 4, 6},
        new double[]{1, 3, 7},
        new double[]{6, 10, 3},
    };

    IMatrixMath iMatrixMath = new IMatrixMathImpl();
    IMatrix iMatrix = new IMatrixImpl();
    IMatrix iMatrix1 = new IMatrixImpl();

    iMatrix.setMatrixValues(VALID_MATRIX_1);
    iMatrix1.setMatrixValues(VALID_MATRIX_2);
    assertEquals(Arrays.deepToString(addedMatrix),
        Arrays.deepToString(iMatrixMath.matrixAddition(iMatrix, iMatrix1).getMatrix()));
  }

  @Test
  void testSubMatrix() throws InvalidDimensionException {
    double[][] subMatrix = {
        new double[]{0, 0, 0},
        new double[]{-1, -1, 1},
        new double[]{4, 6, -3},
    };

    IMatrixMath iMatrixMath = new IMatrixMathImpl();
    IMatrix iMatrix = new IMatrixImpl();
    IMatrix iMatrix1 = new IMatrixImpl();

    iMatrix.setMatrixValues(VALID_MATRIX_1);
    iMatrix1.setMatrixValues(VALID_MATRIX_2);
    assertEquals(Arrays.deepToString(subMatrix),
        Arrays.deepToString(iMatrixMath.matrixSubtracting(iMatrix, iMatrix1).getMatrix()));
  }

  @Test
  void testMulMatrix() throws InvalidDimensionException {
    double[][] mulMatrix = {
        new double[]{6, 12, 18},
        new double[]{5, 10, 15},
        new double[]{13, 26, 39},
    };

    IMatrixMath iMatrixMath = new IMatrixMathImpl();
    IMatrix iMatrix = new IMatrixImpl();
    IMatrix iMatrix1 = new IMatrixImpl();

    iMatrix.setMatrixValues(VALID_MATRIX_1);
    iMatrix1.setMatrixValues(VALID_MATRIX_2);
    assertEquals(Arrays.deepToString(mulMatrix),
        Arrays.deepToString(iMatrixMath.matrixMultiplication(iMatrix, iMatrix1).getMatrix()));
  }

  @Test
  void testTransMatrix() throws InvalidDimensionException {
    double[][] mulMatrix = {
        new double[]{1, 1, 1},
        new double[]{2, 2, 2},
        new double[]{3, 3, 3},
    };

    IMatrixMath iMatrixMath = new IMatrixMathImpl();
    IMatrix iMatrix1 = new IMatrixImpl();

    iMatrix1.setMatrixValues(VALID_MATRIX_2);
    assertEquals(Arrays.deepToString(mulMatrix),
        Arrays.deepToString(iMatrixMath.matrixTransposition(iMatrix1).getMatrix()));
  }


  @Test
  void testScalarMatrix() throws InvalidDimensionException {
    double[][] mulMatrix = {
        new double[]{2, 4, 6},
        new double[]{2, 4, 6},
        new double[]{2, 4, 6},
    };

    IMatrixMath iMatrixMath = new IMatrixMathImpl();
    IMatrix iMatrix1 = new IMatrixImpl();

    iMatrix1.setMatrixValues(VALID_MATRIX_2);
    assertEquals(Arrays.deepToString(mulMatrix),
        Arrays.deepToString(iMatrixMath.scalarMultiplication(iMatrix1, 2).getMatrix()));
  }
}
