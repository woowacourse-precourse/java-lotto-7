package lotto.util;

import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import lotto.message.Place;
import lotto.message.Prize;
import lotto.service.calculator.ResultCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PrizeMoneyCalculatorTest {

    @DisplayName("로또 당첨금을 합산한다.")
    @Test
    void 로또_당첨금을_합산한다() {
        List<Integer> winningResult = List.of(6, 2, 5);
        List<Integer> bonusResult = List.of(0, 1, 0);
        Long correctPrizeMoney = Prize.FIRST_PRIZE.getPrizeMoney() + Prize.THIRD_PRIZE.getPrizeMoney();

        ResultCalculator resultCalculator = ResultCalculator.create(winningResult, bonusResult);
        Long prizeMoney = PrizeMoneyCalculator.getPrizeMoney(resultCalculator.getPlaces());

        assertThat(prizeMoney).isEqualTo(correctPrizeMoney);
    }
}