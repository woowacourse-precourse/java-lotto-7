package lotto.domain.lotto;

import lotto.domain.number.BonusNumber;
import lotto.domain.number.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinningLottoTest {

    @DisplayName("당첨 번호와 보너스 번호를 비교하여 당첨 등수를 결정한다.")
    @ParameterizedTest
    @CsvSource(value = {
            "1,2,3,4,5,6, FIRST",
            "1,2,3,4,5,7, SECOND",
            "1,2,3,4,5,8, THIRD",
            "1,2,3,4,8,9, FOURTH",
            "1,2,3,8,9,10, FIFTH",
            "1,2,8,9,10,11, NONE"
    })
    void should_ReturnCorrectLottoRank_When_MatchingNumbersAndBonusNumberGiven(
            int num1, int num2, int num3, int num4, int num5, int num6,
            LottoRank expectedRank
    ) {
        // given
        WinningNumbers winningNumbers = WinningNumbers.from("1,2,3,4,5,6");
        BonusNumber bonusNumber = BonusNumber.from(7, winningNumbers);
        Lotto lotto = Lotto.from(new ArrayList<>(List.of(num1, num2, num3, num4, num5, num6)));

        // when
        WinningLotto winningLotto = WinningLotto.createWinningLotto(lotto, winningNumbers, bonusNumber);

        // then
        assertThat(winningLotto.getRank()).isEqualTo(expectedRank);
    }
}