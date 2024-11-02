package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import java.util.Arrays;
import java.util.List;
import lotto.common.LottoRank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WinningLottoTest {

    private Lotto winningLottoWithoutBonusNumber;

    @BeforeEach
    void setUp() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        this.winningLottoWithoutBonusNumber = Lotto.create(winningNumbers);
    }

    @Test
    void testWinningLottoCreation_validInput() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        WinningLotto winningLotto = new WinningLotto(this.winningLottoWithoutBonusNumber, bonusNumber);

        assertThat(winningLotto).isNotNull();
    }

    @Test
    void testWinningLottoCreation_bonusNumberOutOfRange() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 46;

        assertSoftly(softly -> {
            softly.assertThatThrownBy(() -> new WinningLotto(this.winningLottoWithoutBonusNumber, bonusNumber))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        });
    }

    @Test
    void testWinningLottoCreation_bonusNumberZero() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 0;

        assertSoftly(softly -> {
            softly.assertThatThrownBy(() -> new WinningLotto(this.winningLottoWithoutBonusNumber, bonusNumber))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        });
    }

    @Test
    void testWinningLottoCreation_bonusNumberDuplicated() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 6;

        assertSoftly(softly -> {
            softly.assertThatThrownBy(() -> new WinningLotto(this.winningLottoWithoutBonusNumber, bonusNumber))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        });
    }

    @Test
    void testDetermineRank() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        WinningLotto winningLotto = new WinningLotto(this.winningLottoWithoutBonusNumber, bonusNumber);

        Lotto firstTicket = Lotto.create(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto secondTicket = Lotto.create(Arrays.asList(1, 2, 3, 4, 5, 7));
        Lotto thirdTicket = Lotto.create(Arrays.asList(1, 2, 3, 4, 5, 8));
        Lotto fourthTicket = Lotto.create(Arrays.asList(1, 2, 3, 4, 10, 8));
        Lotto fifthTicket = Lotto.create(Arrays.asList(1, 2, 3, 11, 10, 8));
        Lotto noneTicket = Lotto.create(Arrays.asList(10, 11, 12, 13, 14, 15));

        assertSoftly(softly -> {
            softly.assertThat(winningLotto.determineRank(firstTicket))
                    .isEqualTo(LottoRank.FIRST);
            softly.assertThat(winningLotto.determineRank(secondTicket))
                    .isEqualTo(LottoRank.SECOND);
            softly.assertThat(winningLotto.determineRank(thirdTicket))
                    .isEqualTo(LottoRank.THIRD);
            softly.assertThat(winningLotto.determineRank(fourthTicket))
                    .isEqualTo(LottoRank.FOURTH);
            softly.assertThat(winningLotto.determineRank(fifthTicket))
                    .isEqualTo(LottoRank.FIFTH);
            softly.assertThat(winningLotto.determineRank(noneTicket))
                    .isEqualTo(LottoRank.NONE);
        });
    }
}