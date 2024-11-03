package lotto.controller;

import static lotto.view.ViewConstants.VIEW_DELIMITER;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import lotto.domain.LottoReceipt;
import lotto.domain.WinningLotto;
import lotto.domain.WinningReport;
import lotto.service.LottoService;
import lotto.view.InputValidator;
import lotto.view.InputView;

public class LottoController {
    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void run(InputView inputView, InputValidator inputValidator) {
        LottoReceipt lottoReceipt = lottoService.createLottoReceipt(toBigInteger(inputView.requestPurchaseAmount()));
        WinningLotto winningLotto = lottoService.createWinningLotto(
                extractNumbers(inputView.requestWinningLottoNumbers(), inputValidator));
        WinningReport winningReport = lottoService.createWinningReport(lottoReceipt, winningLotto);
    }

    public BigInteger toBigInteger(String input) {
        return new BigInteger(input);
    }

    public List<Integer> extractNumbers(String input, InputValidator inputValidator) {
        inputValidator.validateDigitAndDelimiterOnly(input);
        return extractNumbers(input);
    }

    private List<Integer> extractNumbers(String input) {
        return Arrays.stream(input.split(VIEW_DELIMITER))
                .map(this::toInteger)
                .toList();
    }

    private int toInteger(String input) {
        return Integer.parseInt(input);
    }
}
