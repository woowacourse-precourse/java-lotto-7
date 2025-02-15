package lotto.domain;

import java.util.stream.Stream;
import lotto.exception.ExceptionMessages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호의_개수가_6개보다_적으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessages.LOTTO_ELEM_AMOUNT.getMessage());
    }

    @Test
    void 로또_번호의_개수가_6개이면_예외가_발생하지_않는다() {
        assertThatCode(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6)))
                .doesNotThrowAnyException();
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessages.DUPLICATED_NUMBER_EXIST.getMessage());
    }

    @Test
    void 로또_번호에_1에서_45사이의_숫자가_아닌_수가_존재하면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 100, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessages.NUMBER_OUT_OF_RANGE.getMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5 ,6})
    void 매개변수로_들어온_숫자가_로또_번호에_존재하면_참을_반환한다(int number) {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto.isLottoContainThisNumber(number)).isEqualTo(true);
    }

    @ParameterizedTest
    @ValueSource(ints = {10, 11, 12, 13, 14, 15, 16})
    void 매개변수로_들어온_숫자가_로또_번호에_존재하지_않는다면_거짓을_반환한다(int number) {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto.isLottoContainThisNumber(number)).isEqualTo(false);
    }

    @ParameterizedTest
    @MethodSource("lotteryNumbersAndResult")
    void 로또_번호와_당첨_관련_정보들을_비교하여_Result_객체를_반환한다(Lotto lotto, Result result) {
        WinningInfo winningInfo = generateMockWinningInfo();
        assertThat(lotto.compareToWinningInfo(winningInfo)).usingRecursiveComparison().isEqualTo(result);
    }

    private WinningInfo generateMockWinningInfo() {
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(10);

        return new WinningInfo(winningNumbers, bonusNumber);
    }

    static Stream<Arguments> lotteryNumbersAndResult() {
        return Stream.of(
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)), new Result(6, 0)),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 10)), new Result(5, 1)),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 20)), new Result(5, 0)),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 21, 22)), new Result(4, 0)),
                Arguments.of(new Lotto(List.of(1, 2, 3, 21, 22, 23)), new Result(3, 0))
        );
    }
}
