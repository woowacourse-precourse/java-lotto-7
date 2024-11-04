package lotto.view.lottoPurchaseView;

import java.util.ArrayList;
import java.util.List;

public class LottoPurchaseOutputView {

    public void showLottoPurchaseCount(int purchaseCount){
        System.out.println(purchaseCount + "개를 구매했습니다.");
    }

    public void showIssuedLottoNumbers(List<Integer> issuedLottoNumber){
        List<Integer> sortableLottoNumbers = new ArrayList<>(issuedLottoNumber);
        sortableLottoNumbers.sort(Integer::compareTo);
        System.out.println(sortableLottoNumbers);
    }

}
