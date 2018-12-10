public class Main {

  public static void main(String[] args) throws InvalidDimensionException {
    IMatrixImpl iMatrix = new IMatrixImpl();
    IMatrixImpl iMatrix1 = new IMatrixImpl();

    double[][] matrix = new double[][]{
        new double[]{1, 1, 1},
        new double[]{1, 1, 1},
    };

    System.out.println(iMatrix.determinant(matrix));

//
//    iMatrix.setMatrixValues(matrix);
//    iMatrix1.setMatrixValues(matrix);
//
//    System.out.println(iMatrix.getHeight());
//    System.out.println(iMatrix.getWidth());
//
//    IMatrixMath iMatrixMath = new IMatrixMathImpl();
//    System.out.println(iMatrixMath.inverseMatrix(iMatrix));
//
//    System.out.println(iMatrixMath.scalarMultiplication(iMatrix1, 2));

  }

}
