package lotto.controller;

import lotto.model.*;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private Amount amount;
    private LottoList lottoList;

    public LottoController(InputView inputVIew, OutputView outputView) {
        this.inputView = inputVIew;
        this.outputView = outputView;
    }

    public void startLotto(){
        purchaseLotto();
        makeResult();
    }

    // 구매 단계
    private void purchaseLotto(){
        // 개수
        String input = inputView.inputPurchaseAmount();
        amount = new Amount(input);
        outputView.printCount(amount);

        // 구매한 로또 번호 생성 및 출력
        lottoList = new LottoList(amount.getCount());
        outputView.printLottoList(lottoList);
    }

    // 당첨 추첨 단계
    private void makeResult(){
        // 당첨 번호 입력
        String numbers = inputView.inputLottoNumbers();
        String bonus = inputView.inputBonusNumbers();
        WinningNumbers winningNumbers = new WinningNumbers(numbers, bonus);

        // 당첨 결과 생성
        ResultCalculator resultCalculator = new ResultCalculator(lottoList, winningNumbers);
        resultCalculator.calculateResults();

        // 결과 출력
        outputView.printLottoResults(resultCalculator);
        double profitRate = resultCalculator.calculateProfitRate(amount.getAmount());
        outputView.printProfitRate(profitRate);
    }
}
