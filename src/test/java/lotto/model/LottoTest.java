package lotto.model;

import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("validLottoNumberProvider")
    @DisplayName("로또 객체 생성 테스트")
    public void createLottoTest(List<Integer> numbers) {
        assertThatNoException().isThrownBy(() -> new Lotto(numbers));
    }

    private static Object[][] validLottoNumberProvider() {
        return new Object[][] {
                {List.of(1,2,3,4,5,6)},
                {List.of(2,3,4,5,6,7)},
                {List.of(12,23,34,45,11,25)}
        };
    }

    @ParameterizedTest
    @MethodSource("inValidLottoNumberProvider")
    @DisplayName("로또 객체 생성시 예외 테스트")
    public void createLottoExceptionTest(List<Integer> numbers) {
        assertThatThrownBy(() -> new Lotto(numbers));
    }

    private static Object[][] inValidLottoNumberProvider() {
        return new Object[][] {
                {List.of(1,2,3,4,5,46)},
                {List.of(2,3,4,5,6,7,8)},
                {List.of(12,23,34,48,11,25)}
        };
    }

    @ParameterizedTest
    @MethodSource("validLottoNumberProvider")
    @DisplayName("로또 객체 getter 테스트")
    public void lottoConstructorTest(List<Integer> numbers) {
        Lotto lotto = new Lotto(numbers);
        assertThat(lotto.getNumbers()).isEqualTo(numbers);
    }
}
