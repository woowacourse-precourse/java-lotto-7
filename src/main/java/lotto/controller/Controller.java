package lotto.controller;

import lotto.utils.Utils;
import lotto.validator.Validators;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;
    private final Validators validators;
    private final Utils utils;


    public Controller(InputView inputView, OutputView outputView, Validators validators, Utils utils) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.validators = validators;
        this.utils = utils;
    }
}
