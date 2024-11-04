package lotto.view;

import lotto.model.Amount;
import lotto.model.Lotto;
import lotto.model.LottoList;

public class OutputView {
    public void printCount(Amount amount){
        System.out.println(amount.getCount() + "개를 구입하셨습니다.");
    }

    public void printLottoList(LottoList lottoList){
        for (Lotto lotto : lottoList.getLottoList()) {
            System.out.println(lotto.getNumbers());
        }
    }
}
