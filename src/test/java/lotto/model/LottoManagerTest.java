package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lotto.util.FixedRandomNumbers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoManagerTest {
    private FixedRandomNumbers fixedRandomNumbers;
    private Lottos lottos;
    private WinningNumbers winningNumbers;
    private BonusNumber bonusNumber;

    @BeforeEach
    void setUp() {
        fixedRandomNumbers = new FixedRandomNumbers();
        lottos = Lottos.of(1, fixedRandomNumbers);
    }

    @DisplayName("Lotto 결과를 확인할 수 있다.")
    @Test
    void createLottoManager() {
        // given
        LottoManager lottoManager = LottoManager.of(lottos, winningNumbers, bonusNumber);
        winningNumbers = WinningNumbers.of(List.of(1, 2, 3, 4, 5, 6));
        bonusNumber = BonusNumber.of(7, winningNumbers.winningNumbers());

        // when
        Map<Rank, Long> expectedResult = new LinkedHashMap<>(Map.of(
                Rank.FIRST, 1L,
                Rank.SECOND, 0L,
                Rank.THIRD, 0L,
                Rank.FOURTH, 0L,
                Rank.FIFTH, 0L
        ));

        // that
        assertThat(lottoManager.getResults()).isEqualTo(expectedResult);
    }

    @DisplayName("로또의 수익률을 확인할 수 있다.")
    @Test
    void canCheckRateOfReturn() {
        // given
        winningNumbers = WinningNumbers.of(List.of(10, 11, 12, 13, 14, 16));
        bonusNumber = BonusNumber.of(7, winningNumbers.winningNumbers());
        LottoManager lottoManager = LottoManager.of(lottos, winningNumbers, bonusNumber);

        // when
        double exceptedRateOfReturn = 0D;

        // & then
        assertThat(lottoManager.calculateRateOfReturn(1000)).isEqualTo(exceptedRateOfReturn);
    }
}
