package lotto.domain;

import java.util.stream.Stream;
import lotto.domain.Lotto;
import lotto.enums.LottoConfig;
import lotto.enums.LottoError;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    private static final LottoConfig CONFIG = LottoConfig.WOOWA_CONFIG;

    private static Stream<Arguments> provideLottoAndLottoWinningLottoAndMatchNumber() {
        WinningLotto winningLotto = WinningLotto.ofNumbersAndConfig(List.of(1, 2, 3, 4, 5, 6), CONFIG);
        return Stream.of(
                Arguments.of(Lotto.ofNumbersAndConfig(List.of(1, 2, 3, 4, 5, 6), CONFIG), winningLotto, 6),
                Arguments.of(Lotto.ofNumbersAndConfig(List.of(1, 2, 3, 4, 5, 7), CONFIG), winningLotto, 5),
                Arguments.of(Lotto.ofNumbersAndConfig(List.of(1, 2, 3, 4, 7, 8), CONFIG), winningLotto, 4),
                Arguments.of(Lotto.ofNumbersAndConfig(List.of(1, 2, 3, 7, 8, 9), CONFIG), winningLotto, 3),
                Arguments.of(Lotto.ofNumbersAndConfig(List.of(1, 2, 7, 8, 9, 10), CONFIG), winningLotto, 2),
                Arguments.of(Lotto.ofNumbersAndConfig(List.of(1, 7, 8, 9, 10, 11), CONFIG), winningLotto, 1),
                Arguments.of(Lotto.ofNumbersAndConfig(List.of(7, 8, 9, 10, 11, 12), CONFIG), winningLotto, 0)
        );
    }

    private static Stream<Arguments> provideLottoAndBonusNumberAndMatch() {
        Lotto lotto = Lotto.ofNumbersAndConfig(List.of(1, 2, 3, 4, 5, 6), CONFIG);
        WinningLotto winningLotto = WinningLotto.ofNumbersAndConfig(List.of(10, 11, 12, 13, 14, 15), CONFIG);

        return Stream.of(
                Arguments.of(lotto, BonusNumber.ofNumberAndWinningLottoAndConfig(1, winningLotto, CONFIG), true),
                Arguments.of(lotto, BonusNumber.ofNumberAndWinningLottoAndConfig(2, winningLotto, CONFIG), true),
                Arguments.of(lotto, BonusNumber.ofNumberAndWinningLottoAndConfig(3, winningLotto, CONFIG), true),
                Arguments.of(lotto, BonusNumber.ofNumberAndWinningLottoAndConfig(4, winningLotto, CONFIG), true),
                Arguments.of(lotto, BonusNumber.ofNumberAndWinningLottoAndConfig(5, winningLotto, CONFIG), true),
                Arguments.of(lotto, BonusNumber.ofNumberAndWinningLottoAndConfig(6, winningLotto, CONFIG), true),
                Arguments.of(lotto, BonusNumber.ofNumberAndWinningLottoAndConfig(7, winningLotto, CONFIG), false),
                Arguments.of(lotto, BonusNumber.ofNumberAndWinningLottoAndConfig(8, winningLotto, CONFIG), false),
                Arguments.of(lotto, BonusNumber.ofNumberAndWinningLottoAndConfig(9, winningLotto, CONFIG), false)
        );
    }

    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7);

        assertThatThrownBy(() -> Lotto.ofNumbersAndConfig(numbers, CONFIG))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoError.LOTTO_NUMBERS_COUNT.getMessage())
                .hasMessageMatching(LottoError.getErrorMessageFormat());
    }

    @Test
    void 로또_번호의_개수가_6개_미만이라면_예외가_발생한다() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        assertThatThrownBy(() -> Lotto.ofNumbersAndConfig(numbers, CONFIG))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoError.LOTTO_NUMBERS_COUNT.getMessage())
                .hasMessageMatching(LottoError.getErrorMessageFormat());
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 5);

        assertThatThrownBy(() -> Lotto.ofNumbersAndConfig(numbers, CONFIG))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoError.LOTTO_NUMBERS_DUPLICATION.getMessage())
                .hasMessageMatching(LottoError.getErrorMessageFormat());
    }

    @Test
    void 로또_번호가_최소값_미만이라면_예외가_발생한다() {
        List<Integer> numbers = List.of(0, 2, 3, 4, 5, 6);

        assertThatThrownBy(() -> Lotto.ofNumbersAndConfig(numbers, CONFIG))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoError.LOTTO_NUMBER_LESS_THAN_MIN.getMessage())
                .hasMessageMatching(LottoError.getErrorMessageFormat());
    }

    @Test
    void 로또_번호가_최대값_초과라면_예외가_발생한다() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 46);

        assertThatThrownBy(() -> Lotto.ofNumbersAndConfig(numbers, CONFIG))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoError.LOTTO_NUMBER_MORE_THAN_MAX.getMessage())
                .hasMessageMatching(LottoError.getErrorMessageFormat());
    }

    @DisplayName("getMatchWinningLotto() 메서드 기능 테스트")
    @ParameterizedTest
    @MethodSource("provideLottoAndLottoWinningLottoAndMatchNumber")
    void getMatchWinningLotto(Lotto lotto, WinningLotto winningLotto, int expectedCount) {
        int actualCount = lotto.getMatchCountWinningLotto(winningLotto);

        assertThat(actualCount).isEqualTo(expectedCount);
    }

    @DisplayName("isMatchBonusNumber() 메서드 기능 테스트")
    @ParameterizedTest
    @MethodSource("provideLottoAndBonusNumberAndMatch")
    void isMatchBonusNumber(Lotto lotto, BonusNumber bonusNumber, boolean expectedMatch) {
        boolean actualMatch = lotto.isMatchBonusNumber(bonusNumber);

        assertThat(actualMatch).isEqualTo(expectedMatch);
    }

    @DisplayName("getNumbers() 메서드 기능 테스트")
    @Test
    void getNumbers(){
        List<Integer> expectedNumbers = List.of(1,2,3,4,5,6);
        Lotto lotto = Lotto.ofNumbersAndConfig(expectedNumbers, CONFIG);

        List<Integer> actualNumbers = lotto.getNumbers();

        assertThat(actualNumbers).usingRecursiveComparison().isEqualTo(expectedNumbers);
    }




}
