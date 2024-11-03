package lotto.utils;

import static java.lang.String.format;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import lotto.exception.LottoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class InputParserTest {
    @Nested
    @DisplayName("구입 금액 파싱 테스트" )
    class PriceInputParserTest {
        @Test
        void 구입_금액은_숫자여야_한다() {
            // given
            String input = "1000";

            // when & then
            assertDoesNotThrow(() -> InputParser.parsePrice(input));
        }
        @Test
        void 구입_금액이_문자이면_예외가_발생한다() {
            // given
            String input = "abc";

            // when & then
            assertThatThrownBy(() -> InputParser.parsePrice(input))
                    .isInstanceOf(LottoException.class)
                    .hasMessage("[ERROR] 구입 금액은 int 범위 내의 숫자여야 합니다." );
        }

        @Test
        void 구입_금액이_Null_이면_예외가_발생한다() {
            // given
            String input = "";

            // when & then
            assertThatThrownBy(() -> InputParser.parsePrice(input))
                    .isInstanceOf(LottoException.class)
                    .hasMessage("[ERROR] 빈 입력입니다." );
        }

        @Test
        void 구입_금액이_공백이면_예외가_발생한다() {
            // given
            String input = " ";

            // when & then
            assertThatThrownBy(() -> InputParser.parsePrice(input))
                    .isInstanceOf(LottoException.class)
                    .hasMessage("[ERROR] 구입 금액은 int 범위 내의 숫자여야 합니다." );
        }

        @Test
        void 구입_금액이_int_범위를_넘으면_예외가_발생한다() {
            // given
            String input = "2147483648";

            // when & then
            assertThatThrownBy(() -> InputParser.parsePrice(input))
                    .isInstanceOf(LottoException.class)
                    .hasMessage("[ERROR] 구입 금액은 int 범위 내의 숫자여야 합니다." );
        }
    }

    @Nested
    @DisplayName("당첨 번호 파싱 테스트" )
    class NumbersInputParserTest {
        @Test
        void 당첨_번호는_숫자로만_이루어져야_한다() {
            // given
            String input = "1,2,3,4,5,6";

            // when & then
            assertDoesNotThrow(() -> InputParser.parseNumbers(input));
        }

        @Test
        void NULL_이_입력되면_예외가_발생한다() {
            // given
            String input = "";

            // when & then
            assertThatThrownBy(() -> InputParser.parseNumbers(input))
                    .isInstanceOf(LottoException.class)
                    .hasMessage("[ERROR] 빈 입력입니다." );
        }

        @Test
        void 공백이_입력되면_예외가_발생한다() {
            // given
            String input = " ";

            // when & then
            assertThatThrownBy(() -> InputParser.parseNumbers(input))
                    .isInstanceOf(LottoException.class)
                    .hasMessage("[ERROR] 당첨 번호는 숫자여야 합니다." );
        }

        @Test
        void 입력이_구분자로_끝나면_예외가_발생한다() {
            final String DELIMITER = ",";

            // given
            String input = "1,2,3,4,5,6,";

            // when & then
            assertThatThrownBy(() -> InputParser.parseNumbers(input))
                    .isInstanceOf(LottoException.class)
                    .hasMessage(format("[ERROR] 입력은 구분자(%s)로 끝날 수 없습니다.", DELIMITER));
        }

        @Test
        void 당첨_번호가_문자로_입력되면_예외가_발생한다() {
            // given
            String input = "1,2,a,4,b,c";

            // when & then
            assertThatThrownBy(() -> InputParser.parseNumbers(input))
                    .isInstanceOf(LottoException.class)
                    .hasMessage("[ERROR] 당첨 번호는 숫자여야 합니다." );
        }

        @Test
        void 당첨_번호에_공백이_포함되면_예외가_발생한다() {
            // given
            String input = "1,2,3, 4,5, 6";

            // when & then
            assertThatThrownBy(() -> InputParser.parseNumbers(input))
                    .isInstanceOf(LottoException.class)
                    .hasMessage("[ERROR] 당첨 번호는 숫자여야 합니다." );
        }
    }

    @Nested
    @DisplayName("보너스 번호 파싱 테스트" )
    class BonusNumberInputParserTest {
        @Test
        void 보너스_번호는_숫자여야_한다() {
            // given
            String input = "5";

            // when & then
            assertDoesNotThrow(() -> InputParser.parseBonusNumber(input));
        }

        @Test
        void NULL_이_입력되면_예외가_발생한다() {
            // given
            String input = "";

            // when & then
            assertThatThrownBy(() -> InputParser.parseBonusNumber(input))
                    .isInstanceOf(LottoException.class)
                    .hasMessage("[ERROR] 빈 입력입니다.");
        }

        @Test
        void 공백이_입력되면_예외가_발생한다() {
            // given
            String input = " ";

            // when & then
            assertThatThrownBy(() -> InputParser.parseBonusNumber(input))
                    .isInstanceOf(LottoException.class)
                    .hasMessage("[ERROR] 보너스 번호는 숫자여야 합니다.");
        }

        @Test
        void 입력에_공백이_포함되면_예외가_발생한다() {
            // given
            String input = "5 ";

            // when & then
            assertThatThrownBy(() -> InputParser.parseBonusNumber(input))
                    .isInstanceOf(LottoException.class)
                    .hasMessage("[ERROR] 보너스 번호는 숫자여야 합니다.");
        }

        @Test
        void 보너스_번호가_int_범위를_넘으면_예외가_발생한다() {
            // given
            String input = "2147483648";

            // when & then
            assertThatThrownBy(() -> InputParser.parseBonusNumber(input))
                    .isInstanceOf(LottoException.class)
                    .hasMessage("[ERROR] 보너스 번호는 숫자여야 합니다." );
        }
    }
}
