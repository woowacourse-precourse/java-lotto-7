package lotto.service;

import lotto.model.*;
import lotto.util.InputValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

class LottoResultCalculatorTest {
    @DisplayName("당첨 결과를 정확하게 계산한다.")
    @Test
    void calculateResults() {
        // given
        LottoResultCalculator calculator = new LottoResultCalculator();
        List<Lotto> lottos = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),  // 1등
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)),  // 2등 (보너스 번호 매치)
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8))   // 3등
        );
        WinningNumbers winningNumbers = createWinningNumbers("1,2,3,4,5,6");
        BonusNumber bonusNumber = createBonusNumber("7", winningNumbers);

        // when
        Map<Rank, Integer> result = calculator.calculateResults(lottos, winningNumbers, bonusNumber);

        // then
        assertThat(result.get(Rank.FIRST)).isEqualTo(1);
        assertThat(result.get(Rank.SECOND)).isEqualTo(1);
        assertThat(result.get(Rank.THIRD)).isEqualTo(1);
    }

    private WinningNumbers createWinningNumbers(String numbers) {
        return new WinningNumbers(numbers, new InputValidator());
    }

    private BonusNumber createBonusNumber(String number, WinningNumbers winningNumbers) {
        return new BonusNumber(number, winningNumbers, new InputValidator());
    }
}
