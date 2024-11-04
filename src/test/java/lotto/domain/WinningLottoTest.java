package lotto.domain;

import java.util.Arrays;
import lotto.wrapper.BonusNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class WinningLottoTest {

    private Lotto winningNumbers;
    private BonusNumber bonusNumber;

    @BeforeEach
    void setUp() {
        winningNumbers = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        bonusNumber = BonusNumber.of(7);
    }

    @DisplayName("주어진 로또 번호와 비교하여 Rank를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {
            "1,2,3,4,5,6:SIX_MATCHES",
            "1,2,3,4,5,7:FIVE_MATCHES_WITH_BONUS",
            "1,2,3,40,41,42:THREE_MATCHES"},
            delimiter = ':')
    void 당첨번호와_보너스번호_생성_테스트(String lottoNumbers, String expectedRank) {
        Lotto lotto = new Lotto(Arrays.stream(lottoNumbers.split(","))
                .map(Integer::parseInt)
                .toList());
        WinningLotto winningLotto = WinningLotto.of(winningNumbers, bonusNumber);

        Rank rank = winningLotto.determineRank(lotto);

        Assertions.assertThat(rank.toString()).isEqualTo(expectedRank);
    }

}
