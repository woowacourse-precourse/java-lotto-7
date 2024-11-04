package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import lotto.constant.LottoTestConstant;
import org.junit.jupiter.api.Test;

class WinningLottoTest {

    @Test
    public void 로또_매칭_숫자_탐색_테스트() {
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);
        Lotto testLotto = new Lotto(List.of(1, 2, 3, 10, 11, 12));
        int expectedMatchNumbers = 3;

        assertThat(winningLotto.findMatchNumbers(testLotto))
                .isEqualTo(expectedMatchNumbers);
    }

    @Test
    public void 보너스_숫자_매칭_확인_테스트() {
        int matchBonusNumber = 7;
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), matchBonusNumber);
        Lotto testLotto = new Lotto(List.of(matchBonusNumber, 2, 3, 10, 11, 12));

        assertThat(winningLotto.hasBonusNumber(testLotto))
                .isEqualTo(true);
    }

    @Test
    public void 보너스_숫자_중복_예외_테스트() {
        assertThatIllegalArgumentException().isThrownBy(() -> new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 6))
                .withMessageContaining(LottoTestConstant.ERROR_MESSAGE_HEADER.getMessage());
    }

    @Test
    public void 보너스_숫자_범위_예외_테스트_1() {
        assertThatIllegalArgumentException().isThrownBy(() -> new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 46))
                .withMessageContaining(LottoTestConstant.ERROR_MESSAGE_HEADER.getMessage());
    }

    @Test
    public void 보너스_숫자_범위_예외_테스트_2() {
        assertThatIllegalArgumentException().isThrownBy(() -> new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 0))
                .withMessageContaining(LottoTestConstant.ERROR_MESSAGE_HEADER.getMessage());
    }
}