package lotto.model.lotto;

import lotto.config.AppConfig;
import lotto.model.generator.MockNumberGenerator;
import lotto.model.match.Match;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.common.Error.LOTTO_LENGTH_LIMIT;
import static lotto.common.Error.NOT_DUPLICATED_NUMBER;
import static lotto.common.Error.OUT_OF_RANGE;
import static lotto.common.Rule.MAXIMUM_RANGE_NUMBER;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    private final AppConfig appConfig = new AppConfig();

    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> Lotto.from(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_LENGTH_LIMIT.getMessage());
    }

    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> Lotto.from(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_DUPLICATED_NUMBER.getMessage());
    }


    @Test
    void 로또_번호가_범위를_넘어서면_예외가_발생한다() {
        assertThatThrownBy(() -> Lotto.from(List.of(1, 2, 3, 4, 5, MAXIMUM_RANGE_NUMBER.getNumber() + 1)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(OUT_OF_RANGE.getMessage());
    }

    @Test
    void 오름차순으로_정렬된_로또번호를_반환한다() {
        Lotto lotto = Lotto.from(new MockNumberGenerator());
        assertThat(lotto.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }

    @Test
    void 로또_번호를_비교하여_올바른_매치정보를_반환한다() {
        Lotto lotto = Lotto.from(List.of(1, 2, 3, 4, 5, 6));
        Match match = lotto.compareTo(Lotto.from(List.of(1, 2, 3, 10, 11, 12)), new Bonus(4));
        assertThat(match).isEqualTo(Match.of(3, true));
    }

    @Test
    void 로또_번호가_해당_번호를_포함할때_true_를_반환한다() {
        //given
        Lotto lotto = Lotto.from(List.of(1, 2, 3, 4, 5, 6));

        //when
        boolean contain = lotto.isContain(1);
        boolean notContain = lotto.isContain(10);

        //then
        assertThat(contain).isTrue();
        assertThat(notContain).isFalse();
    }
}
