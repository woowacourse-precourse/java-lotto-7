package lotto;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.LottoPrizeCalculator;
import lotto.model.LottoTickets;
import lotto.model.Prize;
import lotto.model.WinningLotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoPrizeCalculatorTest {
    private LottoPrizeCalculator calculator;

    @BeforeEach
    void setUpCalculator() {
        calculator = LottoPrizeCalculator.getInstance();
    }

    @Test
    @DisplayName("5개의 번호와 보너스 번호가 일치할 때 Prize가 적절하게 반환되는지 테스트")
    void determinePrizeWithBonusMatchTest() {

        List<List<Integer>> fixedNumbers = Arrays.asList(
                Arrays.asList(1, 2, 3, 4, 5, 6)
        );
        LottoTickets lottoTickets = new LottoTickets(fixedNumbers);

        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 7);
        int bonusNumber = 6;
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);

        Map<Prize, Integer> prizeCountMap = calculator.calculate(lottoTickets, winningLotto);

        Prize expectedPrize = Prize.valueOf(5, true);
        assertThat(prizeCountMap).containsKey(expectedPrize);
        assertThat(prizeCountMap.get(expectedPrize)).isEqualTo(1);
    }

    @Test
    @DisplayName("5개의 번호가 일치하고 보너스 번호가 일치하지 않을 때 Prize가 적절하게 반환되는지 테스트")
    void determinePrizeWithSixMatchTest() {
        List<List<Integer>> fixedNumbers = Arrays.asList(
                Arrays.asList(1, 2, 3, 4, 5, 6)
        );
        LottoTickets lottoTickets = new LottoTickets(fixedNumbers);

        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 7);
        int bonusNumber = 9;
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);

        Map<Prize, Integer> prizeCountMap = calculator.calculate(lottoTickets, winningLotto);

        Prize expectedPrize = Prize.valueOf(5, false);
        assertThat(prizeCountMap).containsKey(expectedPrize);
        assertThat(prizeCountMap.get(expectedPrize)).isEqualTo(1);
    }


}
