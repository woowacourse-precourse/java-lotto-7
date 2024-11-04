package lotto.temp;

import lotto.util.CommonIo;
import lotto.view.InputView;
import lotto.view.OutputView;

public class IoComponent {
    private final IoController ioController;
    private final InputView inputView;
    private final OutputView outputView;
    private final CommonIo commonIo;

    public IoComponent(CommonIo commonIo) {
        this.commonIo = commonIo;
        this.ioController = new IoController(commonIo);
        this.inputView = new InputView(commonIo);
        this.outputView = new OutputView(commonIo);
    }

    public IoController getIoController() {
        return ioController;
    }

    public InputView getInputView() {
        return inputView;
    }

    public OutputView getOutputView() {
        return outputView;
    }

    public CommonIo getCommonIo() {
        return commonIo;
    }
}
