package lotto.application.util.StrinConverter;

import java.util.List;
import lotto.application.util.StringConverter;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("StringConverter - toInts 테스트")
public class ToIntsTest {

    @DisplayName("숫자 문자열 배열을 정수 리스트로 반환")
    @Test
    void 숫자_문자열배열을_정수리스트로_반횐() {
        // given
        String[] input = {"1", "2", "3"};

        // when
        List<Integer> result = StringConverter.toInts(input);

        // then
        Assertions.assertThat(result).containsExactly(1, 2, 3);
    }

    @Test
    @DisplayName("숫자가 아닌 문자열이 포함되면 예외 발생")
    void 숫자가_아닌_문자열이_포함되면_예외발생() {
        // given
        String[] input = {"1", "abc", "3"};

        // expect
        Assertions.assertThatThrownBy(() -> StringConverter.toInts(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자로 변환할 수 없는 값입니다.");
    }

}
