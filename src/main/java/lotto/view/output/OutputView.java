package lotto.view.output;

import lotto.dto.response.PurchasedLottosDTO;
import lotto.dto.response.WinningResultsDTO;

public interface OutputView {
    void printError(String message);

    void printSoldLottos(PurchasedLottosDTO soldLottosResponseDTO);

    void printWinningResults(WinningResultsDTO winningResultsDTO);
}
