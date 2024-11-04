package controller;

import Service.LottoService;
import model.Lotto;
import model.Rank;
import view.InputView;
import view.OutputView;

import java.util.List;
import java.util.Map;

public class LottoController {
    private final static InputView inputView = new InputView();
    private final static OutputView outputView = new OutputView();
    private final static LottoService lottoService = new LottoService();


    public void run(){
        // 로또 구입 금액을 입력 받아서 로또 발행 횟수를 반환
        int purchaseAmount = inputView.inputPurchaseAmount();
        int count = lottoService.lottoCount(purchaseAmount);

        // 구입한 금액만큼 로또 발행하기
        List<Lotto> lottoList = lottoService.publishLotto(count);
        outputView.publishLotto(count, lottoList);

        // 당첨 번호 입력 받기
        String winningNumber = inputView.inputWinningNumber();
        Lotto lotto = lottoService.inputWinningNumber(winningNumber);

        // 보너스 번호 입력 받기
        int bonusNumber = lottoService.bonusNumber(inputView.inputBonusNumber(), lotto);

        // 당첨 내역 출력하기
        Map<Rank, Integer> rankCount = lottoService.calculateStatistics(lottoList, lotto, bonusNumber);
        outputView.printStatistics(rankCount);

        // 총 수익률 출력하기
        double rate = lottoService.totalReturn(rankCount, purchaseAmount);
        outputView.printTotalReturn(rate);
    }
}