package lotto;

import lotto.Controller.LottoController;
import lotto.Controller.MoneyController;
import lotto.Model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

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
    @DisplayName("당첨 번호는 1부터 45사이여야 한다.")
    @Test
    void 당첨_번호는_범위안에_있어야_한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 60)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨 번호는 1이상 45이하여야 합니다.");
    }

    @DisplayName("당첨 번호를 입력해야 한다.")
    @Test
    void 당첨_번호를_입력해야_한다() {
        String lotto = "";
        LottoController lottoController = new LottoController();

        assertThatThrownBy(() -> {
            lottoController.NumberValidation(lotto);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨 번호를 입력해야 합니다.");
    }

    @DisplayName("당첨 번호는 숫자여야 한다.")
    @Test
    void 당첨_번호는_숫자여야_한다() {
        String lotto = "1,2,3,4,5,6A";
        LottoController lottoController = new LottoController();

        assertThatThrownBy(() -> {
            lottoController.NumberValidation(lotto);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨 번호는 숫자를 입력해야 합니다.");
    }

    @DisplayName("당첨 번호와 보너스 번호는 중복되지 않아야 한다.")
    @Test
    void 당첨_번호와_보너스_번호는_중복되지_않아야_한다() {
        List<Integer> lottos = List.of(1, 2, 3, 4, 5, 6);
        String bonus = "6";
        LottoController lottoController = new LottoController();
        assertThatThrownBy(() -> {
            lottoController.BonusValidation(lottos, bonus);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨 번호와 보너스 번호는 중복되지 않아야 합니다.");
    }

    @DisplayName("보너스 번호를 입력해야 한다.")
    @Test
    void 보너스_번호를_입력해야_한다() {
        List<Integer> lottos = List.of(1, 2, 3, 4, 5, 6);
        String bonus = "";
        LottoController lottoController = new LottoController();

        assertThatThrownBy(() -> {
            lottoController.BonusValidation(lottos, bonus);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호를 입력해야 합니다.");
    }

    @DisplayName("보너스 번호는 숫자여야 한다.")
    @Test
    void 보너스_번호는_숫자여야_한다() {
        List<Integer> lottos = List.of(1, 2, 3, 4, 5, 6);
        String bonus = "6A";
        LottoController lottoController = new LottoController();

        assertThatThrownBy(() -> {
            lottoController.BonusValidation(lottos, bonus);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 숫자를 입력해야 합니다.");
    }

    @DisplayName("보너스 번호는 1이상 45이하여야 한다.")
    @Test
    void 보너스_번호는_범위_안에_있어야_한다() {
        List<Integer> lottos = List.of(1, 2, 3, 4, 5, 6);
        String bonus = "50";
        LottoController lottoController = new LottoController();

        assertThatThrownBy(() -> {
            lottoController.BonusValidation(lottos, bonus);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 1이상 45이하여야 합니다.");
    }

    @DisplayName("구매 금액을 입력해야 한다.")
    @Test
    void 구매_금액을_입력해야_한다() {
        String money = "";
        MoneyController moneyController = new MoneyController();
        assertThatThrownBy(() -> {
            moneyController.MoneyValidation(money);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구매 금액을 입력해야 합니다.");
    }

    @DisplayName("구매 금액은 숫자여야 한다.")
    @Test
    void 구매_금액은_숫자여야_한다() {
        String money = "6A";
        MoneyController moneyController = new MoneyController();
        assertThatThrownBy(() -> {
            moneyController.MoneyValidation(money);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구매 금액은 숫자를 입력해야 합니다.");
    }

    @DisplayName("구매 금액은 1000원 단위로 입력해야 한다.")
    @Test
    void 구매_금액은_1000원_단위로_입력해야_한다() {
        String money = "1500";
        MoneyController moneyController = new MoneyController();
        assertThatThrownBy(() -> {
            moneyController.MoneyValidation(money);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구매 금액은 1000원 단위로 입력해야 합니다.");
    }
}
