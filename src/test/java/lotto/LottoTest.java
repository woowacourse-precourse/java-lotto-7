package lotto;

import lotto.Controller.PurchaseController;
import lotto.Controller.WinningController;
import lotto.Service.WinningService;
import lotto.View.PurchaseView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
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

    //로또 구매 금액 입력 부분
    @DisplayName("로또 구매 금액이 음수인 경우 예외가 발생한다.")
    @Test
    void 로또_구매_금액이_음수인_경우_예외가_발생한다() {
        PurchaseController purchaseController = new PurchaseController();
        assertThatThrownBy(() -> purchaseController.purchaseFlowWithInput("-5000"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구매 금액이 1,000원 단위로 나누어 떨어지지 않는 경우 예외가 발생한다.")
    @Test
    void 로또_구매_금액이_1000_원_단위로_나누어_떨어지지_않는_경우_예외가_발생한다() {
        PurchaseController purchaseController = new PurchaseController();
        assertThatThrownBy(() -> purchaseController.purchaseFlowWithInput("8500"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    //당첨 번호 입력 부분
    @DisplayName("당첨 번호에 중복된 숫자가 있는 경우 예외가 발생한다.")
    @Test
    void 당첨_번호에_중복된_숫자가_있는_경우_예외가_발생한다() {
        WinningController winningController = new WinningController();
        assertThatThrownBy(() -> winningController.validateWinningInput("1,1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("당첨 번호는 주어진 범위 내에서 입력되어야 한다.")
    @Test
    void 당첨_번호는_주어진_범위_내에서_입력되어야_한다() {
        WinningController winningController = new WinningController();
        assertThatThrownBy(()-> winningController.validateWinningInput("1,2,3,4,5,-10"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    //보너스 번호 입력 부분
    @DisplayName("당첨 번호와 중복된 숫자가 입력된 경우 예외가 발생한다.")
    @Test
    void 당첨_번호와_중복된_숫자가_입력된_경우_예외가_발생한다() {
        WinningController winningController = new WinningController();
        List<Integer> tempWinningNumbers = new ArrayList<>();
        tempWinningNumbers.add(1);
        tempWinningNumbers.add(2);
        tempWinningNumbers.add(3);
        tempWinningNumbers.add(4);
        tempWinningNumbers.add(5);
        tempWinningNumbers.add(6);

        assertThatThrownBy(() -> winningController.validateBonusInput("1", tempWinningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호도 주어진 번호의 범위 내에서 입력되어야 한다.")
    @Test
    void 보너스_번호도_주어진_번호의_범위_내에서_입력되어야_한다() {
        WinningController winningController = new WinningController();
        List<Integer> tempWinningNumbers = new ArrayList<>();
        tempWinningNumbers.add(1);
        tempWinningNumbers.add(2);
        tempWinningNumbers.add(3);
        tempWinningNumbers.add(4);
        tempWinningNumbers.add(5);
        tempWinningNumbers.add(6);

        assertThatThrownBy(() -> winningController.validateBonusInput("100", tempWinningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    //통계 부분
    @DisplayName("맞춘 개수에 맞게 순위를 입력해주어야 한다.")
    @Test
    void 맞춘_개수에_맞게_순위를_입력해주어야_한다() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 7)));
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 8)));
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 8, 9)));
        lottos.add(new Lotto(List.of(1, 2, 3, 8, 9, 10)));
        lottos.add(new Lotto(List.of(1, 2, 8, 9, 10, 11)));
        lottos.add(new Lotto(List.of(1, 8, 9, 10, 11, 12)));
        lottos.add(new Lotto(List.of(8, 9, 10, 11, 12, 13)));
        WinningService winningService = new WinningService();
        List<LottoResult> results = winningService.getResultbyEnum(lottos, new ArrayList<Integer>(List.of(1,2,3,4,5,6)), 7);

        List<LottoResult> expected = List.of(LottoResult.ONE, LottoResult.TWO, LottoResult.THREE, LottoResult.FOUR, LottoResult.FIVE, LottoResult.NONE, LottoResult.NONE, LottoResult.NONE);
        assertThat(results).isEqualTo(expected);
    }
}
