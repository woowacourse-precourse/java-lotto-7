package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class InputView {
    public Integer inputTotalMoney() {
        Integer totalMoney;

        System.out.println("구입금액을 입력해 주세요.");
        String raw = Console.readLine();
        totalMoney = InputParser.parseTotalMoney(raw);

        return totalMoney;
    }

    public List<Integer> inputWinningNumbers() {
        List<Integer> winningNumbers;

        System.out.println("\n당첨 번호를 입력해 주세요.");

        while (true) {
            try {
                String raw = Console.readLine();
                winningNumbers = InputParser.parseWinningNumbers(raw);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return winningNumbers;
    }

    public Integer inputBonusNumber() {
        Integer bonusNumber;

        System.out.println("\n보너스 번호를 입력해 주세요.");
        String raw = Console.readLine();
        bonusNumber = InputParser.parseNumber(raw);


        return bonusNumber;
    }
}
