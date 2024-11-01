package lotto.view;

import java.util.List;
import java.util.StringJoiner;
import lotto.domain.Lotto;

public class OutputView {
    private static final String ASK_PAYMENT = "구입금액을 입력해 주세요.";
    private static final String ALERT_BUYING_NUMBER = "개를 구매했습니다.";
    private static final String ASK_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String ASK_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";


    public void askPayment() {
        System.out.println(ASK_PAYMENT);
    }

    public void alertBuyingNumber(int buyingNumber) {
        System.out.println(buyingNumber + ALERT_BUYING_NUMBER);
    }

    public void alertEarningRate(double earningRate) {
        System.out.println("총 수익률은 " + earningRate + "%입니다.");
    }

    public void printSortedNumbers(List<List<Integer>> sortedNumbers){
        for(List<Integer> numbers : sortedNumbers){
            printNumbers(numbers);
        }
    }

    private void printNumbers(List<Integer> numbers) {
        StringJoiner lottoJoiner = new StringJoiner(", ", "[", "]");
        for (Integer number : numbers) {
            lottoJoiner.add(String.valueOf(number));
        }
        System.out.println(lottoJoiner) ;
    }


    public void askWinningNumbers() {
        System.out.println(ASK_WINNING_NUMBERS);
    }

    public void askBonusNumber() {
        System.out.println(ASK_BONUS_NUMBER);
    }

    public void alertStartStat() {
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    // 등수 결과로 출력하는 함수
    public void printLottoResults(int[] countRank) {
        // 출력
        System.out.println("3개 일치 (5,000원) - " + countRank[5] + "개");
        System.out.println("4개 일치 (50,000원) - " + countRank[4] + "개");
        System.out.println("5개 일치 (1,500,000원) - " + countRank[3] + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + countRank[2] + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + countRank[1] + "개");
    }

}
