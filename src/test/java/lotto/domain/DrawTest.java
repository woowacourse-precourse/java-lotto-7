package lotto.domain;

import lotto.domain.validator.DefaultRangeValidator;
import lotto.domain.validator.RangeValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static lotto.domain.Rank.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class DrawTest {

    private final RangeValidator rangeValidator = new DefaultRangeValidator();
    private Lotto winningNumbers;

    @BeforeEach
    void setUp() {
        this.winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6), rangeValidator);
    }

    @DisplayName("추첨 시 6개의 당첨 번호와 1개의 보너스 번호를 갖는다.")
    @Test
    void drawHas6WinningNumbersAndOneBonusNumber() {
        Draw draw = new Draw(winningNumbers, 7, rangeValidator);

        assertThat(draw).extracting("winningNumbers").isEqualTo(winningNumbers);
        assertThat(draw).extracting("bonusNumber").isEqualTo(7);
    }

    @DisplayName("당첨 번호가 null이면 예외를 던진다.")
    @Test
    void drawWinningNumbersCannotBeNull() {
        assertThatThrownBy(() -> new Draw(null, 7, rangeValidator))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("당첨 번호는 null 일 수 없습니다.");
    }

    @DisplayName("보너스 번호가 null이면 예외를 던진다.")
    @Test
    void bonusNumberCannotBeNull() {
        assertThatThrownBy(() -> new Draw(winningNumbers, null, rangeValidator))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("보너스 번호는 null 일 수 없습니다.");
    }

    @DisplayName("보너스 번호가 1과 45 사이 범위를 넘어가면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46})
    void bonusNumberShouldBeBetween1And45(Integer bonusNumber) {
        assertThatThrownBy(() -> new Draw(winningNumbers, bonusNumber, rangeValidator))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("보너스 번호는 1 ~ 45 사이의 숫자입니다.");
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다.")
    @Test
    void bonusNumberCannotBeDuplicatedWithWinningNumbers() {
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6), rangeValidator);

        assertThatThrownBy(() -> new Draw(winningNumbers, 6, rangeValidator))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
    }

    @DisplayName("로또 번호 일치 개수에 따라 등수를 반환한다.")
    @ParameterizedTest
    @MethodSource("provideLottoWithRank")
    void returnRankByLottoMatchingCount(Lotto lotto, Rank expectedRank) {
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6), rangeValidator);
        Draw draw = new Draw(winningNumbers, 23, rangeValidator);

        Rank rank = draw.compare(lotto);

        assertThat(rank).isEqualTo(expectedRank);
    }

    private static Stream<Arguments> provideLottoWithRank() {
        int bonus = 23;
        return Stream.of(
                Arguments.of(createLotto(1, 2, 3, 4, 5, 6), FIRST),
                Arguments.of(createLotto(1, 2, 3, 4, 5, bonus), SECOND),
                Arguments.of(createLotto(1, 2, 3, 4, 5, 45), THIRD),
                Arguments.of(createLotto(1, 2, 3, 4, 44, bonus), FOURTH),
                Arguments.of(createLotto(1, 2, 3, 4, 44, 45), FOURTH),
                Arguments.of(createLotto(1, 2, 3, 43, 44, bonus), FIFTH),
                Arguments.of(createLotto(1, 2, 3, 43, 44, 45), FIFTH),
                Arguments.of(createLotto(1, 2, 42, 43, 44, bonus), NONE),
                Arguments.of(createLotto(1, 2, 42, 43, 44, 45), NONE),
                Arguments.of(createLotto(1, 41, 42, 43, 44, bonus), NONE),
                Arguments.of(createLotto(1, 41, 42, 43, 44, 45), NONE),
                Arguments.of(createLotto(40, 41, 42, 43, 44, bonus), NONE),
                Arguments.of(createLotto(40, 41, 42, 43, 44, 45), NONE)
        );
    }

    private static Lotto createLotto(Integer...numbers) {
        return new Lotto(Arrays.asList(numbers), new DefaultRangeValidator());
    }

}
