package lotto.view.output;

import lotto.dto.FinalResultsDto;
import lotto.dto.LottosDto;

public interface OutputView {
    void outputPurchaseLottoList(LottosDto lottosDto);
    void outputFinalResult(FinalResultsDto finalResultsDto);
    void outputErrorMessage(String errorMessage);
}
