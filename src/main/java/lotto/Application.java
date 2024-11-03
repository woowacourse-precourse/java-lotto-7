package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int purchaseAmount = parsePurchaseAmount();
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

    private static int parsePurchaseAmount() {
        while (true) {
            System.out.println("구입금액을 입력해 주세요.");
            try {
                return InputHandler.getPurchaseAmount(Console.readLine());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static Set<Integer> getWinningNumbers() {
        while (true) {
            System.out.println("당첨 번호를 입력해 주세요");
            try {
                String input = Console.readLine();
                Set<Integer> winningNumbers = parseWinningNumbers(input);
                InputHandler.validateWinningNumbers(winningNumbers);
                return winningNumbers;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static Set<Integer> parseWinningNumbers(String input) {
        try {
            return Stream.of(input.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toSet());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자로만 이루어져야 합니다.");
        }
    }

    private static int getBonusNumber(Set<Integer> winningNumbers) {
        while (true) {
            System.out.println("보너스 번호를 입력해 주세요.");
            try {
                String input = Console.readLine();
                int bonusNumber = parseBonusNumber(input);
                InputHandler.validateBonusNumber(bonusNumber, winningNumbers);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static int parseBonusNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자로만 이루어져야 합니다.");
        }
    }
}
