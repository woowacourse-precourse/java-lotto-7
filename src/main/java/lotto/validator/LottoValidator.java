package lotto.validator;

import static lotto.constant.ErrorCode.*;
import static lotto.constant.LottoConfig.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoValidator {
    private LottoValidator() {
    }

    public static void validSize(List<Integer> numbers) {
        if (numbers.size() != NUMBER_COUNT.getValue()) {
            throw new IllegalArgumentException(INVALID_LOTTO_SIZE.getMessage());
        }
    }

    public static void validateNumberRange(List<Integer> numbers) {
        numbers.forEach(number -> {
            if (number < MIN_NUMBER.getValue() || number > MAX_NUMBER.getValue()) {
                throw new IllegalArgumentException(OUT_OF_RANGE_LOTTO_NUMBER.getMessage());
            }
        });
    }


    public static void checkDuplicateNumber(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(DUPLICATE_LOTTO_NUMBER.getMessage());
        }
    }

    public static List<Integer> makeLottoNumberList(String input) {
        try {
            return Arrays.stream(input.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

        } catch (Exception e) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER.getMessage());
        }
    }

    public static void validateInput(String numbers) {
        String[] lottoNumbers = numbers.split(",");

        if (lottoNumbers.length != NUMBER_COUNT.getValue()) {
            throw new IllegalArgumentException(INVALID_LOTTO_SIZE.getMessage());
        }
    }
}
