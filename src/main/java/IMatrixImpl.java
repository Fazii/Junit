import java.util.Arrays;

public class IMatrixImpl implements IMatrix {

  private double[][] matrix;

  @Override
  public void createIdentityMatrix(int size) {
    double[][] matrix = new double[size][size];
    for (int i = 0; i < size; i++) {
      matrix[i][i] = 1;
    }
    this.matrix = matrix;
  }

  @Override
  public double determinant(double[][] matrix) throws InvalidDimensionException {
    int dimension = matrix[0].length;
    for (int i = 1; i < matrix.length; i++) {
      if (dimension != matrix[i].length) {
        throw new InvalidDimensionException();
      }
    }

    if(dimension != matrix.length) {
      throw new InvalidDimensionException();
    }

    return det(matrix);
  }

  private double det(double[][] mat) {
    if (mat.length == 1) {
      return mat[0][0];
    }
    if (mat.length == 2) {
      return mat[0][0] * mat[1][1] - mat[1][0] * mat[0][1];
    }
    double sum = 0.0, sign = 1.0;
    int newN = mat.length - 1;
    double[][] temp = new double[newN][newN];
    for (int t = 0; t < newN; t++) {
      int q = 0;
      for (int i = 0; i < newN; i++) {
        System.arraycopy(mat[1 + i], q, temp[i], 0, newN);
        if (q == i) {
          q = 1;
        }
      }
      sum += sign * mat[0][t] * det(temp);
      sign *= -1;
    }
    return sum;
  }

  @Override
  public double getMatrixValue(int row, int column) {
    return matrix[row][column];
  }

  @Override
  public void setMatrixValue(int row, int column, double value) {
    matrix[row][column] = value;
  }

  @Override
  public void setMatrixValues(double[][] values) throws InvalidDimensionException {

    int dimension = values[0].length;
    for (int i = 1; i < values.length; i++) {
      if (dimension != values[i].length) {
        throw new InvalidDimensionException();
      }
    }

    matrix = values;
  }

  @Override
  public int getWidth() {
    return matrix[0].length;
  }

  @Override
  public int getHeight() {
    return matrix.length;
  }

  @Override
  public double[][] getMatrix() {
    return this.matrix;
  }

  @Override
  public String toString() {
    return Arrays.deepToString(matrix);
  }
}
