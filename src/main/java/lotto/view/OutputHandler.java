package lotto.view;

import lotto.LottoConstants;
import lotto.domain.Lotto;

import javax.swing.text.NumberFormatter;
import java.text.DecimalFormat;
import java.util.List;

public class OutputHandler {
    public void displayLotto(List<Lotto> lottos, int count) {
        StringBuilder lottoPrint = new StringBuilder();
        lottoPrint.append(count).append("개를 구매했습니다.").append('\n');

        for(Lotto lotto : lottos) {
            lottoPrint.append("[");
            lottoPrint.append(printLotto(lotto)).append("]").append('\n');
        }
        System.out.println(lottoPrint);
    }
    public void displayWinning(int[] winnings) {
        StringBuilder winningPrint = new StringBuilder();
        winningPrint.append("당첨 통계").append('\n');
        winningPrint.append("---").append('\n');
        for(int i = 3; i < 6; i++) {
            winningPrint.append(printWinning(i, winnings[i], LottoConstants.RANK_PRICE[i-3]));
        }
        winningPrint.append(printWinning(7, winnings[7], LottoConstants.RANK_PRICE[7-3]));
        winningPrint.append(printWinning(6, winnings[6], LottoConstants.RANK_PRICE[6-3]));
        System.out.println(winningPrint);
    }
    public void displayProfit(double profit) {
        System.out.println("총 수익률은 "+formatToTwoDecimalPlaces(profit)+"입니다.");
    }
    private String printLotto(Lotto lotto) {
        StringBuilder lottoPrint = new StringBuilder();
        for(Integer lo : lotto.getNumbers()) {
            lottoPrint.append(lo).append(", ");
        }
        lottoPrint.deleteCharAt(lottoPrint.length() - 1);
        lottoPrint.deleteCharAt(lottoPrint.length() - 1);
        return lottoPrint.toString();
    }
    private String printWinning(int countNumber, int countWinner ,int winning) {
        StringBuilder winningPrint = new StringBuilder();
        String formatNumber = formatWithCommas(winning);
        if(countNumber == 7) {
            return winningPrint.append(countNumber-2).append("개 일치, 보너스 볼 일치 (").append(formatNumber).append("원) - ").append(countWinner).append("개").append('\n').toString();
        }
        return winningPrint.append(countNumber).append("개 일치 (").append(formatNumber).append("원) - ").append(countWinner).append("개").append('\n').toString();
    }
    private String formatWithCommas(int number) {
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        return decimalFormat.format(number);
    }
    public String formatToTwoDecimalPlaces(double number) {
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.0");
        return decimalFormat.format(number) + "%";
    }
}
