package lotto.view;

import lotto.constant.LottoGrade;
import lotto.util.ReturnOnInvestmentCalculator;

import java.util.List;
import java.util.Map;

import static lotto.constant.Amount.THOUSAND;

public class OutputView {
    public void displayNumberOfPurchases(int purchaseAmount) {
        System.out.println(purchaseAmount / THOUSAND.getValue() + "개를 구매했습니다.");
    }

    public void showLottoTickets(List<List<Integer>> lottoTickets) {
        lottoTickets.forEach(System.out::println);
    }

    public void announceLottoResults(Map<LottoGrade, Integer> lottoGradeMap, int purchaseAmount) {

        System.out.println("당첨 통계");
        System.out.println("===");
        showMatchedThree(lottoGradeMap);
        showMatchedFour(lottoGradeMap);
        showMatchedFive(lottoGradeMap);
        showMatchedBonus(lottoGradeMap);
        showMatchedAll(lottoGradeMap);
        showReturnOnInvestment(lottoGradeMap, purchaseAmount);
        
    }

    private void showMatchedThree(Map<LottoGrade, Integer> lottoGradeMap) {
        System.out.println("3개 일치 (5,000원) - " + lottoGradeMap.get(LottoGrade.THREE_MATCHED) + "개");
    }

    private void showMatchedFour(Map<LottoGrade, Integer> lottoGradeMap) {
        System.out.println("4개 일치 (50,000원) - " + lottoGradeMap.get(LottoGrade.FOUR_MATCHED) + "개");
    }

    private void showMatchedFive(Map<LottoGrade, Integer> lottoGradeMap) {
        System.out.println("5개 일치 (1,500,000원) - " + lottoGradeMap.get(LottoGrade.FIVE_MATCHED) + "개");
    }

    private void showMatchedBonus(Map<LottoGrade, Integer> lottoGradeMap) {
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + lottoGradeMap.get(LottoGrade.BONUS_MATCHED) + "개");
    }

    private void showMatchedAll(Map<LottoGrade, Integer> lottoGradeMap) {
        System.out.println("6개 일치 (2,000,000,000원) - " + lottoGradeMap.get(LottoGrade.ALL_MATCHED) + "개");
    }

    private void showReturnOnInvestment(Map<LottoGrade, Integer> lottoGradeMap, int purchaseAmount) {
        double calculatedReturnOnInvestment = ReturnOnInvestmentCalculator.calculateReturnOnInvestment(lottoGradeMap, purchaseAmount);
        System.out.println("총 수익률은 " + calculatedReturnOnInvestment + "%입니다.");
    }

}
