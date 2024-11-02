package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.PurchasePrice;
import lotto.domain.WinningNumber;
import lotto.util.Converter;
import lotto.validation.BonusNumberValidator;
import lotto.validation.PriceValidator;
import lotto.validation.WinningNumberValidator;

public class InputView {

    public static String inputPurchasePrice() {
        return Console.readLine();
    }

    public static String inputWinningNumber() {
        return Console.readLine();
    }

    public static String inputBonusNumber() {
        return Console.readLine();
    }
}
