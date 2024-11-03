package lotto.view.lottoPurchaseView;

import java.util.Collections;
import java.util.List;

public class LottoPurchaseOutputView {

    public void showLottoPurchaseCount(int purchaseCount){
        System.out.println(purchaseCount + "개를 구매했습니다.");
    }

    public void showIssuedLottoNumbers(List<Integer> issuedLottoNumber){
        issuedLottoNumber.sort(Integer::compareTo);
        System.out.println(issuedLottoNumber);
    }

}
