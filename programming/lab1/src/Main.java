public class Main {
    public static void main(String[] args) {
        // 1
        short[] I;
        I = new short[10];

        short n = 23;
        for (int i = 0; i < I.length; i++) {
            I[i] = n;
            n -= 2;
        }

        System.out.print("Массив I: ");
        System.out.print("{ ");
        for (int i = 0; i < I.length; i++) {
            System.out.print(I[i]);
            System.out.print(' ');
        }
        System.out.println('}');

        // 2
        double[] x;
        x = new double[11];

        final double min;
        final double max;

        min = -14.0;
        max = 7.0;

        for (int i = 0; i < x.length; i++) {
            x[i] = random_value(-14.0, 7.0);
        }

        System.out.print("Массив x: ");
        System.out.print("{ ");
        for (int i = 0; i < x.length; i++) {
            System.out.print(x[i]);
            System.out.print(' ');
        }
        System.out.print('}');

        // 3
        double[][] w = new double[10][11];
        short[] m = new short[]{9, 11, 15, 19, 21};
        double tmp;

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 11; j++) {
                tmp = x[j];
                if (I[i] == 13) {
                    w[i][j] = function1(tmp);
                } else if (find(I[i], m)) {
                    w[i][j] = function2(tmp);
                } else {
                    w[i][j] = function3(tmp);
                }
            }
        }
        System.out.println();
        System.out.println("Массив w : ");
        System.out.print("{\n");

        for (int i = 0; i < w.length; i++) {
            for (int j = 0; j < w[i].length; j++) {
                System.out.print(w[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }

        System.out.println("}");
    }

    public static double random_value(double min, double max) {
        double coefficient = max - min;
        double roundNumber = Math.round((Math.random() * (coefficient + 1)) * 100) / 100d;
        return (double) (roundNumber) + min;
    }

    public static boolean find(short element, short[] massive) {
        for (short x : massive) {
            if (x == element) {
                return true;
            }
        }
        return false;
    }

    public static double function1(double x) {
        double operation1, operation2, operation3;
        operation1 = (Math.pow(Math.pow((x + (1.0d / 3.0d)) / 0.25d, x), (1.0d / 3.0d)));
        operation2 = 2.0d / (Math.exp(Math.log(Math.abs(x)) - (2.0d / 3.0d)));
        operation3 = Math.pow(operation1, operation2);
        return Math.round(operation3 * 10000) / 10000d;
    }

    public static double function2(double x) {
        double operation;
        operation = Math.exp(Math.pow(Math.cos(x), 0.5d / Math.atan((x - 3.5d) / 21d)));
        return Math.round(operation * 10000) / 10000d;
    }

    public static double function3(double x) {
        double operation;
        operation = Math.asin(Math.sin(Math.exp(Math.pow(4 / (Math.atan((x - 3.5d) / 21d) - 1), 3))));
        return Math.round(operation * 10000) / 10000d;
    }
}