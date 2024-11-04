package lotto.service;

public class ConverterService {
    public static int[] stringArrayToIntegerArray(String[] inputs) {
        int[] result = new int[inputs.length];
        for (int i = 0; i < inputs.length; i++) {
            result[i] = Integer.parseInt(inputs[i]);
        }
        return result;
    }
}
