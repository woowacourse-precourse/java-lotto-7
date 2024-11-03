package lotto.entity;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;
import org.junit.jupiter.api.Test;

class PrizeTest {

    @Test
    void getPrize_일치되는_상이_있어_정상적으로_반환한다() {
        // given
        int match = 6;
        boolean bonus = false;

        // when
        Optional<Prize> prize = Prize.getPrize(match, bonus);

        // then
        assertThat(prize.isPresent()).isTrue();
    }

    @Test
    void getPrize_일치되는_상이_없어_빈_Optional을_반환한다() {
        // given
        int match = 0;
        boolean bonus = true;

        // when
        Optional<Prize> prize = Prize.getPrize(match, bonus);

        // then
        assertThat(prize.isEmpty()).isTrue();
    }
}