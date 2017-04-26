package reader;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by joaop on 25/04/2017.
 */
public class NumberReader {

    public List<Double[]> getValues(File file) throws IOException {
        List<Double[]> doubles = new ArrayList<>();
        if (file == null || !file.exists() || !file.canRead())
            return doubles;

        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;

        while ((line = br.readLine()) != null) {
            String[] numbers = line.split(" ");
            Double[] array = new Double[numbers.length];
            for (int i = 0; i < numbers.length; i++) {
                String number = numbers[i];
                double d = Double.parseDouble(number);
                array[i] = d;
            }
            doubles.add(array);
        }

        return doubles;
    }
}
