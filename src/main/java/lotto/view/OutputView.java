package lotto.view;
import lotto.domain.Lotto;

import java.util.Collections;
import java.util.List;

public class OutputView {
    private final String PURCHASE_OUTPUT = "구입금액을 입력해 주세요.";
    private final String QUANTITY_OUTPUT="개를 구매했습니다.";
    public void purchasePrint(){
        System.out.println(PURCHASE_OUTPUT);
    }

    public void quantityPrint(int lottoQuantity){
        System.out.println("\n"+lottoQuantity+QUANTITY_OUTPUT);
    }

    public void lottosPrint(List<Lotto> lottos){
        for(Lotto lotto : lottos){
            Collections.sort(lotto.getLotto());
            System.out.println(lotto.getLotto());
        }
    }
}
