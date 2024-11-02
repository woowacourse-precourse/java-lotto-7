package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Constants;
import lotto.validator.InputValidator;

import java.util.List;

public class InputView {
    private InputValidator inputValidator;

    public InputView() {
        inputValidator= new InputValidator();
    }


    public int inputLottoPrice() {
        System.out.println(Constants.PURCHASE_LOTTO_INPUT);
        String lottoPriceString = Console.readLine();

        int lottoPrice = inputValidator.validate(lottoPriceString);

        return lottoPrice;
    }

    public String inputLottoWinningNumbers() {
    }

    public String inputLottoBonusNumber() {
    }
}
