package io.lotto;

import io.InputHandler;
import util.NumberUtil;

import java.util.*;

import static util.NumberUtil.*;

public class InputLottoHandler {

    private final InputHandler inputHandler = new InputHandler();

    public int getPrice() {
        int number = convertNumberFrom(inputHandler.getUserInput());
        isValidPrice(number);
        return number;
    }

    public List<Integer> getWinningNumbers() {
        List<Integer> numbers = convertNumbersFrom(inputHandler.getUserInput());
        isValidWinningNumbers(numbers);
        return numbers;
    }

    public int getBonusNumber(List<Integer> winningNumbers) {
        int number = convertNumberFrom(inputHandler.getUserInput());
        isValidBonusNumber(number);

        List<Integer> numbers = new ArrayList<>(winningNumbers);
        numbers.add(number);

        isDuplicate(numbers);
        return number;
    }

    public void isValidPrice(int number) {
        isNotPositive(number);
        isZeroNumber(number);
        isDivisibleByThousand(number);
    }


    public void isDivisibleByThousand(int number) {
        if (number % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1,000원 단위로 입력해주세요.");
        }
    }

    public List<Integer> convertNumbersFrom(String userInput) {
        return Arrays.stream(userInput.split(","))
                .map(NumberUtil::convertNumberFrom).toList();
    }

    public void isValidWinningNumbers(List<Integer> numbers) {
        checkLength(numbers);
        isDuplicate(numbers);
        numbers.stream()
                .map(this::checkRange).toList();
    }

    public void isValidBonusNumber(int number) {
        isNotPositive(number);
        isZeroNumber(number);
        checkRange(number);
    }

    public void checkLength(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개가 되어야 합니다.");
        }
    }

    public void isDuplicate(List<Integer> numbers) {
        Set<Integer> noDuplicateNumbers = new HashSet<>(numbers);

        if (numbers.size() != noDuplicateNumbers.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자는 없어야 됩니다.");
        }
    }

    public int checkRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        return number;
    }
}
