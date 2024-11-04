package lotto.controller;

import static lotto.ErrorMessage.NOT_NUMERIC_ERROR;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Validator {
    public static final String DELIMITER = ",";

    public int validateConvertToNumber(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMERIC_ERROR.getMessage());
        }
    }

    public List<Integer> validateIsNumeric(String lottoNumbers) {
        List<String> numbers = Arrays.stream(lottoNumbers.split(DELIMITER)).toList();
        List<Integer> validateNumber = new ArrayList<>();
        for (String number : numbers) {
            validateNumber.add(validateConvertToNumber(number));
        }
        return validateNumber;
    }
}
