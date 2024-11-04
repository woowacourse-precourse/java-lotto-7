package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {

    public static final String DELIMITER = ",";
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;

    public int validateAndGetUserPriceInput(String input) {
        if (input.isEmpty())
            throw new IllegalArgumentException();

        int priceInput;
        try {
            priceInput = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        if (isDividableByOneThousand(priceInput))
            throw new IllegalArgumentException();

        return priceInput;
    }

    public List<Integer> validateAndGetLottoNumber(String input) {
        String[] tokens = input.split(DELIMITER);

        if (tokens.length != 6)
            throw new IllegalArgumentException();

        checkEachTokenIsUnique(tokens);

        return convertEachTokenIntoNumber(tokens);
    }


    public int validateAndGetBonusNumber(String input) {
        int bonusNumber;

        try {
            bonusNumber = Integer.parseInt(input);

            if (isNumberInLegalRange(bonusNumber))
                throw new IllegalArgumentException();

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        return bonusNumber;
    }

    public void checkLottoNumbersContainsBonusNumber(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber))
            throw new IllegalArgumentException();
    }

    private static boolean isDividableByOneThousand(int priceInput) {
        return priceInput % 1000 != 0;
    }

    private void checkEachTokenIsUnique(String[] tokens) {
        Set<String> usedToken = new HashSet<>();

        for (String token : tokens) {

            if (usedToken.contains(token)) {
                throw new IllegalArgumentException();
            }

            usedToken.add(token);
        }
    }

    private static List<Integer> convertEachTokenIntoNumber(String[] tokens) {
        List<Integer> lottoNumbers = new ArrayList<>();
        try {
            for (String token : tokens) {
                lottoNumbers.add(Integer.parseInt(token));
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        return lottoNumbers;
    }

    private static boolean isNumberInLegalRange(int bonusNumber) {
        return bonusNumber < MIN_LOTTO_NUMBER || bonusNumber > MAX_LOTTO_NUMBER;
    }
}
