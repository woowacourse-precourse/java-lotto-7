package lotto.util.parser;

import lotto.exception.InputErrorMessage;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ParserTest {

    @ParameterizedTest
    @ValueSource(strings = {"YOON", "*&!"})
    void 입력값이_숫자가_아니면_예외발생(String inValidAmount) {
        assertThatThrownBy(() -> ParserUtil.convertToNumber(inValidAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(InputErrorMessage.INVALID_NUMERIC_FORMAT.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {""," "})
    void 입력값이_없다면_예외발생(String inValidAmount) {
        assertThatThrownBy(() -> ParserUtil.convertToNumber(inValidAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(InputErrorMessage.EMPTY_INPUT.getMessage());
    }
}
