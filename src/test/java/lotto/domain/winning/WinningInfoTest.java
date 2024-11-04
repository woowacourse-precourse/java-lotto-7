package lotto.domain.winning;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import lotto.domain.number.Number;
import lotto.domain.number.NumberFactory;
import lotto.domain.number.Numbers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningInfoTest {
    Numbers winningLottoNumbers;
    Number bonusNumber;
    WinningInfo winningInfo;

    @BeforeEach
    void setUp() {
        winningLottoNumbers = Numbers.of(Arrays.asList(1, 2, 3, 4, 5, 6));
        bonusNumber = NumberFactory.createBonusNumber(7, winningLottoNumbers);
        winningInfo = WinningInfo.of(winningLottoNumbers, bonusNumber);
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
        Number expectedBonusNumber = NumberFactory.createBonusNumber(7, winningLottoNumbers);

        assertThat(winningInfo.getBonusNumber())
                .isEqualTo(expectedBonusNumber);
    }

    @DisplayName("추첨한 로또 번호와 보너스 숫자가 중복되면 예외를 던진다.")
    @Test
    void 추첨한_로또_번호와_보너스_숫자가_중복되면_예외를_던진다() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> NumberFactory.createBonusNumber(6, winningLottoNumbers));
    }
}
