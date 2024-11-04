package lotto.view;
import lotto.domain.Lotto;

import java.util.Collections;
import java.util.List;

public class OutputView {
    private final String PURCHASE_OUTPUT = "구입금액을 입력해 주세요.";
    private final String QUANTITY_OUTPUT="개를 구매했습니다.";
    private final String WINNINGNUMBER_OUTPUT="당첨 번호를 입력해 주세요.";
    private final String BONUSNUMBER_OUTPUT="보너스 번호를 입력해 주세요.";

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

    public void winningNumberPrint(){
        System.out.println("\n"+WINNINGNUMBER_OUTPUT);
    }

    public void bonusNumberPrint(){
        System.out.println("\n"+BONUSNUMBER_OUTPUT);
    }
}
