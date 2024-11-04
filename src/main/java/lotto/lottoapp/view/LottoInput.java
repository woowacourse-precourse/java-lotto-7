package lotto.lottoapp.view;

import lotto.common.view.ConsoleInput;
import lotto.lottoapp.model.value.BonusNumber;
import lotto.lottoapp.model.value.LottoNumber;
import lotto.lottoapp.model.value.LottoNumbers;
import lotto.lottoapp.model.value.WinningLottoNumbers;
import lotto.lottoapp.model.value.Won;

public class LottoInput {

    public Won askForPurchasePrice() {
        System.out.println("구입금액을 입력해 주세요.");
        return Won.of(ConsoleInput.readInteger(Won.MIN_VALUE, Won.MAX_VALUE));
    }

    public WinningLottoNumbers askForWinningLotto() {
        System.out.println("당첨 번호를 입력해 주세요.");
        LottoNumbers winningNumbers = LottoNumbers.of(ConsoleInput.readIntegers(
                LottoNumber.MIN_VALUE, LottoNumber.MAX_VALUE));

        System.out.println("보너스 번호를 입력해 주세요.");
        BonusNumber bonusNumber = new BonusNumber(ConsoleInput.readInteger(
                LottoNumber.MIN_VALUE, LottoNumber.MAX_VALUE));

        return new WinningLottoNumbers(winningNumbers, bonusNumber);
    }

}
