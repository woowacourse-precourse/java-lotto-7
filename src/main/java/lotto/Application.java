package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Application {
    private static final LottoService lottoService = new LottoService();

    private static final String INPUT_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String ERROR_AMOUNT_NOT_NUMBER = "[ERROR] 구입 금액은 숫자여야 합니다.";
    private static final String ERROR_INVALID_WINNING_FORMAT = "[ERROR] 잘못된 당첨 번호 형식입니다.";
    private static final String ERROR_BONUS_NOT_NUMBER = "[ERROR] 보너스 번호는 숫자여야 합니다.";
    private static final String ERROR_BONUS_OUT_OF_RANGE = "[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final String ERROR_BONUS_DUPLICATE = "[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.";
    private static final String RESULT_HEADER = "\n당첨 통계\n---";
    private static final String PURCHASED_COUNT_MESSAGE = "개를 구매했습니다.";
    private static final String RETURN_RATE_MESSAGE = "총 수익률은 %.1f%%입니다.\n";

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
        System.out.println(INPUT_AMOUNT_MESSAGE);
        String input = Console.readLine();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_AMOUNT_NOT_NUMBER);
        }
    }

    private static List<Lotto> purchaseAndPrintLottos(int amount) {
        List<Lotto> lottos = lottoService.purchaseLottos(amount);
        System.out.println(lottos.size() + PURCHASED_COUNT_MESSAGE);
        printLottos(lottos);
        return lottos;
    }

    private static void printLottos(List<Lotto> lottos) {
        lottos.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    private static Lotto readWinningNumbers() {
        System.out.println(INPUT_WINNING_NUMBERS_MESSAGE);
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
            throw new IllegalArgumentException(ERROR_INVALID_WINNING_FORMAT);
        }
    }

    private static int readBonusNumber(Lotto winningNumbers) {
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
        String input = Console.readLine();
        try {
            int bonus = Integer.parseInt(input);
            validateBonusNumber(bonus, winningNumbers);
            return bonus;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_BONUS_NOT_NUMBER);
        }
    }

    private static void validateBonusNumber(int bonus, Lotto winningNumbers) {
        if (bonus < 1 || bonus > 45) {
            throw new IllegalArgumentException(ERROR_BONUS_OUT_OF_RANGE);
        }
        if (winningNumbers.containsNumber(bonus)) {
            throw new IllegalArgumentException(ERROR_BONUS_DUPLICATE);
        }
    }

    private static void printResult(List<Lotto> lottos, Lotto winningNumbers, int bonusNumber, int amount) {
        System.out.println(RESULT_HEADER);
        Map<LottoRank, Integer> result = lottoService.checkWinning(lottos, winningNumbers, bonusNumber);
        printWinningStatistics(result);
        double returnRate = lottoService.calculateReturnRate(result, amount);
        System.out.printf(RETURN_RATE_MESSAGE, returnRate);
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
