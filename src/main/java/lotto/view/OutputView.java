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
        System.out.println(String.format("\n%d개를 구매했습니다.", lottoCount));
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
        System.out.println("\n당첨 통계");
        System.out.println("---------");

        System.out.printf("3개 일치 (5,000) - %d개%n", lottoMatchCount.get(THREE_MATCH));
        System.out.printf("4개 일치 (50,000원) - %d개%n", lottoMatchCount.get(FOUR_MATCH));
        System.out.printf("5개 일치 (1,500,000원) - %d개%n", lottoMatchCount.get(FIVE_MATCH));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개%n", lottoMatchCount.get(FIVE_BONUS_MATCH));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개%n", lottoMatchCount.get(SIX_MATCH));
    }

    @Override
    public void outputProfitRate(double profitRate) {
        System.out.println(String.format("총 수익률은 %.1f%%입니다.", profitRate));
    }
}
