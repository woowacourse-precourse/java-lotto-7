package lotto.service;

import java.util.Arrays;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.WinningNumbers;
import lotto.domain.WinningPrize;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    private static final Calculator calculator = new Calculator();

    private static final Lotto FIFTH_LOTTO = new Lotto(Arrays.asList(1, 2, 3, 10, 11, 12));
    private static final Lotto FOURTH_LOTTO = new Lotto(Arrays.asList(1, 2, 3, 4, 10, 11));
    private static final Lotto THIRD_LOTTO = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 10));
    private static final Lotto SECOND_LOTTO = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7));
    private static final Lotto FIRST_LOTTO = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));


    @BeforeEach
    void setUp() throws Exception {
        WinningNumbers.initialInstance(Arrays.asList(1, 2, 3, 4, 5, 6));
        BonusNumber.initialInstance("7");
    }

    @Test
    void 발행한_로또에서_당첨_번호와_일치하는_번호의_갯수를_세는_기능_테스트() {
        int count = calculator.matchCount(FIFTH_LOTTO);

        Assertions.assertThat(count).isEqualTo(3);
    }

    @Test
    void 발행한_로또가_당첨_번호와_3개_일치할_때_5등인지_확인하는_기능_테스트() {
        int count = calculator.matchCount(FIFTH_LOTTO);
        Assertions.assertThat(calculator.rank(count, FIFTH_LOTTO)).isEqualTo(WinningPrize.FIFTH);
    }

    @Test
    void 발행한_로또가_당첨_번호와_4개_일치할_때_4등인지_확인하는_기능_테스트() {
        int count = calculator.matchCount(FOURTH_LOTTO);
        Assertions.assertThat(calculator.rank(count, FOURTH_LOTTO)).isEqualTo(WinningPrize.FOURTH);
    }

    @Test
    void 발행한_로또가_당첨_번호와_5개_일치할_때_3등인지_확인하는_기능_테스트() {
        int count = calculator.matchCount(THIRD_LOTTO);
        Assertions.assertThat(calculator.rank(count, THIRD_LOTTO)).isEqualTo(WinningPrize.THIRD);
    }

    @Test
    void 발행한_로또가_당첨_번호와_5개_일치하고_보너스_번호도_일치할_때_2등인지_확인하는_기능_테스트() {
        int count = calculator.matchCount(SECOND_LOTTO);
        Assertions.assertThat(calculator.rank(count, SECOND_LOTTO)).isEqualTo(WinningPrize.SECOND);
    }

    @Test
    void 발행한_로또가_당첨_번호와_6개_일치할_때_1등인지_확인하는_기능_테스트() {
        int count = calculator.matchCount(FIRST_LOTTO);
        Assertions.assertThat(calculator.rank(count, FIRST_LOTTO)).isEqualTo(WinningPrize.FIRST);
    }
}