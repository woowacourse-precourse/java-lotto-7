package lotto.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CommonUtilTest {

    @Test
    @DisplayName("문자열을 정수로 정상적으로 변환")
    void 문자열_정수_변환() {
        Integer number = CommonUtil.stringToInteger("1000");
        assertThat(number).isEqualTo(1000);
    }

    @Test
    @DisplayName("문자열을 정수로 변환할 때 실패 시 예외 발생")
    void 문자열_정수_변환_실패() {
        assertThatThrownBy(() -> CommonUtil.stringToInteger("abc"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 입력 값은 숫자로만 이루어져 있어야 합니다.");
    }

    @Test
    @DisplayName("쉼표로 구분된 문자열을 리스트로 변환")
    void 문자열_리스트_변환() {
        List<Integer> numbers = CommonUtil.splitToList("1,2,3");
        assertThat(numbers).containsExactly(1, 2, 3);
    }

    @Test
    @DisplayName("쉼표로 구분된 문자열에 숫자가 아닌 값이 포함될 경우 예외 발생")
    void 문자열_리스트_변환_실패() {
        assertThatThrownBy(() -> CommonUtil.splitToList("1,a,3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 입력 값은 숫자로만 이루어져 있어야 합니다.");
    }

    @Test
    @DisplayName("수익률을 소수점 첫째 자리까지 반올림하여 문자열로 반환")
    void 수익률_소수점_첫째_자리_반올림() {
        double profitRate = 62.54321;
        String formattedRate = CommonUtil.formatToSingleDecimalPlace(profitRate);
        assertThat(formattedRate).isEqualTo("62.5");
    }
}