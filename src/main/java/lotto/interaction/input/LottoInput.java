package lotto.interaction.input;

import java.util.List;
import lotto.exception.LottoException;

public interface LottoInput {
    int inputPurchaseMoney() throws LottoException;
    List<Integer> inputWinningNumbers() throws LottoException;
    int inputBonusNumber(List<Integer> winningNumbers) throws LottoException;
}
