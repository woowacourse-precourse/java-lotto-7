package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Controller.PurchaseController;
import lotto.Controller.WinningController;
import lotto.Service.PurchaseService;
import lotto.Service.WinningService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 기능_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("8000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "8개를 구매했습니다.",
                            "[8, 21, 23, 41, 42, 43]",
                            "[3, 5, 11, 16, 32, 38]",
                            "[7, 11, 16, 35, 36, 44]",
                            "[1, 8, 11, 31, 41, 42]",
                            "[13, 14, 16, 38, 42, 45]",
                            "[7, 11, 30, 40, 42, 43]",
                            "[2, 13, 22, 32, 38, 45]",
                            "[1, 3, 5, 14, 22, 45]",
                            "3개 일치 (5,000원) - 1개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 62.5%입니다."
                    );
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42),
                List.of(13, 14, 16, 38, 42, 45),
                List.of(7, 11, 30, 40, 42, 43),
                List.of(2, 13, 22, 32, 38, 45),
                List.of(1, 3, 5, 14, 22, 45)
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() -> {
            runException("1000j");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
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

    //구매 부분
    @DisplayName("입력된 구매 금액에 맞게 로또를 구매해야한다")
    @Test
    void 입력된_구매_금액에_맞게_로또를_구매해야한다() {
        PurchaseService purchaseService = new PurchaseService();
        int exact = purchaseService.buy(5000);
        int expected = 5;
        assertThat(exact).isEqualTo(expected);
    }

    @DisplayName("로또는 올림차순으로 정렬되어야 한다.")
    @Test
    void 로또는_올림차순으로_정렬되어야_한다() {
        PurchaseService purchaseService = new PurchaseService();
        int count = 5;
        List<Lotto> exactlottos = purchaseService.draw(count);
        for(int i = 0; i < count; i++) {
            assertThat(exactlottos.get(i).getNumbers())
                    .isSorted();
        }
    }
    //당첨 번호 입력 부분
    @DisplayName("당첨 번호가 6개를 넘거나 6개 안되게 입력된 경우 예외가 발생한다.")
    @Test
    void 당첨_번호가_6개를_넘거나_6개_안되게_입력된_경우_예외가_발생한다() {
        WinningController winningController = new WinningController();
        assertThatThrownBy(() -> winningController.validateWinningInput("1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

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

    @DisplayName("수익률을 정확히 계산하여야 한다.")
    @Test
    void 수익률을_정확히_계산하여야_한다() {
        WinningService winningService = new WinningService();
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 7)));
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 8)));
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 8, 9)));
        lottos.add(new Lotto(List.of(1, 2, 3, 8, 9, 10)));
        lottos.add(new Lotto(List.of(1, 2, 8, 9, 10, 11)));
        lottos.add(new Lotto(List.of(1, 8, 9, 10, 11, 12)));
        lottos.add(new Lotto(List.of(8, 9, 10, 11, 12, 13)));
        int[] exactsforWin = winningService.getResult(lottos, new ArrayList<Integer>(List.of(1,2,3,4,5,6)), 7);
        double exact = winningService.getReturnRate(exactsforWin, 8);

        double expected = 0;
        expected += exactsforWin[0]*2000000000;
        expected += exactsforWin[1]*30000000;
        expected += exactsforWin[2]*1500000;
        expected += exactsforWin[3]*50000;
        expected += exactsforWin[4]*5000;
        expected = Math.round((expected / 8000) * 1000)/10.0;
        System.out.println(expected);

        assertThat(exact).isEqualTo(expected);
    }
}
