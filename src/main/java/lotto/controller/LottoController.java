package lotto.controller;

import static lotto.view.ViewConstants.VIEW_DELIMITER;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import lotto.domain.LottoBuyer;
import lotto.domain.WinningLotto;
import lotto.service.LottoRetailer;
import lotto.view.InputValidator;

public class LottoController {
    private final LottoRetailer lottoRetailer;

    public LottoController(LottoRetailer lottoRetailer) {
        this.lottoRetailer = lottoRetailer;
    }

    public LottoBuyer buyLottosWith(BigInteger purchaseAmount) {
        return lottoRetailer.sellAsMuchAs(purchaseAmount);
    }

    public WinningLotto extractLottoNumbers(String input, InputValidator inputValidator) {
        inputValidator.validateDigitAndDelimiterOnly(input);
        List<Integer> numbers = extractNumbers(input);
        return lottoRetailer.createWinningLotto(numbers);
    }

    private List<Integer> extractNumbers(String input) {
        return Arrays.stream(input.split(VIEW_DELIMITER))
                .map(this::convertToInteger)
                .toList();
    }

    private int convertToInteger(String input) {
        return Integer.parseInt(input);
    }
}
