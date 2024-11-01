package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.regex.Pattern;
import lotto.common.ErrorMessage;
import lotto.dto.BonusDTO;
import lotto.dto.MoneyDTO;
import lotto.dto.WinningLottoDTO;

public class InputView {

    public static final InputView INSTANCE = new InputView();
    public static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String INPUT_WINNING_LOTTO_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    public static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    public static final String MONEY_NUMBER_REGEX = "^[1-9][0-9]*$";
    public static final String LOTTO_NUMBER_REGEX = "^[0-9]*$";

    private InputView() {
    }

    public MoneyDTO readMoney() {
        print(INPUT_MONEY_MESSAGE);
        String input = Console.readLine();
        validateMoneyFormat(input);
        return MoneyDTO.from(Long.valueOf(input));
    }

    private void validateMoneyFormat(String input) {
        if (!Pattern.matches(MONEY_NUMBER_REGEX, input)) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_MONEY_IS_DIGIT.getMessage());
        }
    }

    public WinningLottoDTO readWinningLottoNumbers() {
        print(INPUT_WINNING_LOTTO_NUMBERS_MESSAGE);
        String input = Console.readLine();
        String[] rawNumbers = split(input);
        validateLottoNumbers(rawNumbers);
        return WinningLottoDTO.from(Arrays.stream(rawNumbers).toList());
    }

    private String[] split(String input) {
        return input.split(",");
    }

    private void validateLottoNumbers(String[] rawNumbers) {
        Arrays.stream(rawNumbers).forEach(this::validateLottoNumber);
    }

    public BonusDTO readBonus() {
        print(INPUT_BONUS_NUMBER_MESSAGE);
        String input = Console.readLine();
        validateLottoNumber(input);
        return BonusDTO.from(input);
    }

    private void validateLottoNumber(String rawNumber) {
        if (!Pattern.matches(LOTTO_NUMBER_REGEX, rawNumber)) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_RANGE.getMessage());
        }
    }

    private void print(String message) {
        System.out.println(message);
    }
}
