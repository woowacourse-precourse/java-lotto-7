package lotto.utils;

import java.util.ArrayList;
import java.util.Arrays;

public class InputConverter {
    private static final String DELIMITER = ",";

    public static int convertBudget(String input) {
        return Integer.parseInt(input);
    }

    public static ArrayList<Integer> convertLottoNumbers(String input) {
        ArrayList<Integer> lottoNumbers = new ArrayList<>();
        Arrays.stream(input.split(DELIMITER))
                .map(String::trim)
                .map(Integer::parseInt)
                .forEach(lottoNumbers::add);
        return lottoNumbers;
    }

    private static int convertBonusNumber (String input) {
        return Integer.parseInt(input);
    }

    public static ArrayList<Integer> addBonusNumber(String input, ArrayList<Integer> lottoNumbers) {
        int bonusNumber = convertBonusNumber(input);
        lottoNumbers.add(bonusNumber);
        return lottoNumbers;
    }
}
