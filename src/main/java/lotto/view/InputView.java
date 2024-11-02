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


    public String inputLottoPrice() {
        System.out.println(Constants.PURCHASE_LOTTO_INPUT);
        String lottoPrice = Console.readLine();

        return lottoPrice;
    }

    public String inputLottoWinningNumbers() {
        System.out.println(Constants.WINNING_LOTTO_INPUT);
        String WinningLotto = Console.readLine();

        return WinningLotto;
    }

    public String inputLottoBonusNumber() {
    }
}
