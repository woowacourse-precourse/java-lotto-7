package lotto.controller;

import lotto.exception.LottoException;
import lotto.view.LottoInput;
import lotto.view.LottoOutput;

public abstract class Controller {
    protected final LottoInput inputView;
    protected final LottoOutput outputView;


    protected Controller(LottoInput inputView, LottoOutput outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    protected void handleError(Exception e) {
        String errorMessage;
        if (e instanceof LottoException) {
            errorMessage = "[ERROR] " + e.getMessage();
        } else {
            errorMessage = "[ERROR] 예기치 않은 오류가 발생했습니다: " + e.getMessage();
        }
        outputView.displayMessage(errorMessage);
    }
}
