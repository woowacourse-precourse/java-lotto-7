package lotto.io;

import java.util.List;

public interface InputHandler {

    int inputPurchaseAmount();

    List<Integer> inputLottoNumbers();

    int inputBonusNumber();
}
