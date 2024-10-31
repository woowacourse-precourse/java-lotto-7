package lotto.week3.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.week3.domain.Lotto;
import lotto.week3.dto.PurchaseRequestDto;
import lotto.week3.dto.WinningNumberRequestDto;
import lotto.week3.model.LottoGenerator;
import lotto.week3.model.LottoMatching;
import lotto.week3.model.LottoStatistics;
import lotto.week3.view.InputView;
import lotto.week3.view.OutputView;

public class LottoController {

    public void run(){

        // 구입 금액 입력
        int purchaseAmount = InputView.purchaseAmountInput();
        PurchaseRequestDto purchaseRequestDto = new PurchaseRequestDto(purchaseAmount);


        // 로또 발행
        List<Lotto> lottoList = LottoGenerator.generatorLottos(purchaseRequestDto.getLottoCount());
        OutputView.lottoOutput(lottoList);

        // 뽀너스 입력, 당첨 번호 입력
        int numberInput = InputView.bonusNumberInput();
        List<Integer> winningNumber = InputView.winningNumberInput();
        WinningNumberRequestDto winningNumberRequestDto = new WinningNumberRequestDto(winningNumber, numberInput);


        /*
        로또 번호 매칭 - > 당첨번호랑 자동 발급된 번호 매칭 -> 확률 구현
         */
        LottoStatistics statistics = new LottoStatistics();
        LottoMatching lottoMatching = new LottoMatching(lottoList, statistics);
        lottoMatching.mathing(winningNumberRequestDto.getWinningNumbers(), winningNumberRequestDto.getBonusNumber());
        OutputView.lottoStatisticsOutput(statistics);



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
