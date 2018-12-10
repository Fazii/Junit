import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class IMatrixImplTest {

  private static final double[][] VALID_MATRIX_1 = {
      new double[]{1, 2, 3},
      new double[]{1, 2, 3},
      new double[]{1, 2, 3},
  };

  private static final double[][] VALID_MATRIX_2 = {
      new double[]{3, 2, 1},
      new double[]{3, 2, 1},
      new double[]{3, 2, 1},
  };



  private static final double[][] INVALID_MATRIX_1 = {
      new double[]{3, 2, 1},
      new double[]{3, 2},
      new double[]{3},
  };

  private static final double[][] INVALID_MATRIX_2 = {
      new double[]{3, 2, 1},
      new double[]{3, 2, 1},
  };

  @Test
  void testCalculateDeterminantForInvalidMatrix() {
    IMatrix iMatrix = new IMatrixImpl();
    assertThrows(InvalidDimensionException.class, () -> iMatrix.determinant(INVALID_MATRIX_2));
  }

  @Test
  void testCalculateDeterminantForValidMatrix() throws InvalidDimensionException {
    IMatrix iMatrix = new IMatrixImpl();
    assertEquals(1.0, iMatrix.determinant(VALID_MATRIX_1));
  }

  @Test
  void testGetMatrixValue() throws InvalidDimensionException {
    IMatrix iMatrix = new IMatrixImpl();
    iMatrix.setMatrixValues(VALID_MATRIX_2);
    assertEquals(3.0, iMatrix.getMatrixValue(0, 0));
  }

  @Test
  void testSetMatrixValue() throws InvalidDimensionException {
    IMatrix iMatrix = new IMatrixImpl();
    iMatrix.setMatrixValues(VALID_MATRIX_1);
    iMatrix.setMatrixValue(0, 0, 10);
    assertEquals(10.0, iMatrix.getMatrixValue(0, 0));
  }

  @Test
  void testSetInvalidMatrixValues() {
    IMatrix iMatrix = new IMatrixImpl();
    assertThrows(InvalidDimensionException.class, () -> iMatrix.setMatrixValues(INVALID_MATRIX_1));
  }

  @Test
  void testGetMatrixWidth() throws InvalidDimensionException {
    IMatrix iMatrix = new IMatrixImpl();
    iMatrix.setMatrixValues(VALID_MATRIX_1);
    assertEquals(3, iMatrix.getWidth());
  }

  @Test
  void testGetMatrixHeight() throws InvalidDimensionException {
    IMatrix iMatrix = new IMatrixImpl();
    iMatrix.setMatrixValues(VALID_MATRIX_1);
    assertEquals(3, iMatrix.getHeight());
  }
}
