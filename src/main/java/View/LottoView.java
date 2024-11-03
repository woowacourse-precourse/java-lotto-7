package View;

import camp.nextstep.edu.missionutils.Console;
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
}
