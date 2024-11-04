package lotto.util;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NumberArrayParserTest {
    @Nested
    class 숫자_배열_변환_테스트 {
        @Test
        void 쉼표로_구분된_숫자_문자열을_정수_리스트로_변환한다() {
            // given
            String input = "1,2,3,4,5";

            // when
            List<Integer> result = NumberArrayParser.parse(input);

            // then
            assertThat(result)
                    .containsExactly(1, 2, 3, 4, 5)
                    .hasSize(5);
        }

        @Test
        void 공백이_포함된_숫자_문자열을_정수_리스트로_변환한다() {
            // given
            String input = " 1 , 2 , 3 , 4 , 5 ";

            // when
            List<Integer> result = NumberArrayParser.parse(input);

            // then
            assertThat(result)
                    .containsExactly(1, 2, 3, 4, 5)
                    .hasSize(5);
        }

        @Test
        void 빈_문자열_입력_시_빈_리스트를_반환한다() {
            // given
            String input = "";

            // when
            List<Integer> result = NumberArrayParser.parse(input);

            // then
            assertThat(result).isEmpty();
        }
    }

    @Nested
    class 예외_케이스_처리_테스트 {
        @Test
        void 연속된_쉼표는_무시한다() {
            // given
            String input = "1,,2,,,3,,4,,5";

            // when
            List<Integer> result = NumberArrayParser.parse(input);

            // then
            assertThat(result)
                    .containsExactly(1, 2, 3, 4, 5)
                    .hasSize(5);
        }

        @ParameterizedTest
        @ValueSource(strings = {
                ",", ",,", ",,,",
                " , ", " ,, "
        })
        void 쉼표로만_이루어진_입력은_빈_리스트를_반환한다(String input) {
            // when
            List<Integer> result = NumberArrayParser.parse(input);

            // then
            assertThat(result).isEmpty();
        }
    }
}
