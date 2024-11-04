package lotto.utils;

import static lotto.exception.ErrorMessage.INVALID_WINNER_NUMBER_TYPE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.exception.LottoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ParserTest {

    @Test
    @DisplayName("parse - 쉼표 단위로 파싱 한 후 Integer 리스트로 정상 반환한다.")
    void successParseNumbers() {
        // given
        String test = "1,2,3,4";
        // when
        List<Integer> result = Parser.parse(test);
        // then
        assertThat(result).containsExactly(1, 2, 3, 4);
    }

    @Test
    @DisplayName("parse - 숫자가 하나인 경우 리스트에 하나만 담긴다.")
    void successParseNumber() {
        // given
        String test = "1";
        // when
        List<Integer> result = Parser.parse(test);
        // then
        assertThat(result).containsExactly(1);
    }

    @Test
    @DisplayName("parse - 중간 숫자 양쪽에 공백이 있어도 정상적으로 작동한다.")
    void successParseWhenHasSideBlank() {
        // given
        String test = "1, 2,3 , 4 ";
        // when
        List<Integer> result = Parser.parse(test);
        // then
        assertThat(result).containsExactly(1, 2, 3, 4);
    }

    @Test
    @DisplayName("parse - 빈 칸이 있는 경우 예외가 발생한다.")
    void failParseWhenHasBlank() {
        // given
        String test = "1, 2, , 4 ";
        // when & then
        assertThatThrownBy(() -> Parser.parse(test))
                .isInstanceOf(LottoException.class)
                .hasMessage(INVALID_WINNER_NUMBER_TYPE.getMessage());
    }

    @Test
    @DisplayName("parse - 숫자가 아닌 문자가 있는 경우 예외가 발생한다.")
    void failParseWhenNotNumber() {
        // given
        String test = "1, 2, a, 4 ";
        // when & then
        assertThatThrownBy(() -> Parser.parse(test))
                .isInstanceOf(LottoException.class)
                .hasMessage(INVALID_WINNER_NUMBER_TYPE.getMessage());
    }

    @Test
    @DisplayName("parse - 쉼표가 아닌 다른 기준으로 나누면 예외가 발생한다.")
    void failParseWhenParseWithDifferentDelimiter() {
        // given
        String test = "1; 2; a; 4 ";
        // when & then
        assertThatThrownBy(() -> Parser.parse(test))
                .isInstanceOf(LottoException.class)
                .hasMessage(INVALID_WINNER_NUMBER_TYPE.getMessage());
    }
}

