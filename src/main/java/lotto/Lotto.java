package lotto;

import java.util.ArrayList;
import java.util.List;


public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        Validator.validateWinningNumbers(numbers);
        this.numbers = numbers;
    }

    public static Lotto getWinningNumbers() {
        printRequestingLottoWinningNumbers();

        String numbersInput = InputHandler.getUserInput();
        System.out.println();

        return Lotto.getNumbersFromInput(numbersInput);
    }

    public static int getBonusNumber(Lotto winningNumbers) {
        printRequestingBonusNumber();

        String numberInput = InputHandler.getUserInput();
        return getBonusNumberFromInput(winningNumbers, numberInput);
    }

    private static void printRequestingLottoWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    private static void printRequestingBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    private static Lotto getNumbersFromInput(String userInput) {
        List<Integer> winningNumbers = new ArrayList<Integer>();

        String[] numbers = userInput.split(",", -1);

        for (String number : numbers) {
            int validatedNumber = Validator.validateLottoNumber(number);
            winningNumbers.add(validatedNumber);
        }

        return new Lotto(winningNumbers);
    }

    private static int getBonusNumberFromInput(Lotto numbers, String userInput) {
        int bonusNumber = Validator.validateLottoNumber(userInput);
        Validator.validateBonusNumber(numbers, bonusNumber);

        return bonusNumber;
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

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
