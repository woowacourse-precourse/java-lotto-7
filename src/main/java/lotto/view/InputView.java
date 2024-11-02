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


    public List<String> inputLottoPrice() {
        System.out.println(PrintConstants.PURCHASE_LOTTO_INPUT);
        String lottoPrice= Console.readLine();

        inputValidator.validate(lottoPrice);
    }

    public String inputLottoWinningNumbers() {
    }

    public String inputLottoBonusNumber() {
    }
}
