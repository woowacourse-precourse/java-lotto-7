package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> Lotto.fromIntegers(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> Lotto.fromIntegers(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호를_문자로_생성한다() {
        assertThat(Lotto.fromString("1,2,3,4,5,6")).isEqualTo(Lotto.fromIntegers(List.of(1, 2, 3, 4, 5, 6)));
    }

    @Test
    void 일치하는_로또번호의_개수를_반환한다() {
        Lotto lotto = Lotto.fromIntegers(List.of(1, 2, 3, 4, 7, 8));
        assertThat(lotto.matchCount(Lotto.fromIntegers(List.of(1, 2, 3, 4, 5, 6)))).isEqualTo(4);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,true", "6,false"}, delimiter = ',')
    void 로또_숫자가_존재하는지_반환한다(int number, boolean result) {
        Lotto lotto = Lotto.fromIntegers(List.of(1, 2, 3, 4, 7, 8));
        assertThat(lotto.contains(new LottoNumber(number))).isEqualTo(result);
    }
}
