package lotto;

import lotto.io.InputHandler;
import lotto.io.InputUtils;
import lotto.io.OutputHandler;
import lotto.lotto.LottoShop;
import lotto.lotto.object.utils.LottoNumberPicker;
import lotto.validation.InputValidation;
import lotto.validation.LottoNumberValidation;

public class Application {
    public static void main(String[] args) {
        InputValidation inputValidation = new InputValidation();
        LottoNumberValidation lottoNumberValidation = new LottoNumberValidation();

        OutputHandler outputHandler = new OutputHandler();
        InputUtils inputUtils = new InputUtils();
        InputHandler inputHandler = new InputHandler(inputValidation, lottoNumberValidation, inputUtils);

        LottoNumberPicker picker = new LottoNumberPicker();
        LottoShop lottoShop = new LottoShop(picker, inputValidation);

        // 실행
        new LottoController(inputHandler, outputHandler, lottoShop, lottoNumberValidation).run();
    }
}
