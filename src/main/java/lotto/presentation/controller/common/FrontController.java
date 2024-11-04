package lotto.presentation.controller.common;

import lotto.presentation.model.Model;
import lotto.presentation.view.ExceptionView;

public class FrontController {

    private static class FrontControllerHolder {

        private static final FrontController INSTANCE = new FrontController();
    }

    public static FrontController getInstance() {
        return FrontControllerHolder.INSTANCE;
    }

    private FrontController() {
    }

    public void process(LottoController controller, Model model) {
        processWithExceptionHandling(controller, model);
    }

    private void processWithExceptionHandling(LottoController lottoController, Model model) {
        try {
            lottoController.process(model);
        } catch (RuntimeException exception) {
            handleException(lottoController, model, exception);
        }
    }

    private void handleException(LottoController lottoController, Model model, RuntimeException exception) {
        ExceptionView.render(exception);
        processWithExceptionHandling(lottoController, model);
    }
}
