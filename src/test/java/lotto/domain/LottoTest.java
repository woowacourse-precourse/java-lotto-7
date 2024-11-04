package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import java.util.List;
import java.util.stream.Stream;
import lotto.domain.numberPicker.NumberPicker;
import lotto.testUtil.testDouble.NumberPickerFake;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

class LottoTest {

    @Test
    void 로또를_생성한다() {
        //given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        //expected
        assertThatCode(() -> Lotto.from(numbers))
                .doesNotThrowAnyException();
    }

    @Test
    void 로또_번호의_개수가_6개보다_적으면_예외가_발생한다() {
        //given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        //expected
        assertThatThrownBy(() -> Lotto.from(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 6개여야 합니다.");
    }

    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        //given
        List<Integer> overSixNumbers = List.of(1, 2, 3, 4, 5, 6, 7);

        //expected
        assertThatThrownBy(() -> Lotto.from(overSixNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 6개여야 합니다.");
    }

    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        //given
        List<Integer> duplicatedNumbers = List.of(1, 2, 3, 4, 5, 5);

        //expected
        assertThatThrownBy(() -> Lotto.from(duplicatedNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호에 중복된 숫자가 있습니다.");
    }

    @Test
    void 로또_번호에_1보다_낮은_숫자가_있으면_예외가_발생한다() {
        //given
        List<Integer> numbers = List.of(0, 2, 3, 4, 5, 6);

        //expected
        assertThatThrownBy(() -> Lotto.from(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 1 이상, 45 이하여야 합니다.");
    }

    @Test
    void 로또_번호에_45보다_큰_숫자가_있으면_예외가_발생한다() {
        //given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 46);

        //expected
        assertThatThrownBy(() -> Lotto.from(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 1 이상, 45 이하여야 합니다.");
    }

    @Test
    void 로또_번호가_null이면_예외가_발생한다() {
        //given
        List<Integer> numbers = null;

        //expected
        assertThatThrownBy(() -> Lotto.from(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Lotto에 전달된 파라미터가 null입니다.");
    }

    @ParameterizedTest
    @CsvSource({
            "1000, 1",
            "2000, 2",
            "3000, 3",
            "100000, 100",
    })
    void 로또를_여러개_구매한다(int moneyAmount, int expectedCount) {
        //given
        Money money = Money.from(moneyAmount);
        NumberPickerFake numberPickerFake = new NumberPickerFake();
        numberPickerFake.setNumbers(1, 2, 3, 4, 5, 6);

        //when
        List<Lotto> lottos = Lotto.purchase(money, numberPickerFake);

        //then
        assertThat(lottos).hasSize(expectedCount);
    }

    @Test
    void 로또_여러개_구매시_돈이_null이면_예외가_발생한다() {
        //given
        Money money = null;
        NumberPickerFake numberPickerFake = new NumberPickerFake();

        //expected
        assertThatThrownBy(() -> Lotto.purchase(money, numberPickerFake))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Lotto에 전달된 파라미터가 null입니다.");
    }

    @Test
    void 로또_여러개_구매시_NumberPicker가_null이면_예외가_발생한다() {
        //given
        Money money = Money.from(1000);
        NumberPicker numberPicker = null;

        //expected
        assertThatThrownBy(() -> Lotto.purchase(money, numberPicker))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Lotto에 전달된 파라미터가 null입니다.");
    }

    @ParameterizedTest
    @MethodSource("provideTwoLottoNumbersAndMatchCount")
    void 로또_번호가_일치하는_개수를_반환한다(List<Integer> lottoNumbers, List<Integer> otherLottoNumbers, int expectedMatch) {
        //given
        Lotto lotto = Lotto.from(lottoNumbers);
        Lotto otherLotto = Lotto.from(otherLottoNumbers);

        //when
        int matchCount = lotto.getMatchCount(otherLotto);

        //then
        assertThat(matchCount).isEqualTo(expectedMatch);
    }

    @Test
    void 로또_번호가_일치하는_개수를_반환시_타겟_로또가_null이면_예외가_발생한다() {
        //given
        Lotto lotto = Lotto.from(List.of(1, 2, 3, 4, 5, 6));
        Lotto otherLotto = null;

        //expected
        assertThatThrownBy(() -> lotto.getMatchCount(otherLotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Lotto에 전달된 파라미터가 null입니다.");
    }

    @ParameterizedTest
    @CsvSource({
            "1, true",
            "2, true",
            "3, true",
            "7, false"
    })
    void 로또에_해당_숫자가_있는지_확인한다(int numberValue, boolean expected) {
        //given
        Lotto lotto = Lotto.from(List.of(1, 2, 3, 4, 5, 6));
        Number number = Number.from(numberValue);

        //when
        boolean contains = lotto.contains(number);

        //then
        assertThat(contains).isEqualTo(expected);
    }

    @Test
    void 로또에_해당_숫자가_있는지_확인할시_숫자가_null이면_예외가_발생한다() {
        //given
        Lotto lotto = Lotto.from(List.of(1, 2, 3, 4, 5, 6));
        Number number = null;

        //expected
        assertThatThrownBy(() -> lotto.contains(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Lotto에 전달된 파라미터가 null입니다.");
    }

    private static Stream<Arguments> provideTwoLottoNumbersAndMatchCount() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), List.of(1, 2, 3, 4, 5, 7), 5),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), List.of(7, 8, 9, 10, 11, 12), 0),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), List.of(1, 2, 3, 4, 5, 6), 6)
        );
    }
}
