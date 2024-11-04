package lotto.presentation;

import static lotto.common.ExceptionMessage.INVALID_NUMBER_FORMAT;

import java.util.List;
import lotto.domain.validator.LottoResultValidator;
import lotto.domain.validator.LottoValidator;
import lotto.domain.IssuedLotto;
import lotto.domain.LottoResult;
import lotto.dto.LottoStatisticsDto;
import lotto.presentation.view.InputView;
import lotto.presentation.view.OutputView;
import lotto.service.LottoService;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;

    public LottoController(InputView inputView, OutputView outputView, LottoService lottoService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
    }

    public void run() {
        IssuedLotto issuedLotto = generateLottoFromPurchaseAmount();
        outputView.printIssuedLottos(issuedLotto.getIssuedLottos());

        LottoResult lottoResult = generateLottoResult();

        LottoStatisticsDto lottoStatisticsDto = lottoService.calculateLottoStatistics(lottoResult, issuedLotto);
        outputView.printLottoRateOfProfit(lottoStatisticsDto);
    }

    private IssuedLotto generateLottoFromPurchaseAmount() {
        try {
            String purchaseAmount = inputView.getValidPurchaseAmount();
            return lottoService.createIssuedRandomLotto(parseToInt(purchaseAmount));
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return generateLottoFromPurchaseAmount();
        }
    }

    private LottoResult generateLottoResult() {
        try {
            List<Integer> winningNumbers = getValidatedWinningNumbers();
            int bonusNumber = getValidatedBonusNumber(winningNumbers);
            return lottoService.createLottoResult(winningNumbers, bonusNumber);
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return generateLottoResult();
        }
    }

    private List<Integer> getValidatedWinningNumbers() {
        List<String> inputWinningNumbers = inputView.getValidWinningNumbers();
        List<Integer> winningNumbers = inputWinningNumbers.stream()
                .map(winningNumber -> Integer.parseInt(winningNumber))
                .toList();
        LottoValidator.validate(winningNumbers);
        return winningNumbers;
    }

    private int getValidatedBonusNumber(List<Integer> winningNumbers) {
        String inputBonusNumber = inputView.getValidBonusNumber(winningNumbers);
        LottoResultValidator.bonusNumberValidate(parseToInt(inputBonusNumber), winningNumbers);
        return parseToInt(inputBonusNumber);
    }

    private int parseToInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NUMBER_FORMAT.getMessage());
        }
    }
}
