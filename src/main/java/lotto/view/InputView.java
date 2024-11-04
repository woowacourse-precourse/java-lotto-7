package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import lotto.dto.BonusDTO;
import lotto.dto.MoneyDTO;
import lotto.dto.WinningLottoDTO;
import lotto.validator.InputValidator;

public class InputView {

    public static final InputView INSTANCE = new InputView();
    public static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String INPUT_WINNING_LOTTO_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    public static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    private InputValidator inputValidator;

    private InputView() {
        this.inputValidator = new InputValidator();
    }

    public MoneyDTO readMoney() {
        print(INPUT_MONEY_MESSAGE);
        String input = Console.readLine();
        inputValidator.validateBlank(input);
        inputValidator.validateMoneyFormat(input);
        return MoneyDTO.from(Long.valueOf(input));
    }


    public WinningLottoDTO readWinningLottoNumbers() {
        print(INPUT_WINNING_LOTTO_NUMBERS_MESSAGE);
        String input = Console.readLine();
        inputValidator.validateBlank(input);
        String[] rawNumbers = split(input);
        inputValidator.validateLottoNumbers(rawNumbers);
        return WinningLottoDTO.from(Arrays.stream(rawNumbers).toList());
    }

    private String[] split(String input) {
        return input.split(",");
    }


    public BonusDTO readBonus() {
        print(INPUT_BONUS_NUMBER_MESSAGE);
        String input = Console.readLine();
        inputValidator.validateBlank(input);
        inputValidator.validateLottoNumber(input);
        return BonusDTO.from(input);
    }


    private void print(String message) {
        System.out.println(message);
    }
}
