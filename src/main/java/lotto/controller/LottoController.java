package lotto.controller;

import java.util.List;
import lotto.common.util.InputUtils;
import lotto.controller.response.LottoIssuingResponse;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.LottoNumber;
import lotto.model.PurchaseAmount;
import lotto.model.WinningNumbers;
import lotto.service.LottoIssuingService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public static final String WINNING_NUMBERS_DELIMITER = ",";
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoIssuingService lottoIssuingService;

    public LottoController(InputView inputView, OutputView outputView, LottoIssuingService lottoIssuingService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoIssuingService = lottoIssuingService;
    }

    public void run() {
        String purchaseAmount = inputView.getPurchaseAmount();

        List<Lotto> lottoTickets = lottoIssuingService.issueForAmount(
                PurchaseAmount.from(InputUtils.parseStringToInt(purchaseAmount))
        );

        LottoIssuingResponse response = LottoIssuingResponse.from(lottoTickets);
        outputView.printLottoTickets(response);

        String numbers = inputView.getWinningNumbers();

        WinningNumbers winningNumbers = WinningNumbers.from(
                InputUtils.splitWithDelimiter(numbers, WINNING_NUMBERS_DELIMITER)
                        .stream()
                        .map(number -> LottoNumber.from(InputUtils.parseStringToInt(number)))
                        .toList()
        );

        String number = inputView.getBonusNumber();

        BonusNumber bonusNumber = BonusNumber.from(LottoNumber.from(InputUtils.parseStringToInt(number)));
    }
}
