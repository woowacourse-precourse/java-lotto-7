package lotto.utils;

import java.util.ArrayList;
import java.util.Arrays;

public class InputConverter {
    private static final String DELIMITER = ",";

    public static int convertBudget(String input) {
        return Integer.parseInt(input);
    }

    public static ArrayList<Integer> convertWinningNumbers(String input) {
        ArrayList<Integer> lottoNumbers = new ArrayList<>();
        Arrays.stream(input.split(DELIMITER)).map(String::trim).map(Integer::parseInt).forEach(lottoNumbers::add);
        return lottoNumbers;
    }

    public static int convertInputNumber(String input) {
        return Integer.parseInt(input);
    }

    public static ArrayList<Integer> addBonusNumber(String input, ArrayList<Integer> lottoNumbers) {
        int bonusNumber = convertInputNumber(input);
        lottoNumbers.add(bonusNumber);
        return lottoNumbers;
    }
}
