package lotto.view;

import java.text.NumberFormat;
import java.util.List;
import lotto.model.WinningMatch;

public class OutputView {
    public static final NumberFormat THOUSAND_SEPARATOR = NumberFormat.getInstance();

    // 메서드 명 길이에 대해 고민해보기
    // 메서드 명
    public void purchaseLottoAmountMesssage() {
        System.out.println("구입금액을 입력해 주세요.");
    }
    public void purchaseLottoCountMessage(int ticketCount) {
        System.out.println(ticketCount + "개를 구매했습니다.");
    }

    public void printLottoNumbers(List<String> lottoNumbers) {
        for (String lotterNumber: lottoNumbers) {
            System.out.println(lotterNumber);
        }
    }

    public void enterWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void enterBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public void WinningStatistics() {
        System.out.println("당첨 통계");
        System.out.print("---");
        System.out.println();
    }

    public void matchWinningCount(List<Integer> winningCounts) {
        for (int rank = winningCounts.size(); rank > 0; rank--) {
            int winningCount = winningCounts.get(rank-1);
            System.out.println(WinningMatch.valueOfRank(rank).getMatchAmount() + "(" + THOUSAND_SEPARATOR.format(WinningMatch.valueOfRank(rank).getPriceAmount()) + "원) - " + winningCount + "개");
        }
    }

    public void promptTotalReturnRate(String totalReturnRate) {
        System.out.println("총 수익률은 " + totalReturnRate + "%입니다.");
    }

    public void printErrorMessage(String message) {
        System.out.println(message);
    }
}
