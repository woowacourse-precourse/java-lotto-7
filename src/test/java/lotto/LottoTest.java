package lotto;

import lotto.domain.ticket.Lotto;
import lotto.domain.ticket.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @DisplayName("주어진 로또 번호를 가지고 있는지 확인")
    @ParameterizedTest
    @MethodSource("generateLottoData")
    void testHas(List<Integer> lottoNumberValues, int targetNumberValue, boolean expected) {
        Lotto lotto = new Lotto(lottoNumberValues);
        LottoNumber target = LottoNumber.of(targetNumberValue);
        boolean actual = lotto.has(target);

        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> generateLottoData() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), 6, true),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), 7, false)
        );
    }
}
