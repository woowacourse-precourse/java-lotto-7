package lotto.lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class WiningNumbersTest {

    @Test
    void 당첨_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new WiningNumbers(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨 번호의 개수는 6개여야 합니다.");
    }

    @Test
    void 당첨_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new WiningNumbers(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨 번호에 중복된 숫자가 있습니다.");
    }

    @ParameterizedTest
    @CsvSource(value = {"1, true", "2, true", "7, false"})
    void 당첨_번호에_포함된_번호인지_확인한다(int number, boolean expected) {
        WiningNumbers winingNumbers = new WiningNumbers(List.of(1, 2, 3, 4, 5, 6));
        LottoNumber lottoNumber = new LottoNumber(number);

        assertThat(winingNumbers.contains(lottoNumber)).isEqualTo(expected);
    }

    @Test
    void 일치하는_숫자의_개수를_계산한다() {
        // given
        WiningNumbers winingNumbers = new WiningNumbers(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto = new Lotto(List.of(5, 6, 7, 8, 9, 10));

        // when
        int countOfMatch = winingNumbers.countOfMatch(lotto);

        // then
        assertThat(countOfMatch).isEqualTo(2);
    }
}
