package lotto.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ParseNumberUtilTest {

    @DisplayName("문자열을 쉼표로 구분해서 나눈다")
    @Test
    void 문자열을_쉼표로_구분해서_나눈다() {
        List<Integer> result = ParseNumberUtil.parseNumber("1,2,3,4,5,6 ");

        assertThat(result).hasSize(6);
        assertThat(result).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @DisplayName("쉼표로 끝나면 예외를 발생한다")
    @Test
    void 쉼표로_끝나면_예외를_발생한다() {
        assertThatThrownBy(() -> ParseNumberUtil.parseNumber("1,2,3,4,5,6,"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자가 아닌 값이 있으면 예외를 발생한다.")
    @Test
    void 숫자가_아닌_값이_있으면_예외를_발생한다() {
        assertThatThrownBy(() -> ParseNumberUtil.parseNumber("1,2,3,4a,5,6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("빈 값이면 예외를 발생한다")
    @Test
    void 빈_값이면_예외를_발생한다() {
        assertThatThrownBy(() -> ParseNumberUtil.parseNumber(" "))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 문자열을_숫자로_바꾼다() {
        assertThat(ParseNumberUtil.parseNumberToInteger("1"))
                .isEqualTo(1);
    }
}