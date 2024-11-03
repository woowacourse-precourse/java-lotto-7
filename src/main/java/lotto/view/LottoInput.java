package lotto.view;

import lotto.common.view.ConsoleInput;
import lotto.model.WinningLotto;
import lotto.value.BonusNumber;
import lotto.value.LottoNumbers;
import lotto.value.Won;

public class LottoInput {

    public Won askForPurchasePrice() {
        System.out.println("구입금액을 입력해 주세요.");
        return Won.of(ConsoleInput.readInteger());
    }

    public WinningLotto askForWinningLotto() {
        System.out.println("당첨 번호를 입력해 주세요.");
        LottoNumbers winningNumbers = LottoNumbers.of(ConsoleInput.readIntegers());

        System.out.println("보너스 번호를 입력해 주세요.");
        BonusNumber bonusNumber = new BonusNumber(ConsoleInput.readInteger());

        return new WinningLotto(winningNumbers, bonusNumber);
    }

}
