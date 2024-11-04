package lotto;

import java.util.ArrayList;
import java.util.List;

public class Output {

    public void publishResult(int amount){
        List<Lotto> lottoList = Lotto.publishLotto(amount);
        int N = Money.getAmount(amount);
        System.out.println(N+OutputMessage.PURCHASE_MESSAGE.getMessage());

        for(Lotto lotto : lottoList){
            System.out.println(lotto.toString());
        }
    }

    public void winningResult(){

    }

}
