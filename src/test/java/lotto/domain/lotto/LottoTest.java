package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import java.util.stream.Stream;
import lotto.domain.winning.BonusNumber;
import lotto.domain.winning.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> Lotto.of(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> Lotto.of(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("어떤 번호가 해당 로또에 포함 여부 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void 로또_번호에_포함된_숫자(int number) {
        Lotto lotto = Lotto.of(List.of(1, 2, 3, 4, 5, 6));

        assertThat(lotto.contains(Number.of(number))).isTrue();
    }

    @DisplayName("어떤 번호가 해당 로또에 미포함 여부 테스트")
    @ParameterizedTest
    @ValueSource(ints = {11, 12, 13})
    void 로또_번호에_미포함된_숫자(int number) {
        Lotto lotto = Lotto.of(List.of(1, 2, 3, 4, 5, 6));

        assertThat(lotto.contains(Number.of(number))).isFalse();
    }

    @DisplayName("로또 번호에 포함된 당첨 번호 개수 테스트")
    @ParameterizedTest
    @MethodSource("provideLottoInfoForMatchCount")
    void 해당_로또_번호에_당첨_번호가_포함된_개수_테스트(Lotto lotto, int expected) {
        WinningLotto winningLotto = createWinningNumbers();

        assertThat(lotto.countMatchingNumbers(winningLotto))
                .isEqualTo(expected);
    }

    @DisplayName("로또 번호에 보너스 번호 포함 여부")
    @ParameterizedTest
    @MethodSource("provideLottoInfoForContainBonus")
    void 로또_번호에_보너스_번호_포함_테스트(Lotto lotto, boolean expected) {
        BonusNumber bonusNumber = createBonusNumber();

        assertThat(lotto.contains(bonusNumber))
                .isEqualTo(expected);
    }

    static Stream<Arguments> provideLottoInfoForMatchCount() {
        return Stream.of(
                Arguments.of(Lotto.of(List.of(1, 2, 3, 4, 5, 6)),
                        6),
                Arguments.of(Lotto.of(List.of(1, 2, 3, 4, 5, 7)),
                        5),
                Arguments.of(Lotto.of(List.of(1, 2, 3, 4, 7, 8)),
                        4)
        );
    }

    static Stream<Arguments> provideLottoInfoForContainBonus() {
        return Stream.of(
                Arguments.of(Lotto.of(List.of(1, 2, 3, 4, 5, 6)),
                        false),
                Arguments.of(Lotto.of(List.of(1, 2, 3, 4, 5, 7)),
                        true)
        );
    }

    private WinningLotto createWinningNumbers() {
        return WinningLotto.of(
                List.of(1, 2, 3, 4, 5, 6));
    }

    private BonusNumber createBonusNumber() {
        return BonusNumber.valueOf(createWinningNumbers(), 7);
    }
}
