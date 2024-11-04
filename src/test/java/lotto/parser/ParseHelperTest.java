package lotto.parser;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.helper.ParseHelper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ParseHelperTest {

    private final ParseHelper parseHelper;

    ParseHelperTest() {
        this.parseHelper = new ParseHelper();
    }

    @Test
    @DisplayName("parseInt는 유효한 input의 경우 예외를 던지지 않는다.")
    void parseInt_WithValidString_DoesNotThrowAnyException() {
        // given
        String validInput = "123";

        assertThatCode(
                () -> parseHelper.parseInt(validInput)
        ).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("parseInt는 int형 변환이 되지 않는 input일 때 NumberFormatException을 던진다.")
    void parseInt_WithInvalidString_ThrowNumberFormatException() {
        // given
        String invalidInput = "abc";

        // when & then
        assertThatThrownBy(
                () -> parseHelper.parseInt(invalidInput)
        ).isInstanceOf(NumberFormatException.class);
    }

    @Test
    @DisplayName("parseIntegerList는 delimiter로 구분된 숫자 리스트를 반환한다.")
    void parseIntegerList_ReturnCorrectly() {
        // given
        String value = "1,2,3";
        String delimiter = ",";

        // when
        List<Integer> result = parseHelper.parseIntegerList(value, delimiter);

        // then
        assertThat(result)
                .contains(1, 2, 3)
                .hasSize(3);
    }
}
