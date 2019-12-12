package lab0;


public class Variant1 {

    public enum DAY_OF_WEEK {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }

    /**
     * @param k is square side
     * @return perimeter
     */
    public int inputOutputTask(int k) {
        return 4 * k;
    }

    /**
     * @param k is distance in cm
     * @return distance in m
     */

    public int integerNumbersTask(int k) {
        return k / 100;
    }

    /**
     * @param number
     * @return true, if number is possitive
     */
    public boolean booleanTask(int number) {
        return number > 0;
    }


    /**
     * @param parameter is integer number
     * @return transformed number
     */
    public int ifTask(int parameter) {
        if (parameter > 0)
            return parameter + 1;
        return parameter;
    }


    /**
     * @param number1
     * @return day of week day represented number1
     */
    public DAY_OF_WEEK switchTask(int number1) {
        switch (number1) {
            case 1:
                return DAY_OF_WEEK.MONDAY;
            case 2:
                return DAY_OF_WEEK.TUESDAY;
            case 3:
                return DAY_OF_WEEK.WEDNESDAY;
            case 4:
                return DAY_OF_WEEK.THURSDAY;
            case 5:
                return DAY_OF_WEEK.FRIDAY;
            case 6:
                return DAY_OF_WEEK.SATURDAY;
            case 7:
                return DAY_OF_WEEK.SUNDAY;
            default:
                return null;
        }
    }


    /**
     * @param n is integer number
     * @return approximated value of exp(1)
     */
    public double forTask(int n) {
        assert n > 0 : "Argument should be more than zero";

        double factorial = 1, e = 1;

        for (int i = 1; i < n; i++) {
            factorial *= i;
            e += 1 / factorial;
        }

        return e;
    }


    public int whileTask(int a, int b) {
        assert (a > 0 && b > 0) : "Argument should be more than zero";

        while (a >= b) {
            a -= b;
        }

        return a;
    }

    public double arrayTask(double[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] < array[array.length - 1])
                return array[i];
        }

        return 0;
    }

    /**
     * @param array
     * @param k1
     * @param k2
     * @return transformed array where row with indexes k1 and k2 was changed
     */
    public int[][] twoDimensionArrayTask(int[][] array, int k1, int k2) {
        int[] temp = array[k1].clone();
        array[k1] = array[k2].clone();
        array[k2] = temp;

        return array;
    }

    public static void main(String[] args) {
        Variant1 obj = new Variant1();
        int[][] input = {{2, 3, 6, 9, -9},
                {34, 98, -9, 2, 1},
                {-4, 2, 1, 6, 1},
                {-98, 8, 1, 5, 3}};
        int arr[][] = obj.twoDimensionArrayTask(input, 0,1);

        for(int i=0; i<4; i++){
            for(int j=0; j<5; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println("\n");
        }
    }

}

