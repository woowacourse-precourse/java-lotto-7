package lotto.domain.input;

import lotto.view.InputView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {

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
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해 주시길 바랍니다.");
        }
    }

    /**
     * 구입 금액이 1000원 단위인지 검사
     */
    public static void isValidUnit(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위로 입력해 주시길 바랍니다.");
        }
    }

    /**
     * 올바른 당첨 번호 입력 받기
     */
    public static List<Integer> getValidPrizeNumber() {
        try {
            String[] numbers = splitString(InputView.getPrizeNumber());
            List<Integer> prizeNumbers = convertIntegers(numbers);
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
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해 주시길 바랍니다.");
        }
    }

    /**
     * 입력된 당첨 번호가 6개인지 검사
     */
    public static void isValidLength(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 당첨 번호를 입력해 주시길 바랍니다.");
        }
    }

    /**
     * 입력된 당첨 번호들의 중복 검사
     */
    public static void isDuplicate(List<Integer> numbers) {
        Set<Integer> convertedSet = new HashSet<>(numbers);
        if (convertedSet.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 중복되지 않는 당첨 번호를 입력해 주시길 바랍니다.");
        }
    }

    /**
     * 올바른 보너스 번호를 입력 받기
     */
    public static int getValidBonusNumber(List<Integer> prizeNumbers) {
        try {
            int bonusNumber = convertInteger(InputView.getBonusNumber());
            isDuplicateWithPrizeNumber(prizeNumbers, bonusNumber);

            return bonusNumber;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getValidBonusNumber(prizeNumbers);
        }
    }

    /**
     * 보너스 번호가 당첨 번호와 중복되지 않는지 검사
     */
    public static void isDuplicateWithPrizeNumber(List<Integer> prizeNumbers, int bonusNumber) {
        for (Integer prizeNumber : prizeNumbers) {
            if (prizeNumber == bonusNumber) {
                throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않아야 합니다.");
            }
        }
    }
}
