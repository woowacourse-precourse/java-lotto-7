package lotto.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Validator {
    public int validateConvertToNumber(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR]숫자를 입력해주세요");
        }
    }

    public List<Integer> validateIsNumeric(String lottoNumbers) {
        List<String> numbers = Arrays.stream(lottoNumbers.split(",")).toList();
        List<Integer> validateNumber = new ArrayList<>();
        for (String number : numbers) {
            validateNumber.add(validateConvertToNumber(number));
        }
        return validateNumber;
    }
}
