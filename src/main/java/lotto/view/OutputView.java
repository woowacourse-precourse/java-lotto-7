package lotto.view;

import lotto.enums.WinningMoney;
import lotto.model.Lotto;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class OutputView implements UserOutput {
    private final String THREE_MATCH = "3";
    private final String FOUR_MATCH = "4";
    private final String FIVE_MATCH = "5";
    private final String FIVE_BONUS_MATCH = "5B";
    private final String SIX_MATCH = "6";

    @Override
    public void outputLottoCount(int lottoCount) {
        System.out.println(String.format("%d개를 구매했습니다.", lottoCount));
    }

    @Override
    public void outputStatistics(List<List<Integer>> lottoNumbers) {
        for (List<Integer> lottoNumber : lottoNumbers) {
            Collections.sort(lottoNumber);
            System.out.println(lottoNumber.toString());
        }
    }

    @Override
    public void outputMatchResult(Map<String, Integer> lottoMatchCount) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        System.out.printf("3개 일치 (%d원) - %d개%n", WinningMoney.FIFTH_PRIZE_MONEY.getPrizeMoney(), lottoMatchCount.get(THREE_MATCH));
        System.out.printf("4개 일치 (%d원) - %d개%n", WinningMoney.FOURTH_PRIZE_MONEY.getPrizeMoney(), lottoMatchCount.get(FOUR_MATCH));
        System.out.printf("5개 일치 (%d원) - %d개%n", WinningMoney.THIRD_PRIZE_MONEY.getPrizeMoney(), lottoMatchCount.get(FIVE_MATCH));
        System.out.printf("5개 일치, 보너스 볼 일치 (%d원) - %d개%n", WinningMoney.SECOND_PRIZE_MONEY.getPrizeMoney(), lottoMatchCount.get(FIVE_BONUS_MATCH));
        System.out.printf("6개 일치 (%d원) - %d개%n", WinningMoney.FIRST_PRIZE_MONEY.getPrizeMoney(), lottoMatchCount.get(SIX_MATCH));
    }

    @Override
    public void outputProfitRate(double profitRate) {
        System.out.println(String.format("총 수익률은 %.2f%%입니다.", profitRate));
    }
}
