package lotto.view;

import lotto.dto.IssuedLottosDto;
import lotto.dto.ResultDto;

public interface View {
    void displayException(String message);

    String promptPurchaseAmount();

    String promptWinningNumbers();

    String promptBonusNumber();

    void displayIssuedLottos(IssuedLottosDto issuedLottosDto);

    void displayResult(ResultDto result);
}
