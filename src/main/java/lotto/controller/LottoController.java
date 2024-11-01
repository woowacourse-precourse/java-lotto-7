package lotto.controller;

import lotto.model.Input;
import lotto.view.InputView;

public class LottoController {
    private final InputController inputController;

    public LottoController() {
        InputView inputView = new InputView();
        this.inputController = new InputController(inputView); // inputController 초기화
    }

    public void run() {
        Input input = inputController.getInput();
        // 추가 로직 수행
    }
}
