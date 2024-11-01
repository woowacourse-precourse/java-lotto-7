package lotto.Controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    private static PurchaseAmount purchaseAmount;
    public LottoController(){
    }

    public void run(){
        PrintInput();
    }
    public void PrintInput(){
        String amount_str =InputView.purchaseAmount();
        PlayerAmount(amount_str);
        String number_str =InputView.sixLottoNumber();
        lottoNum(number_str);
        String bonusnum_str=InputView.bonusLottoNumber();
        bonusNum(bonusnum_str);
    }
    public void PlayerAmount(String amount_str){
        purchaseAmount = new PurchaseAmount(amount_str);
        PrintDetails();
    }
    public static void LottoList(int ticketCount){
        for(int i=0;i<ticketCount;i++){
            OutputView.printLottoList(RandomLotto.randomLottoNumber());
        }
    }
    public void PrintDetails(){
        OutputView.printCount(purchaseAmount.calculateLottoCount());
        LottoList(purchaseAmount.calculateLottoCount());
    }
    public void lottoNum(String number_str){
        List<Integer> lottoNumber =new ArrayList<>(LottoNumber.winLottoNumber(number_str));
        Lotto lotto =new Lotto(lottoNumber);
    }
    public void bonusNum(String bonusNum_str){
        BonusNumber bonusNumber=new BonusNumber(bonusNum_str);
    }
}
