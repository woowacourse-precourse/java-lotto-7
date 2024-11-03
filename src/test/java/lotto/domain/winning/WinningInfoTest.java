package lotto.domain.winning;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import lotto.domain.number.Number;
import lotto.domain.number.Numbers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningInfoTest {
    Numbers lottoNumbers;
    Number bonusNumber;
    WinningInfo winningInfo;

    @BeforeEach
    void setUp() {
        lottoNumbers = Numbers.of(Arrays.asList(1, 2, 3, 4, 5, 6));
        bonusNumber = Number.from(7);
        winningInfo = WinningInfo.of(lottoNumbers, bonusNumber);
    }

    @DisplayName("추첨한 로또 결과를 가져온다")
    @Test
    void 추첨한_로또_결과를_가져온다() {
        Numbers expectedLottoNumbers = Numbers.of(Arrays.asList(1, 2, 3, 4, 5, 6));

        assertThat(winningInfo.getWinningNumbers())
                .isEqualTo(expectedLottoNumbers);
    }

    @DisplayName("추첨한 보너스 숫자를 가져온다")
    @Test
    void 추첨한_보너스_결과를_가져온다() {
        Number expectedBonusNumber = Number.from(7);

        assertThat(winningInfo.getBonusNumber())
                .isEqualTo(expectedBonusNumber);
    }
}
