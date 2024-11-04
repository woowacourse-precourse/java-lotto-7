package lotto;

import static validation.Validate.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스_번호가_1보다_작거나_45보다_크면_예외가_발생한다() {
        assertThatThrownBy(() -> checkBonusNumberRange(46))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호는 1~45 사이여야 합니다.");
    }

    @Test
    void 로또_번호가_1보다_작거나_45보다_크면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 1~45 사이여야 합니다.");
    }

    @Test
    void 로또_발급_테스트() {
        LottoGame lottoGame = new LottoGame();
        assertSimpleTest(() -> lottoGame.lottoIssuance(5));
    }

    @Test
    void 입력한_값이_양수가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> checkPositiveNumber("-1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 입력한 값은 숫자(양수)여야 합니다.");
    }

    @Test
    void 구매_금액이_1_000원_단위가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> checkUnitOfPurchaseAmount(500))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 구입 금액은 1,000원 단위여야 합니다.");
    }

    @Test
    void 구매_금액이_100_000원을_초과하면_예외가_발생한다() {
        assertThatThrownBy(() -> checkPurchasedAmountExceeded(100001))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 구입 금액은 1인당 100,000원을 넘길 수 없습니다.");
    }
}
