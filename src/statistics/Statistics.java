package statistics;

import java.util.Arrays;

/**
 * Created by joaop on 25/04/2017.
 */
public class Statistics {

    public double mean(double... values) {
        double ac = 0;

        for (double value : values) {
            ac += value;
        }

        return ac/values.length;
    }

    public double sd(double... values) {
        double mean = mean(values);

        double ac = 0;
        for (double value : values) {
            ac += (value - mean) * (value - mean);
        }

        return Math.sqrt(ac/(values.length-1));
    }

    public double se(int sds, double... values) {
        double sd = sd(values);

        return sds*sd/Math.sqrt(values.length);
    }

    public double[] sei(int sds, double... values) {
        double mean = mean(values);
        double se = se(sds, values);

        return new double[] {mean - se, mean + se};
    }

    public static void main(String... args) {
        Statistics statistics = new Statistics();
        double[] values = {0.49, 0.42, 0.4, 0.39};
        //double[] values = {0.53, 0.46, 0.5, 0.49};
        //double[] values = {0.46, 0.41, 0.44, 0.41};

        System.out.println("Mean " + statistics.mean(values));
        System.out.println("SD " + statistics.sd(values));
        System.out.println("SE1 " + statistics.se(1, values));
        System.out.println("SE2 " + statistics.se(2, values));
        System.out.println("SE3 " + statistics.se(3, values));
        System.out.println("SEI2 " + Arrays.toString(statistics.sei(2, values)));
    }
}
