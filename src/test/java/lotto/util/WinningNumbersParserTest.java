package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.Arrays;
import java.util.List;

import static lotto.exception.ErrorMessages.*;
import static lotto.util.WinningNumbersParser.parse;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningNumbersParserTest {
    @Test
    @DisplayName("당첨 번호는 쉼표로 구분한다")
    void 당첨_번호는_쉼표로_구분한다() {
        List<Integer> lottoNumbers = parse("1,2,3,4,5,6");

        assertThat(lottoNumbers).isEqualTo(Arrays.asList(1, 2, 3, 4, 5, 6));
    }

    @Test
    @DisplayName("당첨번호가 빈 문자열이면 에러를 발생한다 - 빈문자열일 경우")
    void 당첨번호가_빈_문자열이면_에러를_발생한다() {
        assertThatThrownBy(() -> parse(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INPUT_EMPTY_ERROR);
    }

    @Test
    @DisplayName("당첨번호가 빈 문자열이면 에러를 발생한다 - 공백일 경우")
    void 당첨번호가_빈_문자열이면_에러를_발생한다2() {
        assertThatThrownBy(() -> parse(" "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INPUT_EMPTY_ERROR);
    }

}