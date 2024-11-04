package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.BonusNumberException;
import lotto.exception.PriceToBuyLottoException;
import lotto.exception.WinningLottoNumberException;
import lotto.model.BonusNumber;
import lotto.model.PriceToBuyLotto;
import lotto.model.WinningLottoNumber;

public class InputView {

    private InputView() {
    }

    public static PriceToBuyLotto getPriceToBuyLotto() {
        PriceToBuyLotto priceToBuyLotto;
        try {
            String userInputPriceToBuyLotto = Console.readLine();
            priceToBuyLotto = PriceToBuyLotto.of(userInputPriceToBuyLotto);
        } catch (PriceToBuyLottoException e) {
            e.printErrorMessage();
            priceToBuyLotto = getPriceToBuyLotto();
        }
        return priceToBuyLotto;
    }

    public static WinningLottoNumber getWinningLottoNumber() {
        WinningLottoNumber winningLottoNumber;
        try {
            String userInputWinningLottoNumber = Console.readLine();
            winningLottoNumber = WinningLottoNumber.of(userInputWinningLottoNumber);
        } catch (WinningLottoNumberException e) {
            e.printErrorMessage();
            winningLottoNumber = getWinningLottoNumber();
        }
        return winningLottoNumber;
    }

    public static BonusNumber getBonusNumber(WinningLottoNumber winningLottoNumber) {
        BonusNumber bonusNumber;
        try {
            String userInputBonusNumber = Console.readLine();
            bonusNumber = BonusNumber.of(userInputBonusNumber, winningLottoNumber);
        } catch (BonusNumberException e) {
            e.printErrorMessage();
            bonusNumber = getBonusNumber(winningLottoNumber);
        } finally {
            Console.close();
        }
        return bonusNumber;
    }
}
