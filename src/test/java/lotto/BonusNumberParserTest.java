package lotto;

import lotto.parser.BonusNumberParser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BonusNumberParserTest {
    private Set<Integer> winningNumbers = Set.of(1,2,3,4,5,6);

    @DisplayName("정상적인 경우 파싱")
    @Test
    void 기능_테스트1() {

        assertThat(BonusNumberParser.parse("7", winningNumbers))
                .isEqualTo(7);
    }

    @DisplayName("null, 빈 문자열, 공백 입력 시 예외 발생")
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"", "   "})
    void 예외_테스트1(String input) {

        assertThatThrownBy(() -> BonusNumberParser.parse(input, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호를 입력해야 합니다.");
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복될 시 예외 발생")
    @Test
    void 예외_테스트2() {

        assertThatThrownBy(() -> BonusNumberParser.parse("2", winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스번호는 당첨번호와 중복될 수 없습니다.");
    }

    @DisplayName("보너스 번호가 숫자가 아닐 시 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"a", "1a", "1.1"})
    void 예외_테스트3(String input) {

        assertThatThrownBy(() -> BonusNumberParser.parse(input, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자만 입력 가능합니다. (예: 33)");
    }

    @DisplayName("로또 숫자 범위 이외의 값 입력 시")
    @ParameterizedTest
    @ValueSource(strings = {"0", "-1",})
    void 예외_테스트4(String input) {

        assertThatThrownBy(() -> BonusNumberParser.parse(input, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 1~45 사이의 숫자를 입력해야 합니다.");
    }

}
