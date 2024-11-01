package lotto;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;


public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        Validator.validateWinningNumbers(numbers);
        this.numbers = numbers;
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    public List<Integer> getNumbers() {
        return numbers;
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

    public static int getLottoPurchaseCount(String userInput) {
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

    public static int getBonusNumber(Lotto numbers,String userInput) {
        int bonusNumber = Validator.validateLottoNumber(userInput);
        Validator.validateBonusNumber(numbers, bonusNumber);

        return bonusNumber;
    }

    public static List<Integer> getOneRandomLotto() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public static int numberMatchCount(Lotto numbers, List<Integer> randomLotto) {
        int numberMatch = 0;

        for (int winningNumber : numbers.getNumbers()) {
            if (randomLotto.contains(winningNumber)) {
                numberMatch += 1;
            }
        }

        return numberMatch;
    }
}
