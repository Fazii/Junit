public class IMatrixMathImpl implements IMatrixMath {

  private static double[][] minor(double[][] matrix, int row, int column) {
    double[][] minor = new double[matrix.length - 1][matrix.length - 1];

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; i != row && j < matrix[i].length; j++) {
        if (j != column) {
          minor[i < row ? i : i - 1][j < column ? j : j - 1] = matrix[i][j];
        }
      }
    }
    return minor;
  }

  @Override
  public IMatrix inverseMatrix(IMatrix m1) throws InvalidDimensionException {

    double[][] matrix = m1.getMatrix();
    double[][] inverse = new double[matrix.length][matrix.length];

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        inverse[i][j] = Math.pow(-1, i + j)
            * m1.determinant(minor(matrix, i, j));
      }
    }

    double det = 1.0 / m1.determinant(matrix);
    for (int i = 0; i < inverse.length; i++) {
      for (int j = 0; j <= i; j++) {
        double temp = inverse[i][j];
        inverse[i][j] = inverse[j][i] * det;
        inverse[j][i] = temp * det;
      }
    }

    IMatrix iMatrix = new IMatrixImpl();
    iMatrix.setMatrixValues(inverse);
    return iMatrix;
  }

  @Override
  public IMatrix matrixAddition(IMatrix m1, IMatrix m2) throws InvalidDimensionException {
    double[][] A = m1.getMatrix();
    double[][] B = m2.getMatrix();

    if (A.length != B.length || A[0].length != B[0].length) {
      throw new InvalidDimensionException();
    }

    double[][] C = new double[A.length][A[0].length];

    for (int i = 0; i < A.length; i++) {
      for (int j = 0; j < A[i].length; j++) {
        C[i][j] = A[i][j] + m2.getMatrix()[i][j];
      }
    }

    IMatrix iMatrix = new IMatrixImpl();
    iMatrix.setMatrixValues(C);
    return iMatrix;
  }

  @Override
  public IMatrix matrixMultiplication(IMatrix m1, IMatrix m2) throws InvalidDimensionException {
    int aRows = m1.getMatrix().length;
    int aColumns = m1.getMatrix()[0].length;
    int bRows = m2.getMatrix().length;
    int bColumns = m2.getMatrix()[0].length;

    double[][] A = m1.getMatrix();
    double[][] B = m2.getMatrix();

    if (aColumns != bRows) {
      throw new InvalidDimensionException();
    }

    double[][] C = new double[aRows][bColumns];
    for (int i = 0; i < aRows; i++) {
      for (int j = 0; j < bColumns; j++) {
        C[i][j] = 0.00000;
      }
    }

    for (int i = 0; i < aRows; i++) {
      for (int j = 0; j < bColumns; j++) {
        for (int k = 0; k < aColumns; k++) {
          C[i][j] += A[i][k] * B[k][j];
        }
      }
    }

    IMatrix iMatrix = new IMatrixImpl();
    iMatrix.setMatrixValues(C);
    return iMatrix;
  }

  @Override
  public IMatrix matrixSubtracting(IMatrix m1, IMatrix m2) throws InvalidDimensionException {
    double[][] A = m1.getMatrix();
    double[][] B = m2.getMatrix();

    if (A.length != B.length || A[0].length != B[0].length) {
      throw new InvalidDimensionException();
    }

    double[][] C = new double[A.length][A[0].length];

    for (int i = 0; i < A.length; i++) {
      for (int j = 0; j < A[i].length; j++) {
        C[i][j] = A[i][j] - m2.getMatrix()[i][j];
      }
    }

    IMatrix iMatrix = new IMatrixImpl();
    iMatrix.setMatrixValues(C);
    return iMatrix;
  }

  @Override
  public IMatrix matrixTransposition(IMatrix m1) throws InvalidDimensionException {
    double[][] m = m1.getMatrix();

    int dimension = m[0].length;
    for (int i = 1; i < m.length; i++) {
      if (dimension != m[i].length) {
        throw new InvalidDimensionException();
      }
    }

    double[][] temp = new double[m[0].length][m.length];
    for (int i = 0; i < m.length; i++) {
      for (int j = 0; j < m[0].length; j++) {
        temp[j][i] = m[i][j];
      }
    }

    IMatrix iMatrix = new IMatrixImpl();
    iMatrix.setMatrixValues(temp);
    return iMatrix;
  }

  @Override
  public IMatrix scalarMultiplication(IMatrix m1, double scalar) throws InvalidDimensionException {
    double[][] scalarMatrix = new double[m1.getHeight()][m1.getWidth()];

    for (int i = 0; i < scalarMatrix.length; i++) {
      for (int j = 0; j < scalarMatrix[i].length; j++) {
        scalarMatrix[i][j] = (int) (m1.getMatrix()[i][j] * scalar);
      }
    }

    IMatrix iMatrix = new IMatrixImpl();
    iMatrix.setMatrixValues(scalarMatrix);
    return iMatrix;
  }
}
