package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LottoTest {

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
