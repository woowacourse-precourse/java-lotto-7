package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.WIN_NUMBER_SIZE_MUST_6.getMessage());
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.DUPLICATE_WIN_NUMBERS.getMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = {-3, 0, 57})
    void 로또_번호가_1_45_사이가_아닐시_예외_발생(int errorNum) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(errorNum);

        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.LOTTO_NUMBER_BETWEEN_1_AND_45.getMessage());
    }

    @Test
    void 로또_당첨_1등() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> winnerNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonus = 7;

        // when
        LottoRank lottoRank = lotto.checkRank(winnerNumbers, bonus);

        // then
        assertThat(lottoRank)
                .isEqualTo(LottoRank.GRADE_1TH);
    }

    @Test
    void 로또_당첨_2등() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 9));
        List<Integer> winnerNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonus = 9;

        // when
        LottoRank lottoRank = lotto.checkRank(winnerNumbers, bonus);

        // then
        assertThat(lottoRank)
                .isEqualTo(LottoRank.GRADE_2TH);
    }

    @Test
    void 로또_당첨_3등() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 9));
        List<Integer> winnerNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonus = 7;

        // when
        LottoRank lottoRank = lotto.checkRank(winnerNumbers, bonus);

        // then
        assertThat(lottoRank)
                .isEqualTo(LottoRank.GRADE_3TH);
    }

    @Test
    void 로또_당첨_4등() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 8, 9));
        List<Integer> winnerNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonus = 7;

        // when
        LottoRank lottoRank = lotto.checkRank(winnerNumbers, bonus);

        // then
        assertThat(lottoRank)
                .isEqualTo(LottoRank.GRADE_4TH);
    }

    @Test
    void 로또_당첨_5등() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 7, 8, 9));
        List<Integer> winnerNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonus = 7;

        // when
        LottoRank lottoRank = lotto.checkRank(winnerNumbers, bonus);

        // then
        assertThat(lottoRank)
                .isEqualTo(LottoRank.GRADE_5TH);
    }

    @ParameterizedTest
    @MethodSource("generate꽝")
    void 로또_당첨_꽝(List<Integer> numbers) {
        // given
        Lotto lotto = new Lotto(numbers);
        List<Integer> winnerNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonus = 7;

        // when
        LottoRank lottoRank = lotto.checkRank(winnerNumbers, bonus);

        // then
        assertThat(lottoRank)
                .isEqualTo(LottoRank.NONE);
    }

    static Stream<Arguments> generate꽝() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 31, 7, 8, 9)),
                Arguments.of(List.of(1, 21, 31, 17, 8, 9)),
                Arguments.of(List.of(11, 21, 31, 17, 8, 9))
        );
    }
}
