package lotto.view;

import java.math.BigInteger;
import java.util.List;

public interface Input {
    BigInteger inputPurchaseAmount();
    List<Integer> inputWinningNumbers();
    Integer inputBonusNumber();
}
