package lotto.view;

import lotto.model.Lotto;
import lotto.model.LottoBundle;

import java.util.List;

public class LottoOutputView {
    public void printCashNotification(){
        System.out.println("구입금액을 입력해 주세요.");
    }
    public void printErrorMessage(String reason){
        System.out.println("[ERROR]"+reason);
    }
    public void printLottoBundleAmount(int amount){
        System.out.println(amount+"개를 구매했습니다.");
    }
    public void printLottoInBundle(LottoBundle lottoBundle){
        for (Lotto lotto : lottoBundle.getLottoBundle()){
            System.out.println(lotto.getNumbers().toString());
        }
    }
}
