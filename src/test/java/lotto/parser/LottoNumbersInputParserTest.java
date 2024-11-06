package lotto.parser;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static lotto.exception.ErrorMessage.LOTTO_NUMBER_NOT_DIGIT;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("로또 번호 입력값 파싱 테스트")
class LottoNumbersInputParserTest {
    @DisplayName("주어진 입력값에 구분자 외에 숫자가 아닌 값이 포함되어 있을 때 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"d,1,2,3", "1,!,2,3", "1,2,(,3"})
    void 주어진_입력값에_구분자_외에_숫자가_아닌_값이_포함되어_있을_때_예외를_발생시킨다(String input) {
        // when, then
        assertThatThrownBy(() -> LottoNumbersInputParser.getInstance().parse(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LOTTO_NUMBER_NOT_DIGIT.getMessage());
    }
}
