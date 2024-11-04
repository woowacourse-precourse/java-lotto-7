package lotto;

import lotto.model.Lotto;
import lotto.model.LottoMachine;
import lotto.exception.InvalidBonusNumberException;
import lotto.exception.InvalidLottoNumberException;
import lotto.exception.InvalidPurchaseAmountException;
import lotto.exception.LottoNotPurchasedException;
import lotto.exception.UninitializedWinningNumbersException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

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

    // TODO: 추가 기능 구현에 따른 테스트 코드 작성
    @Test
    @DisplayName("로또 번호가 6개보다 적으면 예외가 발생한다.")
    void 로또_번호가_6개_미만이면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 6개여야 합니다.");
    }

    @Test
    @DisplayName("로또 번호에 1~45를 벗어난 숫자가 있으면 예외가 발생한다.")
    void 로또_번호에_범위를_벗어난_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 1부터 45 사이여야 합니다.");

        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 1부터 45 사이여야 합니다.");
    }

    @Test
    @DisplayName("로또 번호가 1부터 45 사이의 중복되지 않은 6개의 숫자일 때 객체가 정상적으로 생성된다.")
    void 유효한_로또_번호로_객체_생성() {
        new Lotto(List.of(1, 2, 3, 4, 5, 6));
    }

    @Test
    @DisplayName("로또 번호가 음수를 포함하면 예외가 발생한다.")
    void 로또_번호에_음수가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(-1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 1부터 45 사이여야 합니다.");
    }

    @Test
    @DisplayName("로또 번호 리스트가 비어 있으면 예외가 발생한다.")
    void 로또_번호가_비어_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 6개여야 합니다.");
    }

    private final LottoMachine lottoMachine = new LottoMachine();

    @Test
    @DisplayName("구입 금액이 1,000원보다 작을 경우 예외가 발생한다.")
    void 구입_금액이_1000원_미만일_경우_예외() {
        assertThatThrownBy(() -> lottoMachine.purchaseLottos(String.valueOf(500)))
                .isInstanceOf(InvalidPurchaseAmountException.class)
                .hasMessageContaining("[ERROR] 구입 금액이 충분하지 않거나 1,000원 단위가 아닙니다.");
    }

    @Test
    @DisplayName("입력 금액이 1,000원 단위로 나누어 떨어지지 않을 경우 예외가 발생한다.")
    void 구입_금액이_1000원_단위가_아닐_경우_예외() {
        assertThatThrownBy(() -> lottoMachine.purchaseLottos(String.valueOf(1500)))
                .isInstanceOf(InvalidPurchaseAmountException.class)
                .hasMessageContaining("[ERROR] 구입 금액이 충분하지 않거나 1,000원 단위가 아닙니다");
    }

    @Test
    @DisplayName("보너스 번호가 1~45의 범위를 벗어날 경우 예외가 발생한다.")
    void 보너스_번호가_범위를_벗어날_경우_예외() {
        assertThatThrownBy(() -> lottoMachine.validateBonusNumber(String.valueOf(50)))
                .isInstanceOf(InvalidBonusNumberException.class)
                .hasMessageContaining("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @Test
    @DisplayName("보너스 번호가 당첨 번호와 중복될 경우 예외가 발생한다.")
    void 보너스_번호가_당첨_번호와_중복될_경우_예외() {
        lottoMachine.validateWinningNumbers("1,2,3,4,5,6");
        assertThatThrownBy(() -> lottoMachine.validateBonusNumber(String.valueOf(6)))
                .isInstanceOf(InvalidBonusNumberException.class)
                .hasMessageContaining("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
    }

    @Test
    @DisplayName("로또가 구매되지 않은 상태에서 수익률 계산을 시도할 경우 예외가 발생한다.")
    void 로또_미구매_상태에서_수익률_계산_시도시_예외() {
        int totalSpent = 10000;  // 테스트에 사용할 총 구입 금액
        assertThatThrownBy(() -> lottoMachine.calculateYield(totalSpent))
                .isInstanceOf(LottoNotPurchasedException.class)
                .hasMessageContaining("[ERROR] 로또가 발행되지 않은 상태에서는 수익률을 계산할 수 없습니다.");
    }

    @Test
    @DisplayName("구입 금액이 숫자가 아닐 경우 예외가 발생한다.")
    void 구입_금액이_숫자가_아닌_경우_예외() {
        assertThatThrownBy(() -> lottoMachine.purchaseLottos("일천원"))
                .isInstanceOf(InvalidPurchaseAmountException.class)
                .hasMessageContaining("[ERROR] 구입 금액은 숫자로 입력해야 합니다.");
    }

    @Test
    @DisplayName("당첨 번호에 숫자가 아닌 값이 포함될 경우 예외가 발생한다.")
    void 당첨_번호에_숫자가_아닌_값이_있으면_예외() {
        assertThatThrownBy(() -> lottoMachine.validateWinningNumbers("1,2,세,4,5,6"))
                .isInstanceOf(InvalidLottoNumberException.class)
                .hasMessageContaining("[ERROR] 당첨 번호는 숫자로 입력해야 합니다.");
    }

    @Test
    @DisplayName("당첨 번호의 개수가 6개가 아닌 경우 예외가 발생한다.")
    void 당첨_번호가_6개가_아니면_예외() {
        assertThatThrownBy(() -> lottoMachine.validateWinningNumbers("1,2,3,4,5"))
                .isInstanceOf(InvalidLottoNumberException.class)
                .hasMessageContaining("[ERROR] 당첨 번호는 6개의 숫자로 입력해야 합니다.");
    }

    @Test
    @DisplayName("보너스 번호가 숫자가 아닌 경우 예외가 발생한다.")
    void 보너스_번호가_숫자가_아니면_예외() {
        lottoMachine.validateWinningNumbers("1,2,3,4,5,6");
        assertThatThrownBy(() -> lottoMachine.validateBonusNumber("일곱"))
                .isInstanceOf(InvalidBonusNumberException.class)
                .hasMessageContaining("[ERROR] 보너스 번호는 숫자로 입력해야 합니다.");
    }

}