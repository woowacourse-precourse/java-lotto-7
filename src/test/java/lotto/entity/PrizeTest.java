package lotto.entity;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PrizeTest {

    @ParameterizedTest
    @CsvSource({
            "6, true",
            "6, false",
            "5, true",
            "5, false",
            "4, true",
            "4, false",
            "3, true",
            "3, false",
    })
    void getPrize_일치되는_상이_있어_정상적으로_반환한다(int match, boolean bonus) {
        // given

        // when
        Optional<Prize> prize = Prize.getPrize(match, bonus);

        // then
        assertThat(prize.isPresent()).isTrue();
    }

    @ParameterizedTest
    @CsvSource({
            "7, true",
            "7, false",
            "2, true",
            "2, false",
            "1, true",
            "1, false",
            "0, true",
            "0, false",
    })
    void getPrize_일치되는_상이_없어_빈_Optional을_반환한다(int match, boolean bonus) {
        // given

        // when
        Optional<Prize> prize = Prize.getPrize(match, bonus);

        // then
        assertThat(prize.isEmpty()).isTrue();
    }
}