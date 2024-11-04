package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
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
    void 로또_번호가_범위_밖에_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 55)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 로또 구입 금액 입력 테스트
    @Test
    void 구입_금액이_1000원_단위가_아니면_예외가_발생한다() {
        LottoService lottoService = new LottoService();
        assertThatThrownBy(() -> lottoService.validateAmountForTest(3500))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 구입금액은 1,000원 단위여야 합니다.");
    }

    @Test
    void 구입_금액이_1000원_단위면_정상_동작한다() {
        LottoService lottoService = new LottoService();
        lottoService.validateAmountForTest(3000); // 예외 발생하지 않음
    }

    @Test
    void 정상적인_로또_번호_입력() {
        LottoService lottoService = new LottoService();
        Lotto lotto = lottoService.win_number("1, 2, 3, 4, 5, 6");
        assertThat(lotto).isNotNull();
    }

    @Test
    void 유효한_보너스_번호_입력() {
        LottoService lottoService = new LottoService(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        int bonusNumber = lottoService.bonus("7");
        assertThat(bonusNumber).isEqualTo(7); // 정상적인 보너스 번호 입력
    }

    @Test
    void 중복된_보너스_번호_입력시_예외가_발생한다() {
        LottoService lottoService = new LottoService(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        assertThatThrownBy(() -> lottoService.bonus("5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 중복되는 로또 번호입니다.");
    }

    @Test
    void 잘못된_보너스_번호_범위_입력시_예외가_발생한다() {
        LottoService lottoService = new LottoService(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        assertThatThrownBy(() -> lottoService.bonus("50"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 1에서 45 사이의 값이어야 합니다.");
    }

    @Test
    void 숫자가_아닌_보너스_번호_입력시_예외가_발생한다() {
        LottoService lottoService = new LottoService(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        assertThatThrownBy(() -> lottoService.bonus("abc"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호는 숫자입니다.");
    }

}
