package controller;

import common.InputMessage;
import java.util.List;
import java.util.function.Consumer;
import model.Lotto;
import services.LottoService;
import validator.InputValidator;
import view.InputView;
import view.OutputView;

public class LottoController {
    private final LottoService lottoService;
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(LottoService lottoService) {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.lottoService = lottoService;
    }

    public void run() {
        String purchaseAmount = getUserPayment();
        List<Lotto> lottos = lottoService.generateLotto(purchaseAmount);

        outputView.printLottoNumbers(lottos);

        String pickLottoNumbers = getValidatedWinningNumbers();
        String pickBonusLottoNumber = getValidatedBonusNumber(pickLottoNumbers);
    }

    private String getValidatedBonusNumber(String pickLottoNumbers) {
        outputView.showPrompt(InputMessage.SYSTEM_PICK_BONUS_LOTTO.getMessage());
        return getInput(input -> InputValidator.validateWinningBonusNumbers(input, pickLottoNumbers));
    }

    private String getValidatedWinningNumbers() {
        outputView.showPrompt(InputMessage.SYSTEM_PICK_LOTTO.getMessage());
        return getInput(InputValidator::validateWinningNumbers);
    }

    private String getUserPayment() {
        outputView.showPrompt(InputMessage.USER_BUY_LOTTO.getMessage());
        return getInput(InputValidator::validataPurchaseAmount);
    }

    private String getInput(Consumer<String> validator) {
        while(true) {
            try {
                String input = inputView.getInput();
                validator.accept(input);

                return input;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
