package lotto.service;

import lotto.domain.LottoTicket;

import java.util.List;

public interface LottoService {
    LottoTicket generateLottoTicket(String purchaseAmountInput);
    List<Integer> parseWinningNumbers(String winningNumbersInput);
}
