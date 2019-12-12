package lab0;

import lab0.Variant1;
import lab0.Variant1.DAY_OF_WEEK;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Variant1Test {
    public static double EPS = 0.1;

    @Test(dataProvider = "inputProvider")
    public void inputTest(int p1, long p3) {
        assertEquals(new Variant1().inputOutputTask(p1), p3);
    }

    @DataProvider
    public Object[][] inputProvider() {
        return new Object[][] { { 2, 8 }, { 6, 24 } };
    }

    ////////////////////////////////////////////////

    @Test(dataProvider = "integerProvider")
    public void integerTest(int p1, int p3) {
        assertEquals(new Variant1().integerNumbersTask(p1), p3);
    }

    @DataProvider
    public Object[][] integerProvider() {
        return new Object[][] { { 100, 1 }, { 12, 0 }, { 139, 1 } };
    }

    ////////////////////////////////////////////////

    @Test(dataProvider = "ifProvider")
    public void ifTest(int p1, int p3) {
        assertEquals(new Variant1().ifTask(p1), p3);
    }

    @DataProvider
    public Object[][] ifProvider() {
        return new Object[][] { { 2, 3 }, { 0, 0 }, { -3, -3 } };
    }

    //////////////////////////////////////////////////

    @Test(dataProvider = "booleanProvider")
    public void booleanTest(int p1, boolean p3) {
        assertEquals(new Variant1().booleanTask(p1), p3);
    }

    @DataProvider
    public Object[][] booleanProvider() {
        return new Object[][] { { 5, true }, { 0, false }, { -3, false } };
    }

    //////////////////////////////////////////////////

    @Test(dataProvider = "switchProvider")
    public void switchTest(int p1, Variant1.DAY_OF_WEEK p2) {
        assertEquals(new Variant1().switchTask(p1), p2);
    }

    @DataProvider
    public Object[][] switchProvider() {
        return new Object[][] { { 3, Variant1.DAY_OF_WEEK.WEDNESDAY },
                { 6, DAY_OF_WEEK.SATURDAY } };
    }

    ///////////////////////////////////////////////////

    @Test(dataProvider = "forProvider")
    public void forTest(int n, double p2) {
        assertEquals(new Variant1().forTask(n), p2, EPS);
    }

    @DataProvider
    public Object[][] forProvider() {
        return new Object[][] { { 3, 2.666667 }, { 7, 2.718254 }, { 12, 2.718282 } };
    }

    ///////////////////////////////////////////////////

    //////////////////////////////////////////

    @Test(dataProvider = "whileProvider")
    public void whileTest(int a, int b, int c) {
        assertEquals(new Variant1().whileTask(a, b), c);
    }

    @DataProvider
    public Object[][] whileProvider() {
        return new Object[][] { { 10, 2, 0 }, { 12, 10, 2 }, { 12, 1, 0 }, { 25, 7, 4 } };
    }

    @Test(expectedExceptions = AssertionError.class, dataProvider = "negativeWhileProvider")
    public void negativeWhileTest(int a, int b) {
        new Variant1().whileTask(a, b);
    }

    @DataProvider
    public Object[][] negativeWhileProvider() {
        return new Object[][] { { -2, 1 }, { 2, -1 } };
    }

    //////////////////////////////////////////
    @Test(dataProvider = "arrayProvider")
    public void arrayTest(double[] array, double value) {
        assertEquals(new Variant1().arrayTask(array), value);
    }

    @DataProvider
    public Object[][] arrayProvider() {
        return new Object[][] { { new double[] { 10, 3, 2 }, 0 }, { new double[] { 10, 2, 13 }, 10 },
                { new double[] { 4, 3, 5, -4, 9, 2 }, -4 } };
    }



    //////////////////////////////////////////

    @Test(dataProvider = "matrixProvider")
    public void twoDimensionArrayTest(int[][] input, int from, int to, int[][] output) {
        System.out.println(new Variant1().twoDimensionArrayTask(input, from, to));
        assertEquals(new Variant1().twoDimensionArrayTask(input, from, to), output);
    }

    @DataProvider
    public Object[][] matrixProvider() {
        int[][] input = {{2, 3, 6, 9, -9},
                {34, 98, -9, 2, 1},
                {-4, 2, 1, 6, 1},
                {-98, 8, 1, 5, 3}};

        int[][] input23 = {{2, 3, 6, 9, -9},
                {-4, 2, 1, 6, 1},
                {34, 98, -9, 2, 1},
                {-98, 8, 1, 5, 3}};

        int[][] input14 = {{-98, 8, 1, 5, 3},
                {-4, 2, 1, 6, 1},
                {34, 98, -9, 2, 1},
                {2, 3, 6, 9, -9}};

        return new Object[][] { {input, 1, 2, input23}, { input, 0,3, input14 } };

    }

    @Test
    public void arrayTest2(){
        assertEquals(new int[]{2, 3}, new int[]{2, 3});
    }

}