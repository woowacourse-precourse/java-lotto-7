package lotto.domain;

import lotto.domain.provider.DefinedNumberProvider;
import lotto.domain.validator.DefaultRangeValidator;
import lotto.domain.validator.RangeValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static lotto.domain.Rank.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class DrawTest {

    private final RangeValidator rangeValidator = new DefaultRangeValidator();
    private Lotto defaultWinningNumbers;

    @BeforeEach
    void setUp() {
        DefinedNumberProvider numberProvider = new DefinedNumberProvider(1, 2, 3, 4, 5, 6);
        this.defaultWinningNumbers = new Lotto(numberProvider, rangeValidator);
    }

    @DisplayName("추첨 시 6개의 당첨 번호와 1개의 보너스 번호를 갖는다.")
    @Test
    void drawHas6WinningNumbersAndOneBonusNumber() {
        BonusNumber bonusNumber = new BonusNumber(7, rangeValidator);
        Draw draw = new Draw(defaultWinningNumbers, bonusNumber);

        assertThat(draw).extracting("winningNumbers").isEqualTo(defaultWinningNumbers);
        assertThat(draw).extracting("bonusNumber").isEqualTo(bonusNumber);
    }

    @DisplayName("당첨 번호가 null이면 예외를 던진다.")
    @Test
    void drawWinningNumbersCannotBeNull() {
        BonusNumber bonusNumber = new BonusNumber(7, rangeValidator);
        assertThatThrownBy(() -> new Draw(null, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("당첨 번호는 null 일 수 없습니다.");
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다.")
    @Test
    void bonusNumberCannotBeDuplicatedWithWinningNumbers() {
        DefinedNumberProvider numberProvider = new DefinedNumberProvider(1, 2, 3, 4, 5, 6);
        Lotto winningNumbers = new Lotto(numberProvider, rangeValidator);

        BonusNumber bonusNumber = new BonusNumber(6, rangeValidator);

        assertThatThrownBy(() -> new Draw(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
    }

    @DisplayName("로또 번호 일치 개수에 따라 등수를 반환한다.")
    @ParameterizedTest
    @MethodSource("provideLottoWithRank")
    void returnRankByLottoMatchingCount(Lotto lotto, Rank expectedRank) {
        DefinedNumberProvider numberProvider = new DefinedNumberProvider(1, 2, 3, 4, 5, 6);
        Lotto winningNumbers = new Lotto(numberProvider, rangeValidator);
        BonusNumber bonusNumber = new BonusNumber(23, rangeValidator);
        Draw draw = new Draw(winningNumbers, bonusNumber);

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
        return new Lotto(new DefinedNumberProvider(numbers), new DefaultRangeValidator());
    }

}
