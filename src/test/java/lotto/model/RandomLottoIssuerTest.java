package lotto.model;

import static lotto.common.constant.LottoIntegerConstant.LOTTO_NUMBER_LOWER_BOUND;
import static lotto.common.constant.LottoIntegerConstant.LOTTO_NUMBER_UPPER_BOUND;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

class RandomLottoIssuerTest {

    private Lotto lotto;

    @BeforeEach
    void setUp() {
        // given
        LottoIssuer lottoIssuer = new RandomLottoIssuer();

        // when
        lotto = lottoIssuer.issue();
    }

    @RepeatedTest(100)
    void 로또_번호_6개를_랜덤하게_생성한다() {
        assertEquals(lotto.numbers().size(), 6);
    }

    @RepeatedTest(100)
    void 랜덤하게_생성된_로또_번호는_중복되지_않는다() {
        long distinctCount = lotto.numbers().stream().distinct().count();
        assertEquals(distinctCount, 6);
    }

    @RepeatedTest(100)
    void 랜덤하게_생성된_로또_번호는_1에서_45_사이의_값을_가진다() {
        lotto.numbers().forEach(
                number -> assertThat(number.number())
                        .isBetween(LOTTO_NUMBER_LOWER_BOUND.number(), LOTTO_NUMBER_UPPER_BOUND.number()));
    }
}