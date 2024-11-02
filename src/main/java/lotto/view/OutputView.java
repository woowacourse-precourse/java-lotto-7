package lotto.view;

import java.util.List;
import lotto.model.Lotto;

public class OutputView {

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
    }

    public void matchWinningNumber(int matchCount) {
        System.out.print(matchCount + "개 일치" + "(---원)");
    }
    public void matchWinningCount(int count) {
        System.out.println(" - " + count + "개");
    }

    public void promptTotalReturnRate(String totalReturnRate) {
        System.out.println("총 수익률은 " + "totalReturnRate" + "%입니다.");
    }

    public void showLottoNumber(List<Lotto> lottoNumbers) { }


}
