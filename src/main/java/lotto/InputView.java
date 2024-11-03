package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    private static final InputValidator validator = new InputValidator();

    public static int getInputPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        int inputPrice;

        while (true) {
            String input = Console.readLine();
            try {
                inputPrice = Integer.parseInt(input);
                validator.validatePrice(inputPrice);
                return inputPrice;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 입력값이 유효한 숫자가 아닙니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static List<Integer> getWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> winningNumbers = new ArrayList<>();

        while (true) {
            String input = Console.readLine();
            String[] numbers = input.split(",");
            try {
                winningNumbers = validator.parseNumbers(numbers);
                return winningNumbers;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static int getBonusNumber(List<Integer> winningNumbers) {
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber;

        while (true) {
            String input = Console.readLine();
            try {
                bonusNumber = Integer.parseInt(input);
                validator.validateBonusNumber(bonusNumber, winningNumbers);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}