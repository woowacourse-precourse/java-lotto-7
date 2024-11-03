package lotto.view;

import lotto.common.view.ConsoleInput;
import lotto.common.view.InteractionRepeatable;
import lotto.model.WinningLotto;
import lotto.value.BonusNumber;
import lotto.value.LottoNumbers;
import lotto.value.Won;

public class LottoInput implements InteractionRepeatable {

    public Won askForPurchasePrice() {
        return supplyWithTry(() -> {
            System.out.println("구입금액을 입력해 주세요.");
            return Won.of(ConsoleInput.readInteger());
        });
    }

    public WinningLotto askForWinningLotto() {
        LottoNumbers winningNumbers = supplyWithTry(() -> {
            System.out.println("당첨 번호를 입력해 주세요.");
            return LottoNumbers.of(ConsoleInput.readIntegers());
        });

        return supplyWithTry(() -> {
            System.out.println("보너스 번호를 입력해 주세요.");
            BonusNumber bonusNumber = new BonusNumber(ConsoleInput.readInteger());
            return new WinningLotto(winningNumbers, bonusNumber);
        });
    }

}
