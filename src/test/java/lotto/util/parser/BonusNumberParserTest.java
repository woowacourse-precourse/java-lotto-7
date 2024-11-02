package lotto.util.parser;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class BonusNumberParserTest {

    @DisplayName("보너스 번호는 숫자만 가능하다.")
    @ParameterizedTest
    @ValueSource(strings = {"a,bwd", "12,l", "abd"})
    void inputWithNonNumericChar(String rawBonusNumber) {
        assertThatThrownBy(() -> BonusNumberParser.parseRawBonusNumber(rawBonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("보너스 번호는 정수형 범위의 숫자만 입력 가능합니다.");
    }

    @DisplayName("보너스 번호 입력시 빈 문자열을 입력할 수 없다.")
    @ParameterizedTest
    @EmptySource
    void emptyStringParsing(String rawBonusNumber) {
        assertThatThrownBy(() -> BonusNumberParser.parseRawBonusNumber(rawBonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("보너스 번호 입력시 빈 문자열을 입력할 수 없습니다.");
    }

    @DisplayName("숫자로 구성된 문자열이 들어올 경우 해당 문자열을 정수로 변환해서 반환해야 한다.")
    @ParameterizedTest
    @CsvSource(value = {"1, 1", "2, 2", "3, 3", "23, 23", "45, 45"})
    void parseRawBonusNumber(String rawBonusNumber, int expected) {

        int bonus = BonusNumberParser.parseRawBonusNumber(rawBonusNumber);

        assertThat(bonus).isEqualTo(expected);
    }
}