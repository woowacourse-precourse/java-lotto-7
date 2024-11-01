package lotto.service;

import java.util.List;

public interface LottoService {
    int calculateLottoCount(String purchaseAmountInput);
    List<Integer> parseWinningNumbers(String winningNumbersInput);
}
