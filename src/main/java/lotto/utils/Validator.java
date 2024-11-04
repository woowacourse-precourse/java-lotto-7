package lotto.utils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Validator {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int LOTTO_PRICE = 1000;

    private Validator() {}

    /**
     * 구입 금액의 유효성을 검증합니다.
     *
     * @param amount 구입 금액
     * @throws IllegalArgumentException 유효하지 않은 금액일 경우 예외 발생
     */
    public static void validatePurchaseAmount(int amount) {
        if (amount <= 0 || amount % LOTTO_PRICE != 0) {
            LoggerUtils.logError("구입 금액이 잘못되었습니다: " + amount);
            throw new IllegalArgumentException(ErrorMessages.INVALID_PURCHASE_AMOUNT.getMessage());
        }
    }


    /**
     * 당첨 번호 리스트의 유효성을 검증합니다.
     *
     * @param numbers 당첨 번호 리스트
     * @throws IllegalArgumentException 유효하지 않은 번호가 포함된 경우
     */
    public static void validateWinningNumbers(List<Integer> numbers) {
        if (numbers == null) {
            LoggerUtils.logError("당첨 번호가 null입니다.");
            throw new IllegalArgumentException(ErrorMessages.INVALID_WINNING_NUMBER.getMessage());
        }
        if (numbers.size() != 6) {
            LoggerUtils.logError("당첨 번호 개수가 잘못되었습니다: " + numbers.size());
            throw new IllegalArgumentException(ErrorMessages.INVALID_WINNING_NUMBER.getMessage());
        }
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            LoggerUtils.logError("당첨 번호에 중복된 숫자가 포함되었습니다: " + numbers);
            throw new IllegalArgumentException(ErrorMessages.DUPLICATE_WINNING_NUMBER.getMessage());
        }
        if (numbers.stream().anyMatch(number -> number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER)) {
            LoggerUtils.logError("당첨 번호가 유효 범위를 벗어났습니다: " + numbers);
            throw new IllegalArgumentException(ErrorMessages.WINNING_NUMBER_OUT_OF_RANGE.getMessage());
        }
    }

    /**
     * 보너스 번호의 유효성을 검증합니다.
     *
     * @param number 보너스 번호
     * @throws IllegalArgumentException 보너스 번호가 범위 밖일 경우
     */
    public static void validateBonusNumber(int number) {
        if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            LoggerUtils.logError("보너스 번호가 유효 범위를 벗어났습니다: " + number);
            throw new IllegalArgumentException(ErrorMessages.BONUS_NUMBER_OUT_OF_RANGE.getMessage());
        }
    }

    /**
     * 유효한 입력을 반복적으로 요청하는 메서드
     * @param inputSupplier 입력 값을 제공하는 Supplier
     * @param validation 검증 로직을 담당하는 Predicate
     * @param errorMessage 유효하지 않은 경우 출력할 에러 메시지
     * @param <T> 입력 값의 타입
     * @return 유효한 입력 값
     */
    public static <T> T getValidInput(Supplier<T> inputSupplier, Predicate<T> validation, String errorMessage) {
        while (true) {
            try {
                T input = inputSupplier.get();
                if (validation.test(input)) {
                    LoggerUtils.logInfo("유효한 입력값을 받았습니다: " + input);
                    return input;
                }
                System.out.println(errorMessage);
            } catch (IllegalArgumentException e) {
                LoggerUtils.logError("유효하지 않은 입력입니다: " + e.getMessage());
                System.out.println(e.getMessage());
            }
        }
    }
}