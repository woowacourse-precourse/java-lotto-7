package lotto.core;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningNumbers {
    public static final int MIN_LOTTERY_NUMBER = 1;
    public static final int MAX_LOTTERY_NUMBER = 45;
    public static final int LOTTERY_SIZE = 6;
    public static final String DELIMITER = ",";

    private String numberString;
    private List<Integer> numbers;
    private int bonusNumber;

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public int getBonusNumber() {
        return this.bonusNumber;
    }

    public WinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        this.numberString = Console.readLine();
        this.setWinningNumbers();
        this.setBonusNumber();
    }

    private void setWinningNumbers() {
        List<Integer> numbers = Arrays.stream(this.numberString.split(DELIMITER))
            .map(String::trim)
            .map(Integer::parseInt)
            .toList();

        this.validateNumbers(numbers);
        this.numbers = numbers;
    }

    private void setBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        this.bonusNumber = Integer.parseInt(Console.readLine());
    }

    private void validateNumbers(List<Integer> numbers) {
        this.validateSize(numbers);
        this.validateRange(numbers);
        this.validateUniqueNumbers(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTERY_SIZE) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }
    }

    private void validateRange(List<Integer> numbers) {
        boolean isOutOfRange = numbers.stream().anyMatch(num -> num > MAX_LOTTERY_NUMBER || num < MIN_LOTTERY_NUMBER);
        if (isOutOfRange) {
            throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private void validateUniqueNumbers(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("당첨 번호는 중복될 수 없습니다.");
        }
    }
}
