package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("구입금액을 입력해 주세요.");
        int purchaseAmount = InputHandler.getPurchaseAmount(Console.readLine());
        System.out.println();

        List<Lotto> tickets = Lotto.generateLottoTickets(purchaseAmount);
        System.out.printf("%d개를 구매했습니다.%n", tickets.size());
        tickets.forEach(ticket -> System.out.println(ticket.getNumbers()));
        System.out.println();

        Set<Integer> winningNumbers = getWinningNumbers();
        System.out.println();

        int bonusNumber = getBonusNumber(winningNumbers);
        System.out.println();

        LottoResult lottoResult = new LottoResult(winningNumbers, bonusNumber, tickets);
        lottoResult.printResults();

        double profitRate = lottoResult.calculateProfitRate(purchaseAmount);
        System.out.printf("총 수익률은 %.1f%%입니다.%n", profitRate);
    }

    private static Set<Integer> getWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요 (쉼표로 구분).");
        String input = Console.readLine();
        Set<Integer> winningNumbers = parseWinningNumbers(input);
        InputHandler.validateWinningNumbers(winningNumbers);
        return winningNumbers;
    }

    private static int getBonusNumber(Set<Integer> winningNumbers) {
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine());
        InputHandler.validateBonusNumber(bonusNumber, winningNumbers);
        return bonusNumber;
    }

    private static Set<Integer> parseWinningNumbers(String input) {
        return Stream.of(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toSet());
    }
}
