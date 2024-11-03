package lotto.domain.input;

import lotto.util.ErrorMessage;
import lotto.view.InputView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {

    private static final int PURCHASE_MIN_UNIT = 1000;
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final int LOTTO_NUMBER_MIN_RANGE = 1;
    private static final int LOTTO_NUMBER_MAX_RANGE = 45;

    /**
     * 올바른 구입 금액 입력 받기
     */
    public static int getValidPurchaseMoney() {
        try {
            int purchaseMoney = convertInteger(InputView.getPurchaseMoney());
            isValidUnit(purchaseMoney);
            return purchaseMoney;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getValidPurchaseMoney();
        }
    }

    /**
     * 문자열을 정수형 숫자로 변환
     */
    public static int convertInteger(String input) {
        try {
            int convertedNumber = Integer.parseInt(input);
            return convertedNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_TYPE_INPUT.getMessage());
        }
    }

    /**
     * 구입 금액이 1000원 단위인지 검사
     */
    public static void isValidUnit(int money) {
        if (money % PURCHASE_MIN_UNIT != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_UNIT.getMessage());
        }
    }

    /**
     * 올바른 당첨 번호 입력 받기
     */
    public static List<Integer> getValidPrizeNumber() {
        try {
            String[] numbers = splitString(InputView.getPrizeNumber());
            List<Integer> prizeNumbers = convertIntegers(numbers);
            isValidRange(prizeNumbers);
            isValidLength(prizeNumbers);
            isDuplicate(prizeNumbers);
            return prizeNumbers;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getValidPrizeNumber();
        }
    }

    /**
     * 쉼표를 기준으로 문자열 분리
     */
    public static String[] splitString(String input) {
        String[] splitedString = input.split(",");
        return splitedString;
    }

    /**
     * 당첨 번호들을 정수형 숫자로 변환하여 리스트로 반환
     */
    public static List<Integer> convertIntegers(String[] input) {
        List<Integer> numbers = new ArrayList<>();
        try {
            for (String number : input) {
                numbers.add(Integer.parseInt(number));
            }
            return numbers;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_TYPE_INPUT.getMessage());
        }
    }

    /**
     * 당첨 번호가 1-45 범위 안에 있는지 검사
     */
    public static void isValidRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < LOTTO_NUMBER_MIN_RANGE || number > LOTTO_NUMBER_MAX_RANGE) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_RANGE.getMessage());
            }
        }
    }

    /**
     * 입력된 당첨 번호가 6개인지 검사
     */
    public static void isValidLength(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LENGTH.getMessage());
        }
    }

    /**
     * 입력된 당첨 번호들의 중복 검사
     */
    public static void isDuplicate(List<Integer> numbers) {
        Set<Integer> convertedSet = new HashSet<>(numbers);
        if (convertedSet.size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_PRIZE_NUMBER.getMessage());
        }
    }

    /**
     * 올바른 보너스 번호를 입력 받기
     */
    public static int getValidBonusNumber(List<Integer> prizeNumbers) {
        try {
            int bonusNumber = convertInteger(InputView.getBonusNumber());
            isValidRange(bonusNumber);
            isDuplicateWithPrizeNumber(prizeNumbers, bonusNumber);

            return bonusNumber;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getValidBonusNumber(prizeNumbers);
        }
    }

    /**
     * 보너스 번호가 1-45 범위 안에 있는지 검사
     */
    public static void isValidRange(int number) {
        if (number < LOTTO_NUMBER_MIN_RANGE || number > LOTTO_NUMBER_MAX_RANGE) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_RANGE.getMessage());
        }
    }

    /**
     * 보너스 번호가 당첨 번호와 중복되지 않는지 검사
     */
    public static void isDuplicateWithPrizeNumber(List<Integer> prizeNumbers, int bonusNumber) {
        for (Integer prizeNumber : prizeNumbers) {
            if (prizeNumber == bonusNumber) {
                throw new IllegalArgumentException(ErrorMessage.DUPLICATE_BONUS_NUMBER.getMessage());
            }
        }
    }
}
