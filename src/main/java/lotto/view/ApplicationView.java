package lotto.view;

import java.util.List;
import lotto.domain.WinResult;
import lotto.view.dto.WinningInfo;

public interface ApplicationView {

    int requestMoney();

    void printPurchasedLotto(List<String> lottos);

    String requestWinNumber();

    int requestBonusNumber();

    void printWinningResult(WinningInfo winningInfo);
}
