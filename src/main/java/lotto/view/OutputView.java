package lotto.view;

import java.util.List;
import lotto.constant.LottoRank;
import lotto.model.Lotto;

public class OutputView {

    public void printMoneyInputMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printPurchasedLotto(List<Lotto> purchasedLotto) {
        System.out.println("\n" + purchasedLotto.size() + "개를 구매했습니다.");
        for (Lotto lotto : purchasedLotto) {
            System.out.println(lotto);
        }
    }

    public void printWinnerNumbersInputMessage() {
        System.out.println("\n당첨 번호를 입력해주세요.");
    }

    public void printBonusNumberInputMessage() {
        System.out.println("\n보너스 번호를 입력해주세요.");
    }

    public void printLottoResult(int usedMoney) {
        printLottoResultHeader();
        printLottoWinningStatus();
        printRateOfReturn(usedMoney);
    }

    private void printLottoResultHeader() {
        System.out.println("\n당첨 통계");
        System.out.println("---");
    }

    private void printLottoWinningStatus() {
        System.out.println("3개 일치 (5,000원) - " + LottoRank.FIFTH.getNumberOfWins() + "개");
        System.out.println("4개 일치 (50,000원) - " + LottoRank.FORTH.getNumberOfWins() + "개");
        System.out.println("5개 일치 (1,500,000원) - " + LottoRank.THIRD.getNumberOfWins() + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + LottoRank.SECOND.getNumberOfWins() + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + LottoRank.FIRST.getNumberOfWins() + "개");
    }

    private void printRateOfReturn(int usedMoney) {
        int totalPrize = LottoRank.FIRST.getTotalPrize()
                + LottoRank.SECOND.getTotalPrize()
                + LottoRank.THIRD.getTotalPrize()
                + LottoRank.FORTH.getTotalPrize()
                + LottoRank.FIFTH.getTotalPrize();

        System.out.println(String.format("총 수익률은 %.1f%%입니다.", totalPrize * 100.0 / usedMoney));
    }
}
