package lotto.controller;

import lotto.model.Amount;
import lotto.model.LottoList;
import lotto.view.InputVIew;
import lotto.view.OutputView;

public class LottoController {
    private final InputVIew inputVIew;
    private final OutputView outputView;
    private Amount amount;
    private LottoList lottoList;

    public LottoController(InputVIew inputVIew, OutputView outputView) {
        this.inputVIew = inputVIew;
        this.outputView = outputView;
    }

    public void startLotto(){
        purchaseLotto();
    }

    // 구매 단계
    private void purchaseLotto(){
        // 개수
        String input = inputVIew.inputPurchaseAmount();
        amount = new Amount(input);
        outputView.printCount(amount);

        // 구매한 로또 번호 생성 및 출력
        lottoList = new LottoList(amount.getCount());
        outputView.printLottoList(lottoList);
    }

    // 당첨 추첨 단계

    // 결과 출력 단계
}
