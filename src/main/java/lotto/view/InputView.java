package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.dto.BonusLottoNumBerInput;
import lotto.dto.LottoPurchasedAmountInput;
import lotto.dto.WinnerLottoNumbersInput;

public class InputView {

    public LottoPurchasedAmountInput readLottoPurchasedAmount() {
        String RawAmount = Console.readLine();
        return LottoPurchasedAmountInput.from(RawAmount.trim());
    }

    public WinnerLottoNumbersInput readWinnerLottoNumbers() {
        String rawNumbers = Console.readLine();
        return WinnerLottoNumbersInput.from(rawNumbers.trim());
    }

    public BonusLottoNumBerInput readBonusLottoNumber() {
        String rawBonusNumber = Console.readLine();
        return BonusLottoNumBerInput.from(rawBonusNumber.trim());
    }
}
