package lotto.model.lotto;

import lotto.model.generator.MockNumberGenerator;
import lotto.model.generator.NumberGenerator;
import lotto.model.match.Match;
import lotto.model.match.Matches;
import lotto.model.money.Money;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {
    private final NumberGenerator numberGenerator = new MockNumberGenerator();

    @Test
    void 금액에_맞게_로또들을_생성한다() {
        Money money = Money.from(3000);
        Lottos lottos = Lottos.of(money, numberGenerator);
        assertThat(lottos.equals(
                new Lottos(List.of(Lotto.from(numberGenerator),
                        Lotto.from(numberGenerator),
                        Lotto.from(numberGenerator))
                )))
                .isTrue();
    }

    @ParameterizedTest
    @MethodSource("provideWinLotto")
    void 로또_번호_일치_여부를_확인한다(
            List<Integer> winNumbers, int bonusNumber,
            int equalCount, boolean isBonus
    ) {
        //given
        Money money = Money.from(2000);
        Lottos lottos = Lottos.of(money, numberGenerator);

        Lotto lotto = Lotto.from(winNumbers);
        Bonus bonus = new Bonus(bonusNumber);

        //when
        Matches matches = lottos.matchingLotto(lotto, bonus);
        List<Match> equalMatches = getMatches(equalCount, isBonus, equalCount, isBonus);

        //then
        assertThat(matches).isEqualTo(new Matches(equalMatches));
    }

    private static Stream<Arguments> provideWinLotto() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), 7, 6, false),
                Arguments.of(List.of(1, 3, 5, 7, 9, 11), 2, 3, true),
                Arguments.of(List.of(1, 2, 3, 4, 5, 7), 6, 5, true)
        );
    }

    private List<Match> getMatches(int equalCount1, boolean isBonus1, int equalCount2, boolean isBonus2) {
        List<Match> equalMatches = List.of(
                Match.of(equalCount1, isBonus1),
                Match.of(equalCount2, isBonus2)
        );
        return equalMatches;
    }

}