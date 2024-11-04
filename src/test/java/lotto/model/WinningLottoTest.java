package lotto.model;

import lotto.model.lotto.BonusNumber;
import lotto.model.lotto.Lotto;
import lotto.model.lotto.WinningLotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.exception.LottoException;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningLottoTest {
    private Lotto lotto;
    private BonusNumber bonusNumber;
    private WinningLotto winningLotto;

    @BeforeEach
    public void setUp() {
        lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        bonusNumber = new BonusNumber(7);
        winningLotto = WinningLotto.createWinningLotto(lotto, bonusNumber);
    }

    @Test
    @DisplayName("당첨 번호와 보너스 번호는 중복된 숫자가 있으면 안된다")
    public void 당첨로또_형식_테스트() {
        Lotto testLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber testBonusNumber = new BonusNumber(1);

        assertThatThrownBy(() -> WinningLotto.createWinningLotto(testLotto, testBonusNumber))
                .isInstanceOf(LottoException.class);
    }

    @Test
    @DisplayName("당첨 로또에서 구매한 로또의 번호 개수를 구한다")
    public void 당첨로또_일치번호_개수_테스트() {
        Lotto purchasedLotto = new Lotto(List.of(1, 2, 3, 11, 22, 33));

        int matchCount = winningLotto.countMatchNumbers(purchasedLotto);

        assertThat(matchCount).isEqualTo(3);
    }

    @Test
    @DisplayName("당첨 로또에서 보너스 번호의 일치 여부를 판단한다")
    public void 당첨로또_보너스번호_일치여부_테스트() {
        Lotto purchasedLotto = new Lotto(List.of(1, 2, 3, 7, 11, 22));

        boolean matchBonusNumber = winningLotto.isMatchBonusNumber(purchasedLotto);

        assertThat(matchBonusNumber).isTrue();
    }
}
