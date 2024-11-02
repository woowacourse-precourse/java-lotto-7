package lotto.controller;

import static lotto.view.constant.Message.BONUS_START;
import static lotto.view.constant.Message.START;
import static lotto.view.constant.Message.STATISTICS;
import static lotto.view.constant.Message.WINNING_START;

import lotto.view.OutputView;

public class Controller {
    private final OutputView outputView = new OutputView();

    public void start() {
        outputView.printResult(START.getMessage());
        outputView.printResult(WINNING_START.getMessage());
        outputView.printResult(BONUS_START.getMessage());
        outputView.printResult(STATISTICS.getMessage());
    }
}
