package lotto.view;

import lotto.dto.IssuedLottosDto;

public interface View {
    void displayException(String message);

    String promptPurchaseAmount();

    String promptWinningNumbers();

    String promptBonusNumber();

    void displayIssuedLottos(IssuedLottosDto issuedLottosDto);
}
