package lotto.presentation.controller.common;

import lotto.presentation.model.Model;

public abstract class LottoController {

    public final void process(Model model) throws IllegalArgumentException {
        request(model);
        handle(model);
        response(model);
    }

    protected abstract void request(Model model);

    protected abstract void handle(Model model);

    protected abstract void response(Model model);
}
