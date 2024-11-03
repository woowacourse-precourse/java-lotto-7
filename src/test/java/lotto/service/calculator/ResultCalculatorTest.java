package lotto.service.calculator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.message.Place;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultCalculatorTest {

    @DisplayName("로또 번호가 6개 일치할 경우 1등으로 판단한다.")
    @Test
    void 로또_번호가_6개_일치할_경우_1등으로_판단한다() {
        List<Integer> winningResult = List.of(6, 2, 2);
        List<Integer> bonusResult = List.of(0, 1, 0);

        ResultCalculator resultCalculator = ResultCalculator.create(winningResult, bonusResult);

        assertThat(resultCalculator.getPlaces().get(Place.FIRST_PLACE)).isEqualTo(1);
    }

    @DisplayName("로또 번호가 5개 일치하고 보너스 번호가 일치할 경우 2등으로 판단한다.")
    @Test
    void 로또_번호가_5개_일치하고_보너스_번호가_일치할_경우_2등으로_판단한다() {
        List<Integer> winningResult = List.of(5, 2, 2);
        List<Integer> bonusResult = List.of(1, 1, 0);

        ResultCalculator resultCalculator = ResultCalculator.create(winningResult, bonusResult);

        assertThat(resultCalculator.getPlaces().get(Place.SECOND_PLACE)).isEqualTo(1);
    }

    @DisplayName("로또 번호가 5개 일치할 경우 3등으로 판단한다.")
    @Test
    void 로또_번호가_5개_일치할_경우_3등으로_판단한다() {
        List<Integer> winningResult = List.of(6, 2, 5);
        List<Integer> bonusResult = List.of(0, 1, 0);

        ResultCalculator resultCalculator = ResultCalculator.create(winningResult, bonusResult);

        assertThat(resultCalculator.getPlaces().get(Place.THIRD_PLACE)).isEqualTo(1);
    }

    @DisplayName("로또 번호가 4개 일치할 경우 4등으로 판단한다.")
    @Test
    void 로또_번호가_4개_일치할_경우_4등으로_판단한다() {
        List<Integer> winningResult = List.of(4, 2, 2);
        List<Integer> bonusResult = List.of(0, 1, 0);

        ResultCalculator resultCalculator = ResultCalculator.create(winningResult, bonusResult);

        assertThat(resultCalculator.getPlaces().get(Place.FOURTH_PLACE)).isEqualTo(1);
    }

    @DisplayName("로또 번호가 6개 일치할 경우 1등으로 판단한다.")
    @Test
    void 로또_번호가_3개_일치할_경우_5등으로_판단한다() {
        List<Integer> winningResult = List.of(6, 3, 2);
        List<Integer> bonusResult = List.of(0, 1, 0);

        ResultCalculator resultCalculator = ResultCalculator.create(winningResult, bonusResult);

        assertThat(resultCalculator.getPlaces().get(Place.FIFTH_PLACE)).isEqualTo(1);
    }
}