package lotto.view.output;

import lotto.dto.FinalResultDto;
import lotto.dto.LottosDto;

public interface OutputView {
    void outputPurchaseLottoList(LottosDto lottosDto);
    void outputFinalResult(FinalResultDto finalResultDto);
    void outputErrorMessage(String errorMessage);
}
