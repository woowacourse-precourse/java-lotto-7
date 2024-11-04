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
        IssuedLotto issuedLotto = purchaseAmountProcess();
        outputView.printIssuedLottos(issuedLotto.getIssuedLottos());

        LottoResult lottoResult = lottoResultProcess();

        LottoStatisticsDto lottoStatisticsDto = lottoService.calculateLottoStatistics(lottoResult, issuedLotto);
        outputView.printLottoRateOfProfit(lottoStatisticsDto);
    }

    private IssuedLotto purchaseAmountProcess() {
        try {
            String purchaseAmount = inputView.getValidPurchaseAmount();
            return lottoService.createIssuedRandomLotto(parseToInt(purchaseAmount));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return purchaseAmountProcess();
        }
    }

    private LottoResult lottoResultProcess() {
        try {
            List<Integer> winningNumbers = winningNumbersProcess();
            int bonusNumber = bonusNumberProcess(winningNumbers);
            return lottoService.createLottoResult(winningNumbers, bonusNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return lottoResultProcess();
        }
    }

    private List<Integer> winningNumbersProcess() {
        List<String> inputWinningNumbers = inputView.getValidWinningNumbers();
        List<Integer> winningNumbers = inputWinningNumbers.stream()
                .map(winningNumber -> Integer.parseInt(winningNumber))
                .toList();
        LottoValidator.validate(winningNumbers);
        return winningNumbers;
    }

    private int bonusNumberProcess(List<Integer> winningNumbers) {
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
