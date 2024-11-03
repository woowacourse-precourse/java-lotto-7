package lotto.controller;

public class LottoController {

    private final InputController inputController;

    public LottoController(final InputController inputController) {
        this.inputController = inputController;
    }

    public void run() {
        int money = inputController.getMoney();

    }
}
