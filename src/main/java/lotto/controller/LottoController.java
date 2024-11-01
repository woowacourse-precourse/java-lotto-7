package lotto.controller;


import lotto.view.InputView;

public class LottoController {
    private final InputView inputView;

    public LottoController(InputView inputView) {
        this.inputView = inputView;
    }

    public void handle() {
        int price = inputView.getInput();

        // 로또 발행하기

        // 당첨번호 및 보너스번호 입력받기

        // 당첨 통계 및 수익률 출력
    }
}
