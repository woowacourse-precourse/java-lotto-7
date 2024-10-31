package lotto.week3.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.week3.domain.Lotto;
import lotto.week3.dto.PurchaseRequestDto;
import lotto.week3.dto.WinningNumberRequestDto;
import lotto.week3.view.InputView;
import lotto.week3.view.OutputView;

public class LottoController {

    public void run(){

        // 구입 금액 입력
        int purchaseAmount = InputView.purchaseAmountInput();
        PurchaseRequestDto purchaseRequestDto = new PurchaseRequestDto(purchaseAmount);


        // 로또 발행
        List<Lotto> answer = new ArrayList<>();
        for(int i = 0; i < lottoCount; i++){
            answer.add(new Lotto());
        }
        OutputView.lottoOutput(answer);



        /*
        로또 구입 하기 ->  금액에 따른 자동 로또 번호 출력
         */
//        InputView inputView = new InputView();
//        OutputView outputView = new OutputView();
//        AutomaticLotto automaticLotto = new AutomaticLotto();
//        List<List<Integer>> lottoNumberPrinting = automaticLotto.lottoNumberPrinting(purchaseAmount);


        // 뽀너스 입력, 당첨 번호 입력
        int numberInput = InputView.bonusNumberInput();
        List<Integer> winningNumber = InputView.winningNumberInput();
        WinningNumberRequestDto winningNumberRequestDto = new WinningNumberRequestDto(winningNumber, numberInput);


        /*
        로또 번호 매칭 - > 당첨번호랑 자동 발급된 번호 매칭
         */

        for(Lotto lotto: answer){
            int matchCount = lotto.matchCount(winningNumber);

        }




    }

    private int calculatePrize(int matchCount, boolean bonusMatch){
        if (matchCount == 6) return 2000000000; // 1등
        if (matchCount == 5 && bonusMatch) return 30000000; // 2등
        if (matchCount == 5) return 1500000; // 3등
        if (matchCount == 4) return 50000; // 4등
        if (matchCount == 3) return 5000; // 5등
        return 0;
    }
}
