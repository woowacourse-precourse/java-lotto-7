package lotto.view;

import java.util.List;
import java.util.StringJoiner;
import lotto.util.LottoPrint;

public class OutputView {
    public void askPayment() {
        System.out.println(LottoPrint.ASK_PAYMENT.getMessage());
    }

    public void alertBuyingNumber(int buyingNumber) {
        System.out.println(buyingNumber + LottoPrint.ALERT_BUYING_NUMBER.getMessage());
    }

    public void alertEarningRate(double earningRate) {
        System.out.println("총 수익률은 " + earningRate + "%입니다.");
    }

    public void printSortedNumbers(List<List<Integer>> sortedNumbers) {
        for (List<Integer> numbers : sortedNumbers) {
            printNumbers(numbers);
        }
    }

    private void printNumbers(List<Integer> numbers) {
        StringJoiner lottoJoiner = new StringJoiner(", ", "[", "]");
        for (Integer number : numbers) {
            lottoJoiner.add(String.valueOf(number));
        }
        System.out.println(lottoJoiner);
    }


    public void askWinningNumbers() {
        System.out.println(LottoPrint.ASK_WINNING_NUMBERS.getMessage());
    }

    public void askBonusNumber() {
        System.out.println(LottoPrint.ASK_BONUS_NUMBER.getMessage());
    }

    public void alertStartStat() {
        System.out.println(LottoPrint.ALERT_START_STAT.getMessage());
    }

    // 등수 결과로 출력하는 함수
    public void printLottoResults(int[] countRank) {
        System.out.println(LottoPrint.STAT_PREFIX_5th.getMessage()+ countRank[5] + LottoPrint.STAT_SUFFIX.getMessage());
        System.out.println(LottoPrint.STAT_PREFIX_4th.getMessage()+ countRank[4] + LottoPrint.STAT_SUFFIX.getMessage());
        System.out.println(LottoPrint.STAT_PREFIX_3rd.getMessage()+ countRank[3] + LottoPrint.STAT_SUFFIX.getMessage());
        System.out.println(LottoPrint.STAT_PREFIX_2nd.getMessage()+ countRank[2] + LottoPrint.STAT_SUFFIX.getMessage());
        System.out.println(LottoPrint.STAT_PREFIX_1st.getMessage()+ countRank[1] + LottoPrint.STAT_SUFFIX.getMessage());
    }

}
