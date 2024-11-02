package util;

import convert.InputConvertor;
import service.UserService;
import view.InputView;
import view.OutputView;

public class DependencyFactory {

    private final InputConvertor inputConvertor = new InputConvertor();
    private final InputView inputView = new InputView(inputConvertor);
    private final OutputView outputView = new OutputView();
    private final LottoGenerator lottoGenerator = new LottoGenerator();
    private final UserService userService = new UserService(lottoGenerator);

    public InputView getInputView() {
        return inputView;
    }

    public OutputView getOutputView() {
        return outputView;
    }

    public UserService getUserService() {
        return userService;
    }
}
