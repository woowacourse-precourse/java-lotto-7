package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class LottoWinningNumbers {
    private final List<Integer> winningNumbers = new ArrayList<>();
    private int bonusNumber;

    public void inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String inputNumbers = Console.readLine();
        for (final String inputNumber : inputNumbers.split(",")) {
            final int number = Integer.parseInt(inputNumber);
            winningNumbers.add(number);
        }
        System.out.println("보너스 번호를 입력해 주세요.");
        bonusNumber = Integer.parseInt(Console.readLine());
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }
}
