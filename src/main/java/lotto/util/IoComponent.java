package lotto.util;

import lotto.util.common.CommonIo;
import lotto.view.InputView;
import lotto.view.OutputView;

public record IoComponent(
        IoController ioController,
        InputView inputView,
        OutputView outputView,
        CommonIo commonIo
) {
    public static IoComponent of(CommonIo commonIo) {
        return new IoComponent(
                new IoController(commonIo),
                new InputView(commonIo),
                new OutputView(commonIo),
                commonIo
        );
    }
}