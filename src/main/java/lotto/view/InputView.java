package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.PrintConstants;
import lotto.validator.InputValidator;

import java.util.List;

public class InputView {
    private InputValidator inputValidator;
    private PrintConstants printConstants;

    public InputView() {
        inputValidator= new InputValidator();
        printConstants= new PrintConstants();
    }


    public int inputLottoPrice() {
        System.out.println(PrintConstants.PURCHASE_LOTTO_INPUT);
        String lottoPriceString = Console.readLine();

        int lottoPrice = inputValidator.validate(lottoPriceString);

        return lottoPrice;
    }

    public String inputLottoWinningNumbers() {
    }

    public String inputLottoBonusNumber() {
    }
}
