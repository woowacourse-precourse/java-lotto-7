package controller;

import static common.InputMessage.SYSTEM_PICK_BONUS_LOTTO;
import static common.InputMessage.SYSTEM_PICK_LOTTO;
import static common.InputMessage.USER_BUY_LOTTO;

import java.util.List;
import java.util.Map;
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

        Map<Integer, Integer> lottoMatchs = lottoService.findMatchLotto(pickLottoNumbers, pickBonusLottoNumber, lottos);
        double yield = lottoService.calculateYield(lottoMatchs, purchaseAmount);

        outputView.showWinResult(lottoMatchs, yield);
    }

    private String getValidatedBonusNumber(String pickLottoNumbers) {
        outputView.showPrompt(SYSTEM_PICK_BONUS_LOTTO);
        return getInput(input -> InputValidator.validateWinningBonusNumbers(input, pickLottoNumbers));
    }

    private String getValidatedWinningNumbers() {
        outputView.showPrompt(SYSTEM_PICK_LOTTO);
        return getInput(InputValidator::validateWinningNumbers);
    }

    private String getUserPayment() {
        outputView.showPrompt(USER_BUY_LOTTO);
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
