package view;

import static util.LottoFormatter.formatLotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.Lotto;
import lotto.PurchaseCount;

public class LottoView {
    public String inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String purchaseAmount = Console.readLine();
        return purchaseAmount;
    }

    public String printPurchasedLottoCountFromView(PurchaseCount purchaseCount) {
        int count = purchaseCount.getPurchaseCount();
        String result = count + "개를 구매했습니다.";
        System.out.println(result);
        return result;
    }

    public void printPurchasedLottoNumbersFromView(List<Lotto> lottoList) {
        for (Lotto lotto : lottoList) {
            System.out.println(formatLotto(lotto.getNumbers()));
        }
    }

    public String inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public String inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Console.readLine();
    }
}
