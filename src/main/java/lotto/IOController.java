package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;

public class IOController {


    public Integer inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String s = Console.readLine();
        return Integer.parseInt(s);
    }

    public void printLottoList(List<Lotto> lottoList) {
        System.out.println(lottoList.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottoList) {
            System.out.println(lotto);
        }
    }

    public List<Integer> inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String s = Console.readLine();
        List<Integer> winningNumbers = Arrays.stream(s.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();
        return winningNumbers;
    }

    public Integer inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String s = Console.readLine();
        return Integer.parseInt(s);
    }

    public void printWinningStatistics(LottoStatistic lottoStatistic) {
        System.out.println("당첨 통계");
        System.out.println("---");

        printRankStatistics("3개 일치", LottoPrize.FIFTH_PRIZE.getPrizeAmount(), lottoStatistic.getCount3Match());
        printRankStatistics("4개 일치", LottoPrize.FOURTH_PRIZE.getPrizeAmount(), lottoStatistic.getCount4Match());
        printRankStatistics("5개 일치", LottoPrize.THIRD_PRIZE.getPrizeAmount(), lottoStatistic.getCount5Match());
        printRankStatistics("5개 일치, 보너스 볼 일치", LottoPrize.SECOND_PRIZE.getPrizeAmount(),
                lottoStatistic.getCount5MatchWithBonus());
        printRankStatistics("6개 일치", LottoPrize.FIRST_PRIZE.getPrizeAmount(), lottoStatistic.getCount6Match());

        BigDecimal formattedRate = BigDecimal.valueOf(lottoStatistic.getReturnRate()).setScale(1, RoundingMode.HALF_UP);
        System.out.println("총 수익률은 " + formattedRate + "%입니다.");
    }

    private void printRankStatistics(String description, String prize, int lottoCount) {
        System.out.println(description + " (" + prize + "원)" + " - " + lottoCount + "개");
    }
}
