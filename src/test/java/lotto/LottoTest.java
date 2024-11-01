package lotto;

import lotto.controller.GeneratorLotto;
import lotto.controller.InputValidator;
import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    private final InputValidator validator = new InputValidator();

    private GeneratorLotto generatorLotto;
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
    @DisplayName("구입 금액에 음수가 들어오면 예외가 발생한다.")
    void 구입_금액에_음수가_들어오면_예외가_발생한다() {
        assertThatThrownBy(() -> validator.validatePurchaseAmount(-5000))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 구입 금액이 음수이면 안됩니다.");
    }

    @Test
    @DisplayName("구입 금액이 1000원 단위가 아니라면 예외가 발생한다.")
    void 구입_금액이_1000원_단위가_아니라면_예외가_발생한다() {
        assertThatThrownBy(() -> validator.validatePurchaseAmount(1500))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 구입 금액은 1000원 단위로 입력해야 합니다.");
    }

    @Test
    @DisplayName("로또 번호의 숫자의 범위가 넘어가면 예외가 발생한다.")
    void 로또_번호의_숫자_범위가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @Test
    @DisplayName("로또 보너스 번호의 숫자의 범위가 넘어가면 예외가 발생한다.")
    void 로또_보너스_번호의_숫자_범위가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 번호는 1부터 45 사이의 숫자여야 합니다.");
    }
    @Test
    void 구입_금액에_따른_로또_생성_개수_테스트() {
        int purchaseAmount = 8000;
        int expectedLottoCount = purchaseAmount / 1000;

        List<Lotto> generatedLottos = GeneratorLotto.createLotto(purchaseAmount);

        assertThat(generatedLottos.size()).isEqualTo(expectedLottoCount);
    }
}
