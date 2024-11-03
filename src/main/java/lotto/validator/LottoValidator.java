package lotto.validator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoValidator {
    private LottoValidator() {
    }

    public static void validSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    public static void validateNumberRange(List<Integer> numbers) {
        numbers.forEach(number -> {
            if (number <= 0 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        });
    }


    public static void checkDuplicateNumber(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
    }

    public static List<Integer> makeLottoNumberList(String input) {
        try {
            return Arrays.stream(input.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 숫자를 입력해야 합니다.");
        }
    }

    public static void validateInput(String numbers) {
        String[] lottoNumbers = numbers.split(",");

        if (lottoNumbers.length != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개를 입력해야 합니다.");
        }
    }
}
