package lotto.service.calculator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.Bonus;
import lotto.domain.Lotto;
import lotto.factory.BonusFactory;
import lotto.factory.LottoFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusCalculatorTest {

    private List<Lotto> lottoTicket;

    @BeforeEach
    void before_each() {
        lottoTicket = List.of(LottoFactory.create(List.of(1, 2, 3, 4, 5, 6)),
                LottoFactory.create(List.of(7, 8, 9, 10, 11, 12)));
    }

    @DisplayName("로또와 보너스 번호를 비교해 일치 여부를 반환한다.")
    @Test
    void 로또와_보너스_번호를_비교해_일치_여부를_반환한다() {
        Bonus bonus = BonusFactory.create(2);
        List<Integer> correctResult = List.of(1, 0);

        List<Integer> bonusResult = BonusCalculator.create(lottoTicket, bonus).getBonusResult();

        assertThat(bonusResult).isEqualTo(correctResult);
    }
}