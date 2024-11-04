package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class InputValidator {
    private static final Integer LOTTO_NUMBER_CNT = 6;
    private static final Integer MINIMUM_MONEY = 1000;
    private static final String NUMBER_REGEX = "^[1-9][0-9]*$";

    public static Integer validatePurchaseInput(String input) {
        validateSting(input);
        if (!input.matches(NUMBER_REGEX))
            throw new IllegalArgumentException("금액이 잘못 되었습니다.");

        Integer purchaseAmount = Integer.parseInt(input);
        if (purchaseAmount % MINIMUM_MONEY != 0)
            throw new IllegalArgumentException("로또 금액은 1000원 단위 입니다.");

        return purchaseAmount / MINIMUM_MONEY;
    }

    public static List<Integer> validateUserPickedNumbersInput(String input) {
        validateSting(input);

        List<Integer> result = Arrays.stream(input.split(","))
                .map(InputValidator::stringToInt)
                .collect(Collectors.toCollection(ArrayList::new));

        validateCount(result);
        validateUnique(result);
        Collections.sort(result);

        return Collections.unmodifiableList(result);
    }

    public static Integer validateBonusInput(String input) {
        validateSting(input);
        return stringToInt(input);
    }

    public static void validateUniqueNumbers(List<Integer> userPickedNumbers, Integer bonusNumber) {
        List<Integer> total = new ArrayList<>();
        total.addAll(userPickedNumbers);
        total.add(bonusNumber);

        validateUnique(total);
    }

    private static void validateSting(String str) {
        if (str == null)
            throw new IllegalArgumentException("문자열을 입력해주세요");

        String withoutWhiteSpaceFrontBack = str.trim();
        if (withoutWhiteSpaceFrontBack.isEmpty())
            throw new IllegalArgumentException("문자열을 입력해주세요");

    }

    private static void validateCount(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_CNT)
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
    }

    private static void validateUnique(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size())
            throw new IllegalArgumentException("로또 번호는 중복 되지 않아야 합니다.");
    }

    private static Integer stringToInt(String str) {
        if (!str.trim().matches(NUMBER_REGEX))
            throw new IllegalArgumentException("번호가 잘못 되었습니다.");
        Integer number = Integer.parseInt(str.trim());
        if (number < 1 || number > 45)
            throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");

        return number;
    }
}
