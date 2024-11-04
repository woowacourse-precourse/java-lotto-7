package lotto.presentation;

import java.util.List;
import lotto.common.IntegerParser;
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
            return lottoService.createIssuedRandomLotto(IntegerParser.parseToInt(purchaseAmount));
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
        return lottoService.parseAndValidateWinningNumbers(inputWinningNumbers);
    }

    private int getValidatedBonusNumber(List<Integer> winningNumbers) {
        String inputBonusNumber = inputView.getValidBonusNumber(winningNumbers);
        return lottoService.parseAndValidateBonusNumber(inputBonusNumber, winningNumbers);
    }
}
