package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class WinningNumber {
    private Lotto winningLotto;
    private int bonusNumber;

    public void input() {
        inputWinningNumbers();
        inputBonusNumber();
    }

    private void inputWinningNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        while (true) {
            try {
                String input = Console.readLine();
                setWinningLotto(parseInput(input));
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void inputBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        while (true) {
            try {
                String input = Console.readLine().trim();
                setBonusNumber(parseAndValidateBonusNumber(input));
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<Integer> parseInput(String input) {
        List<Integer> numbers = new ArrayList<>();
        String[] splitNumbers = input.split(",");

        for (String numberStr : splitNumbers) {
            String trimmed = numberStr.trim();
            if (!trimmed.isEmpty()) {
                numbers.add(parseNumber(trimmed));
            }
        }
        return numbers;
    }

    private int parseNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        }
    }

    public void setWinningLotto(List<Integer> numbers) {
        this.winningLotto = new Lotto(numbers);
    }

    public int parseAndValidateBonusNumber(String input) {
        int number = parseNumber(input);
        validateBonusNumberRange(number);
        validateBonusNumberDuplicate(number);
        return number;
    }

    private void validateBonusNumberRange(int number) {
        if (number < Lotto.MIN_NUMBER || number > Lotto.MAX_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1에서 45 사이의 숫자여야 합니다.");
        }
    }

    private void validateBonusNumberDuplicate(int number) {
        if (winningLotto.contains(number)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    public List<Integer> getNumbers() {
        return winningLotto.getNumbers();
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public void setBonusNumber(int number) {
        this.bonusNumber = number;
    }
}