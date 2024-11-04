package lotto.view.inputview;

import java.util.List;

public interface Input {
    int requestPurchaseAmount();
    List<Integer> requestLottoNumbers();
    int requestBonusNumber();
}
