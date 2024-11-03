package lotto.Controller;

import lotto.domain.*;
import lotto.view.ErrorMessage;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    private static PurchaseAmount purchaseAmount;
    private static BonusNumber bonusNumber;
    private static List<Integer> lotto = new ArrayList<>();
    private static List<Integer> lottoNumber =new ArrayList<>();
    private static List<Integer> lottoList=new ArrayList<>();
    private static int[] count=new int[8];
    public LottoController(){
    }

    public void run(){
        try {
            PrintInput();
            PrintOutput();
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
    public void PrintInput(){
        int step = 1;
        while (step <= 3) {
            try {
                if (step == 1) PrintAmount();
                if (step == 2) PrintNumber();
                if (step == 3) PrintBonus();
                step++;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    public void PrintAmount(){
        String amount_str =InputView.purchaseAmount();
        PlayerAmount(amount_str);
    }
    public void PrintNumber(){
        String number_str =InputView.sixLottoNumber();
        lottoNum(number_str);
    }
    public void PrintBonus(){
        String bonusnum_str=InputView.bonusLottoNumber();
        bonusNum(bonusnum_str);
    }
    public void PlayerAmount(String amount_str){
        purchaseAmount = new PurchaseAmount(amount_str);
        PrintDetails();
    }
    public static void LottoList(int ticketCount){
        for(int i=0;i<ticketCount;i++){
            lotto=RandomLotto.randomLottoNumber();
            lottoList.addAll(lotto);
            OutputView.printLottoList(lotto);
            lotto.clear();
        }
    }
    public void PrintDetails(){
        OutputView.printCount(purchaseAmount.calculateLottoCount());
        LottoList(purchaseAmount.calculateLottoCount());
    }
    public void lottoNum(String number_str){
        lottoNumber =LottoNumber.winLottoNumber(number_str);
        Lotto lotto =new Lotto(lottoNumber);
    }
    public void bonusNum(String bonusNum_str){
        bonusNumber=new BonusNumber(bonusNum_str);
        OverlapNumber(lottoNumber, bonusNumber.getBonusNum());
    }
    public void PrintOutput(){
        OutputView.printTotal();
        CompareLotto();
        ratePrint();
    }
    public void CompareLotto(){
        count=LottoTotal.winningLotto(lottoList,lottoNumber);
        int bonus_num=bonusNumber.getBonusNum();
        count=LottoTotal.bonusMatches(bonus_num,lottoList,count);
        OutputView.printCorrect(count);
    }
    public void ratePrint(){
        RateOfReturn rateOfReturn=new RateOfReturn();
        double rate=rateOfReturn.rate(count,purchaseAmount.getAmountNum());
        OutputView.printRate(rate);
    }
    public void OverlapNumber(List <Integer> lottoNumber,int bonusNum){
        for (Integer number : lottoNumber) {
            if (lottoNumber.contains(bonusNum)) {
                throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER_OVERLAP.getMessage());
            }
        }
    }
}
