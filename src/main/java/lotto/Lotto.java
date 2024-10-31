package lotto;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;


public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        Validator.validateWinningNumbers(numbers);
        this.numbers = numbers;
    }

    public static void printRequestingMoneyInput() {
        System.out.println("구입 금액을 입력해 주세요.");
    }

    public static void printRequestingLottoWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void printRequestingBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public static String getUserInput() {
        return Console.readLine();
    }

    private static int getLottoPurchaseCount(String userInput) {
        int money = Validator.validateMoneyInput(userInput);
        return money / 1000;
    }

    public static Lotto getWinningNumbers(String userInput) {
        List<Integer> winningNumbers = new ArrayList<Integer>();

        String[] numbers = userInput.split(",", -1);

        for (String number : numbers) {
            int validatedNumber = Validator.validateLottoNumber(number);
            winningNumbers.add(validatedNumber);
        }

        return new Lotto(winningNumbers);
    }

    public static int getBonusNumber(List<Integer> winningNumbers, String userInput) {
        int bonusNumber = Validator.validateLottoNumber(userInput);
        Validator.validateBonusNumber(winningNumbers, bonusNumber);
        return bonusNumber;
    }
}
