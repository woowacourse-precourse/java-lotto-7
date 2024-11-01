package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoAmount;
import lotto.domain.RandomLottoNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;


public class LottoController {

    private static final int LOTTO_PRICE = 1000;
    private static List<Lotto> myLottos;

    public void run(){
        try{
            start();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }


    // 메인 실행 부
    public void start(){
        int purchaseAmount = lottoAmount();
        OutputView.printLottoAmount(purchaseAmount);
        myLottos = generateMyLottoList(purchaseAmount);
        OutputView.printMyLottoNumber(myLottos);

    }
    // 로또 개수
    public int lottoAmount(){
        String purchasePrice = InputView.inputPurchasePrice();
        LottoAmount lottoAmount = new LottoAmount(purchasePrice);
        return lottoAmount.getAmount();
    }

    // 구매 금액만큼 내 로또 번호 생성
    public static List<Lotto> generateMyLottoList(int amount){
        myLottos = new ArrayList<>();
        RandomLottoNumbers lottoNumbers = new RandomLottoNumbers();
        for (int i = 0; i < amount; i++) {
            Lotto lotto = new Lotto(lottoNumbers.generateRandomLottoNumbers());
            myLottos.add(lotto);
        }
        return myLottos;
    }




}
