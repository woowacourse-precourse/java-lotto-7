package lotto.ui;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoPayment;
import lotto.exception.LottoArgumentException;

public class InputController {
    private static final String BLANK_INPUT_ERROR_MESSAGE = "공백은 허용되지 않습니다.";
    private static final String ITS_NOT_NUMBER_ERROR_MESSAGE = "숫자가 아닙니다.";
    private static final String REPEATED_SEPARATOR_ERROR_MESSAGE = "구분자가 반복되고 있습니다.";
    private static final String START_WITH_SEPARATOR_ERROR_MESSAGE = "구분자로 시작되고 있습니다.";
    private static final String END_WITH_SEPARATOR_ERROR_MESSAGE = "구분자로 종료되고 있습니다.";
    private static final String SEPARATOR = ",";
    private static final String SPACE = " ";
    private static final String BLANK = "";

    private final InputUi inputUi;

    InputController(final InputUi inputUi) {
        this.inputUi = inputUi;
    }

    public LottoPayment getPayment() {
        final String input = this.readTrimmedInput();
        validateSingleNumber(input);
        return new LottoPayment(input);
    }

    public Lotto getLotto() {
        final String input = this.readTrimmedInput();
        final List<String> lottoNumbers = split(input);
        for (final String number : lottoNumbers) {
            validateSingleNumber(number);
        }
        return new Lotto(lottoNumbers.stream()
                .map(LottoNumber::new).collect(Collectors.toList()));
    }

    public LottoNumber getBonusNumber() {
        final String input = this.readTrimmedInput();
        this.validateSingleNumber(input);
        return new LottoNumber(input);
    }

    private List<String> split(final String inputLottoNumbers) {
        validateNumbers(inputLottoNumbers);
        return Arrays.stream(inputLottoNumbers.split(SEPARATOR))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    private void validateNumbers(final String spaceRemovedInputNumbers) {
        validateStartsWithSeparator(spaceRemovedInputNumbers);
        validateEndWithSeparator(spaceRemovedInputNumbers);
        validateRepeatedSeparator(spaceRemovedInputNumbers);
    }

    private void validateRepeatedSeparator(final String inputNumbers) {
        if (inputNumbers.contains(SEPARATOR + SEPARATOR)) {
            throw new LottoArgumentException(REPEATED_SEPARATOR_ERROR_MESSAGE);
        }
    }

    private void validateStartsWithSeparator(final String inputNumbers) {
        if (inputNumbers.startsWith(SEPARATOR)) {
            throw new LottoArgumentException(START_WITH_SEPARATOR_ERROR_MESSAGE);
        }
    }

    private void validateEndWithSeparator(final String inputNumbers) {
        if (inputNumbers.endsWith(SEPARATOR)) {
            throw new LottoArgumentException(END_WITH_SEPARATOR_ERROR_MESSAGE);
        }
    }

    private String readTrimmedInput() {
        final String trimmedInput = inputUi.readLine().trim();
        return trimmedInput.replaceAll(SPACE, BLANK);
    }

    private void validateSingleNumber(final String numberInput) {
        isBlank(numberInput);
        isPositiveNumber(numberInput);
    }

    private void isBlank(final String numberInput) {
        if (numberInput.isBlank()) {
            throw new LottoArgumentException(BLANK_INPUT_ERROR_MESSAGE);
        }
    }

    private void isPositiveNumber(final String numberInput) {
        for (int i = 0; i < numberInput.length(); i++) {
            if (!Character.isDigit(numberInput.charAt(i))) {
                throw new LottoArgumentException(ITS_NOT_NUMBER_ERROR_MESSAGE);
            }
        }
    }
}
