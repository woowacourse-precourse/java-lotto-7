package lotto.view;

import java.util.Collections;
import java.util.List;

public class OutputView {

    public static void outputPurchasedLottoCount(int purchasedLottoCount) {
        System.out.println(purchasedLottoCount + "개를 구매했습니다.");
    }

    public static void outputPurchaseOneLottoResult(List<Integer> purchasedLottoNumbers) {
        Collections.sort(purchasedLottoNumbers);
        System.out.println(purchasedLottoNumbers);
    }
}
