package lotto.controller;

import static lotto.view.ViewConstants.VIEW_DELIMITER;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import lotto.domain.LottoReceipt;
import lotto.domain.WinningLotto;
import lotto.domain.WinningReport;
import lotto.service.LottoService;

public class LottoController {
    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public LottoReceipt readPurchaseAmount(String input) {
        return lottoService.createLottoReceipt(toBigInteger(input));
    }

    public WinningLotto readWinningLottoNumbers(String input) {
        return lottoService.createWinningLotto(extractNumbers(input));
    }

    public WinningReport getReport(LottoReceipt lottoReceipt, WinningLotto winningLotto) {
        return lottoService.createWinningReport(lottoReceipt, winningLotto);
    }

    public BigInteger toBigInteger(String input) {
        return new BigInteger(input);
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
