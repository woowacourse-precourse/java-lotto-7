package lotto.view;

import lotto.domain.Ranking;
import java.util.List;

public class OutputView {
    private static final String PURCHASE_AMOUNT = "구매금액을 입력해 주세요.";
    private static final String PURCHASE_QUANTITY = "개를 구매했습니다.";
    private static final String INPUT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final String RESULT_STATISTICS = "당첨 통계";
    private static final String DEVIDING_LINE = "---";
    private static final String LOTTO_SECOND_RANK = "%d개 일치, 보너스 볼 일치 (%s원) - %d개";
    private static final String TOTAL_RETURN = "총 수익률은 %s%%입니다.";

    public void printPurchaseAmount(){
        System.out.println(PURCHASE_AMOUNT);
    }
    public void printPurchaseQuantity(int quantity, List<List<Integer>> lottoNumbers){
        System.out.println();
        System.out.println(quantity+PURCHASE_QUANTITY);
        for(List<Integer> lottos:lottoNumbers){
            System.out.println(lottos);
        }
    }
    public void printInputWinningNumbers(){
        System.out.println();
        System.out.println(INPUT_WINNING_NUMBERS);
    }
    public void printInputBonusNumber(){
        System.out.println();
        System.out.println(INPUT_BONUS_NUMBER);
    }
    public void printResultStatistics(List<Integer> ranking){
        System.out.println();
        System.out.println(RESULT_STATISTICS);
        System.out.println(DEVIDING_LINE);
        for (Ranking rank : Ranking.values()) {
            if (rank == Ranking.SECOND) {
                System.out.println(String.format(LOTTO_SECOND_RANK, rank.getCommonNumber(), rank.getWonPrize(), ranking.get(rank.getIndex())));
                continue;
            }
            System.out.println(String.format("%s - %d개", rank, ranking.get(rank.getIndex())));
        }
    }
    public void printTotalReturn(double returnRate) {
        System.out.println(String.format(TOTAL_RETURN, returnRate));
    }
    public void printErrorMessage(String error) {
        System.out.println(error);
    }
}