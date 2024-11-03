package lotto;

import lotto.controller.LottoController;
import lotto.controller.MoneyController;
import lotto.domain.Lotto;
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

    @DisplayName("로또 번호는 1부터 45사이여야 한다.")
    @Test
    void 로또_번호는_범위안에_있어야_한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 60)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @DisplayName("로또 번호를 입력해야 한다.")
    @Test
    void 로또_번호를_입력해야_한다() {
        // given
        String lotto = "";
        LottoController lottoController = new LottoController();

        // when & then
        assertThatThrownBy(() -> {
            lottoController.validateWinningNumbers(lotto);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또를 입력해야 합니다.");
    }

    @DisplayName("로또 번호는 숫자여야 한다.")
    @Test
    void 로또_번호는_숫자여야_한다() {
        // given
        String lotto = "1,49!,13,11,10";
        LottoController lottoController = new LottoController();

        // when & then
        assertThatThrownBy(() -> {
            lottoController.validateWinningNumbers(lotto);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 숫자여야 합니다.");
    }

    @DisplayName("로또 번호와 보너스 번호 중복이면 예외가 발생한다.")
    @Test
    void 로또_번호와_보너스_숫자에_중복된_숫자가_있으면_예외가_발생한다() {
        // given
        List<Integer> lottos = List.of(1, 2, 3, 4, 5, 6);
        String bonus = "6";
        LottoController lottoController = new LottoController();
        // when & then
        assertThatThrownBy(() -> {
            lottoController.validateBonusNumber(lottos, bonus);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 보너스 번호와 중복되지 않아야 한다.");
    }

    @DisplayName("보너스 번호를 입력해야 한다.")
    @Test
    void 보너스_번호를_입력해야_한다() {
        // given
        List<Integer> lottos = List.of(1, 2, 3, 4, 5, 6);
        String bonus = "";
        LottoController lottoController = new LottoController();

        // when & then
        assertThatThrownBy(() -> {
            lottoController.validateBonusNumber(lottos, bonus);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스번호를 입력해야 합니다.");
    }

    @DisplayName("보너스 번호 숫자여야 한다.")
    @Test
    void 보너스_번호는_숫자여야_한다() {
        // given
        List<Integer> lottos = List.of(1, 2, 3, 4, 5, 6);
        String bonus = "6J";
        LottoController lottoController = new LottoController();

        // when & then
        assertThatThrownBy(() -> {
            lottoController.validateBonusNumber(lottos, bonus);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 숫자를 입력해야 합니다.");
    }

    @DisplayName("보너스 번호 1부터 45사이여야 한다.")
    @Test
    void 보너스_번호는_범위안에_있어야_한다() {
        // given
        List<Integer> lottos = List.of(1, 2, 3, 4, 5, 6);
        String bonus = "50";
        LottoController lottoController = new LottoController();

        // when & then
        assertThatThrownBy(() -> {
            lottoController.validateBonusNumber(lottos, bonus);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @DisplayName("돈을 입력해야 합니다.")
    @Test
    void 돈을_입력해야_합니다() {
        String money = "";
        MoneyController moneyController = new MoneyController();
        assertThatThrownBy(() -> {
            moneyController.validateMoneyInput(money);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 돈은 숫자를 입력해야 합니다.");
    }

    @DisplayName("돈은 숫자여야 합니다.")
    @Test
    void 돈은_숫자여야_합니다() {
        String money = "6J";
        MoneyController moneyController = new MoneyController();
        assertThatThrownBy(() -> {
            moneyController.validateMoneyInput(money);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 돈은 숫자를 입력해야 합니다.");
    }

    @DisplayName("돈은 1000원단위로 입력해야 합니다.")
    @Test
    void 돈은_1000원단위로_입력해야_합니다() {
        String money = "2600";
        MoneyController moneyController = new MoneyController();
        assertThatThrownBy(() -> {
            moneyController.validateMoneyInput(money);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 1000원 단위로 입력하셔야 합니다.");
    }
}
