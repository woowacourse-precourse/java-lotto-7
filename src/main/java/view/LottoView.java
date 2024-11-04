package view;

import static util.LottoFormatter.formatLotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.Lotto;
import lotto.LottoResult;
import lotto.PurchaseCount;

public class LottoView {
    private final static int LOTTO_PRICE = 1_000;

    public String inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String purchaseAmount = Console.readLine();
        return purchaseAmount;
    }

    public String printPurchasedLottoCountFromView(PurchaseCount purchaseCount) {
        int count = purchaseCount.getPurchaseCount();
        String result = count + "개를 구매했습니다.";
        System.out.println(result);
        System.out.println();
        return result;
    }

    public void printPurchasedLottoNumbersFromView(List<Lotto> lottoList) {
        for (Lotto lotto : lottoList) {
            System.out.println(formatLotto(lotto.getNumbers()));
        }
        System.out.println();
    }

    public String inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public String inputBonusNumber() {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public void printMatchingResult(LottoResult lottoResult, int lottoCount) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + lottoResult.getThreeMatchesCount() + "개");
        System.out.println("4개 일치 (50,000원) - " + lottoResult.getFourMatchesCount() + "개");
        System.out.println("5개 일치 (1,500,000원) - " + lottoResult.getFiveMatchesCount() + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + lottoResult.getFiveMatchesWithBonusCount() + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + lottoResult.getSixMatchesCount() + "개");
        System.out.println("총 수익률은 " + lottoResult.getYield(lottoCount * LOTTO_PRICE) + "%입니다.");
    }
}
