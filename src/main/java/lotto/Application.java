package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        LottoMachine machine = new LottoMachine();
        try {
            int purchaseAmount = getInputAmount();
            machine.buyTickets(purchaseAmount);

            List<Integer> winningNumbers = getInputWinningNumbers();
            int bonusNumber = getInputBonusNumber();

            WinningResult result = new WinningResult(machine.getTickets(), winningNumbers, bonusNumber);
            result.printResult();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static int getInputAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        int amount = Integer.parseInt(Console.readLine());
        return amount;
    }

    private static List<Integer> getInputWinningNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        return Arrays.stream(Console.readLine().trim().split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static int getInputBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        return Integer.parseInt(Console.readLine().trim());
    }
}
