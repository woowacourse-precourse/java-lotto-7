package lotto.io;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.Lotto;
import lotto.model.LottoRank;
import lotto.model.LottoResult;

import java.util.List;

public class ConsoleLottoOutputHandler implements LottoOutputHandler {

    @Override
    public void showPurchaseAmountPrompt() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    @Override
    public void showPurchasedLottoCount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    @Override
    public void showPurchasedLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
        System.out.println();
    }

    @Override
    public void showWinningNumbersPrompt() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    @Override
    public void showBonusNumberPrompt() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    @Override
    public void showResults(LottoResult result) {
        System.out.println("당첨 통계\n---");

        for (LottoRank rank : LottoRank.values()) {
            int count = result.getCountForRank(rank);
            if (rank != LottoRank.NONE) {
                System.out.println(rank.getDescription() + ": " + count + "개");
            }
        }
    }

    @Override
    public void showProfitRate(double rate) {
        System.out.println("총 수익률은 " + String.format("%.1f", rate) + "%입니다.");
        Console.close();
    }

    @Override
    public void showErrorMessage(String errorMessage) {
        System.out.println("[ERROR] " + errorMessage);
        System.out.println();
    }
}
