package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Application {
    private static final LottoService lottoService = new LottoService();

    public static void main(String[] args) {
        try {
            run();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void run() {
        int amount = readPurchaseAmount();
        List<Lotto> lottos = purchaseAndPrintLottos(amount);
        Lotto winningNumbers = readWinningNumbers();
        int bonusNumber = readBonusNumber(winningNumbers);
        printResult(lottos, winningNumbers, bonusNumber, amount);
    }

    private static int readPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자여야 합니다.");
        }
    }

    private static List<Lotto> purchaseAndPrintLottos(int amount) {
        List<Lotto> lottos = lottoService.purchaseLottos(amount);
        System.out.println(lottos.size() + "개를 구매했습니다.");
        printLottos(lottos);
        return lottos;
    }

    private static void printLottos(List<Lotto> lottos) {
        lottos.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    private static Lotto readWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        List<Integer> numbers = parseNumbers(input);
        return new Lotto(numbers);
    }

    private static List<Integer> parseNumbers(String input) {
        try {
            return Arrays.stream(input.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 잘못된 당첨 번호 형식입니다.");
        }
    }

    private static int readBonusNumber(Lotto winningNumbers) {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        try {
            int bonus = Integer.parseInt(input);
            validateBonusNumber(bonus, winningNumbers);
            return bonus;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자여야 합니다.");
        }
    }

    private static void validateBonusNumber(int bonus, Lotto winningNumbers) {
        if (bonus < 1 || bonus > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        if (winningNumbers.containsNumber(bonus)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    private static void printResult(List<Lotto> lottos, Lotto winningNumbers, int bonusNumber, int amount) {
        System.out.println("\n당첨 통계\n---");
        Map<LottoRank, Integer> result = lottoService.checkWinning(lottos, winningNumbers, bonusNumber);
        printWinningStatistics(result);
        double returnRate = lottoService.calculateReturnRate(result, amount);
        System.out.printf("총 수익률은 %.1f%%입니다.\n", returnRate);
    }

    private static void printWinningStatistics(Map<LottoRank, Integer> result) {
        Arrays.stream(LottoRank.values())
                .filter(rank -> rank != LottoRank.NONE)
                .forEach(rank -> System.out.printf("%s (%,d원) - %d개\n",
                        rank.getDescription(),
                        rank.getPrize(),
                        result.get(rank)));
    }
}