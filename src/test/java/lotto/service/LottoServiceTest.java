package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.List;
import lotto.common.LottoConstants;
import lotto.domain.lotto.LottoDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoServiceTest {
    private LottoService lottoService;

    @BeforeEach
    void beforeEach() {
        lottoService = new LottoServiceImpl();
    }

    @Test
    @DisplayName("로또 번호 생성 테스트")
    void 로또_번호_생성_테스트() {
        //given
        String amount = " 80 00 ";

        //when
        lottoService.buyLotto(amount);
        List<LottoDto> purchasedLottos = lottoService.getPurchaseDto().getLottoDtos();

        //then
        assertThat(purchasedLottos.size()).isEqualTo(8);
        for (LottoDto lotto : purchasedLottos) {
            List<Integer> numbers = lotto.getNumbers();
            assertThat(numbers.size()).isEqualTo(LottoConstants.NUMBERS_COUNT);
            assertThat(numbers.stream()
                    .allMatch(number -> number >= LottoConstants.MIN_NUMBER
                            && number <= LottoConstants.MAX_NUMBER)).isTrue();
        }
    }

    @Test
    @DisplayName("정상적인 로또 번호 입력 테스트")
    void 정상적인_로또_번호_입력_테스트() {
        //given
        String numbers1 = "1,2,3,4,5,6";
        String numbers2 = " 1, 2, 3,, 4, 5, 6";

        //when
        lottoService.assignWinningLotto(numbers1);
        List<Integer> winningNumbers1 = lottoService.getWinningLottoDto().getNumbers();
        lottoService.assignWinningLotto(numbers2);
        List<Integer> winningNumbers2 = lottoService.getWinningLottoDto().getNumbers();

        //then
        assertThat(winningNumbers1.size()).isEqualTo(6);
        assertThat(winningNumbers2.size()).isEqualTo(6);
        assertThat(winningNumbers1).containsExactly(1, 2, 3, 4, 5, 6);
        assertThat(winningNumbers2).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    @DisplayName("중복되는 로또 번호 입력 테스트")
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatIllegalArgumentException().isThrownBy(() -> lottoService.assignWinningLotto("1, 2, 3, 4, 5, 5"))
                .withMessage("[ERROR] 로또 번호는 중복되면 안됩니다.");
    }

    @Test
    @DisplayName("정수가 아닌 로또 번호 입력 테스트")
    void 정수가_아닌_로또_번호가_입력된_경우_예외를_발생시킨다() {
        assertThatIllegalArgumentException().isThrownBy(() -> lottoService.assignWinningLotto("1, 2, 3, 4.4, 5, 6"))
                .withMessage("[ERROR] 정수를 입력해주세요.");

        assertThatIllegalArgumentException().isThrownBy(() -> lottoService.assignWinningLotto("1, 2, 3, a, 5, 6"))
                .withMessage("[ERROR] 정수를 입력해주세요.");
    }

    @Test
    @DisplayName("정상적인 금액 입력 테스트")
    void 정상적인_금액_입력_테스트() {
        //given
        String amount1 = "1000";
        String amount2 = "100000";
        String amount3 = " 20 00 ";

        //when
        lottoService.buyLotto(amount1);
        int purchasedAmount1 = lottoService.getPurchaseDto().getAmount();
        lottoService.buyLotto(amount2);
        int purchasedAmount2 = lottoService.getPurchaseDto().getAmount();
        lottoService.buyLotto(amount3);
        int purchasedAmount3 = lottoService.getPurchaseDto().getAmount();

        //then
        assertThat(purchasedAmount1).isEqualTo(1000);
        assertThat(purchasedAmount2).isEqualTo(100000);
        assertThat(purchasedAmount3).isEqualTo(2000);
    }

    @Test
    @DisplayName("정수가 아닌 금액 입력 테스트")
    void 정수가_아닌_금액이_입력된_경우_예외를_발생시킨다() {
        assertThatIllegalArgumentException().isThrownBy(() -> lottoService.buyLotto("1,000"))
                .withMessage("[ERROR] 정수를 입력해주세요.");

        assertThatIllegalArgumentException().isThrownBy(() -> lottoService.buyLotto("1000.3"))
                .withMessage("[ERROR] 정수를 입력해주세요.");

        assertThatIllegalArgumentException().isThrownBy(() -> lottoService.buyLotto(""))
                .withMessage("[ERROR] 정수를 입력해주세요.");

        assertThatIllegalArgumentException().isThrownBy(() -> lottoService.buyLotto(null))
                .withMessage("[ERROR] 정수를 입력해주세요.");
    }
}