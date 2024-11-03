package lotto.controller;

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
        if (e instanceof IllegalArgumentException) {
            errorMessage = e.getMessage();
            outputView.displayMessage(errorMessage);
        }
    }
}
