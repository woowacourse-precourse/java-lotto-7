package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class Application {
    public static void main(String[] args) {
        LottoMoney money = receiveMoney();
        List<Lotto> lottos = LottoIssuer.issueLottos(money.amount());

        System.out.println("\n" + LottoMessages.PURCHASE_COUNT.format(lottos.size()));
        lottos.forEach(System.out::println);

        LottoWinNumbers winNumbers = receiveWinNumbers();

        System.out.println(LottoMessages.WIN_STATISTICS.format());
        LottoWinCheck lottoWinCheck = new LottoWinCheck(winNumbers);
        Map<Integer, Integer> rankCounts = lottoWinCheck.getWinResult(lottos);
        showLottoResult(rankCounts);
        showProfitRate(money.amount(), rankCounts);
    }

    private static LottoMoney receiveMoney() {
        System.out.println(LottoMessages.INPUT_MONEY.format());
        while (true) {
            try {
                String input = Console.readLine();
                int amount = InputParser.parseInt(input);
                return new LottoMoney(amount);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static LottoWinNumbers receiveWinNumbers() {
        Lotto lotto = receiveWinning();

        System.out.println("\n" + LottoMessages.INPUT_BONUS_NUMBER.format());
        while (true) {
            try {
                String input = Console.readLine();
                int bonusNumber = InputParser.parseInt(input);

                return new LottoWinNumbers(lotto, bonusNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static Lotto receiveWinning() {
        System.out.println("\n" + LottoMessages.INPUT_WIN.format());
        while (true) {
            try {
                String input = Console.readLine();
                List<Integer> lottoNumbers = InputParser.parseIntList(input);
                return new Lotto(lottoNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void showLottoResult(Map<Integer, Integer> rankCounts) {
        IntStream.iterate(5, i -> i > 0, i -> i - 1)
                .forEach(rank -> {
                    String rankMessage = getLottoRankMessage(rank, rankCounts.getOrDefault(rank, 0));
                    System.out.println(rankMessage);
                });
    }

    private static void showProfitRate(int money, Map<Integer, Integer> rankCounts) {
        LottoProfitCalculator lottoProfitCalculator = new LottoProfitCalculator(rankCounts);
        double profitRate = lottoProfitCalculator.calculateProfitRate(money);
        double roundedRate = (double) Math.round(profitRate * 10) / 10.0;
        System.out.println(LottoMessages.PROFIT_RATE.format(roundedRate));
    }

    private static String getLottoRankMessage(int rank, int count) {
        if (rank == 1) {
            return LottoRank.FIRST.format(count);
        }
        if (rank == 2) {
            return LottoRank.SECOND.format(count);
        }
        if (rank == 3) {
            return LottoRank.THIRD.format(count);
        }
        if (rank == 4) {
            return LottoRank.FOURTH.format(count);
        }
        return LottoRank.FIFTH.format(count);
    }
}
