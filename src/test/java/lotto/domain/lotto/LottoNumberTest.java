package lotto.domain.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static lotto.exception.ErrorMessage.LOTTO_NUMBER_OUT_OF_RANGE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@DisplayName("로또 번호 테스트")
class LottoNumberTest {
    @DisplayName("로또 번호가 1 이상이고 45 이하일 경우 예외를 발생시키지 않는다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 23, 35, 45})
    void 로또_번호가_1_이상이고_45_이하일_경우_예외를_발생시키지_않는다(int number) {
        // when, then
        assertDoesNotThrow(() -> new LottoNumber(number));
    }

    @DisplayName("로또 번호가 1 이하이고 45 이상일 경우 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(ints = {0, -1, 47, 100})
    void 로또_번호가_1_이하이고_45_이상일_경우_예외를_발생시킨다(int number) {
        // when, then
        assertThatThrownBy(() -> new LottoNumber(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LOTTO_NUMBER_OUT_OF_RANGE.getMessage());
    }

    @DisplayName("로또 번호 객체는 필드 값이 같을 시 동등하다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4})
    void 로또_번호_객체는_필드_값이_같을_시_동등하다(int number) {
        // given
        LottoNumber lottoNumber1 = new LottoNumber(number);
        LottoNumber lottoNumber2 = new LottoNumber(number);

        // when, then
        assertThat(lottoNumber1).isEqualTo(lottoNumber2);
    }
}
