package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {

    private static long totalCost;
    private static List<Integer> winningNumber;
    private static int bonusNumber;

    public long inputTotalCost() {
        try {
            System.out.println("구입금액을 입력해 주세요.");
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] ");
        }
    }

    public List<Integer> inputWinningNumbers() {
        try {
            System.out.println("\n당첨 번호를 입력해 주세요.");
            return Arrays.stream(Console.readLine().split(","))
                    .map(s -> Integer.parseInt(s.trim()))
                    .toList();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR] ");
        }
    }

    public int inputBonusNumber() {
        try {
            System.out.println("\n보너스 번호를 입력해 주세요.");
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] ");
        }
    }
}
