package lotto.view;

import java.util.List;

public interface InputView {
    String startLottoGameAndReadBuyingPrice();

    List<Integer> readWinningNumbers();

    String readBonusNumber();
}
