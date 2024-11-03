package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class LottoTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 로또_번호의_개수가_6개를_초과하면_예외가_발생한다() {
        assertThatThrownBy(() -> Lotto.generateLotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith(ERROR_MESSAGE);
    }

    @Test
    void 로또_번호의_개수가_6개_미만이면_예외가_발생한다() {
        assertThatThrownBy(() -> Lotto.generateLotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith(ERROR_MESSAGE);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> Lotto.generateLotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith(ERROR_MESSAGE);
    }

    @DisplayName("로또 번호에 1 미만이거나 45를 초과하는 숫자가 있으면 예외가 발생한다.")
    @ParameterizedTest
    @MethodSource("provideIntegerList")
    void 로또_번호에_1_미만이거나_45를_초과하는_숫자가_있으면_예외가_발생한다(List<Integer> wrongNumbers) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Lotto.generateLotto(wrongNumbers))
                .withMessageStartingWith(ERROR_MESSAGE);
    }

    @DisplayName("로또 번호의 숫자들은 정렬된 상태로 저장되어야 한다.")
    @Test
    void 로또_번호의_숫자들은_정렬된_상태로_저장되어야_한다() {
        //given
        List<Integer> unorderedList = List.of(4, 43, 6, 27, 31, 24);
        //when
        Lotto lotto = Lotto.generateLotto(unorderedList);
        //then
        assertThat(lotto.isSorted()).isTrue();
    }

    @Test
    void 로또_당첨_검사_1등() {
        //given
        List<Integer> unorderedList = List.of(1, 2, 3, 4, 5, 6);
        //when
        Lotto lotto = Lotto.generateLotto(unorderedList);

        //then
        assertThat(lotto.checkWin(List.of(1, 2, 3, 4, 5, 6), 7)).isEqualTo(Prize.FIRST_PLACE);
    }

    @Test
    void 로또_당첨_검사_2등() {
        //given
        List<Integer> unorderedList = List.of(1, 2, 3, 4, 5, 6);
        //when
        Lotto lotto = Lotto.generateLotto(unorderedList);

        //then
        assertThat(lotto.checkWin(List.of(1, 2, 3, 4, 5, 7), 6)).isEqualTo(Prize.SECOND_PLACE);
    }

    @Test
    void 로또_당첨_검사_낙첨() {
        //given
        List<Integer> unorderedList = List.of(1, 2, 3, 4, 5, 6);
        //when
        Lotto lotto = Lotto.generateLotto(unorderedList);

        //then
        assertThat(lotto.checkWin(List.of(6, 7, 8, 9, 10, 11), 4)).isEqualTo(Prize.NOTHING);
    }

    static Stream<List<Integer>> provideIntegerList() {
        return Stream.of(
                List.of(0, 1, 2, 3, 4, 5),
                List.of(41, 42, 43, 44, 45, 46)
        );
    }
}
