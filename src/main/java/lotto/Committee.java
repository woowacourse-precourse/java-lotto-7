package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

public class Committee {

    private ArrayList<Integer> winningNumbers = new ArrayList<>();
    private int bonusNumber;

    public Committee() {
        inputWinningNumbers();
        inputBonusNumber();
    }

    private void inputWinningNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        String[] numbers = input.split(",");

        for (String number : numbers) {
            int validatedNumber = validateWinningNumber(number.trim());
            this.winningNumbers.add(validatedNumber);
        }
    }

    private int validateWinningNumber(String number) {
        try {
            int intNumber = Integer.parseInt(number);
            if (this.winningNumbers.contains(intNumber)) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복될 수 없습니다.");
            }
            return intNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자로 입력해야 합니다.");
        }
    }

    private void inputBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        this.bonusNumber = validateBonusNumber(input);
    }

    private int validateBonusNumber(String number) {
        try {
            int intNumber = Integer.parseInt(number);
            if (this.winningNumbers.contains(intNumber)) {
                throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
            }
            return intNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 볼은 숫자로 입력해야 합니다.");
        }
    }
}
