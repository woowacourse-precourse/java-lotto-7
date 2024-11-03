package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import lotto.domain.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoServiceTest {

    private LottoService lottoService;

    @BeforeEach
    void setUp() {
        lottoService = new LottoService();
    }

    @Test
    void 문자열을_로또_숫자_리스트로_변환() {
        String input = "1, 2, 3, 4, 5, 6";
        List<Integer> result = lottoService.generateLotto(input);

        assertThat(result).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    void 문자열에_잘못된_숫자가_포함된_경우_예외_발생() {
        String input = "1, 2, abc, 4, 5, 6";

        assertThrows(NumberFormatException.class, () -> {
            lottoService.generateLotto(input);
        });
    }

    @Test
    void 지정된_수의_로또_구매() {
        int numberOfLottos = 3;
        List<Lotto> purchasedLottos = lottoService.purchaseLotto(numberOfLottos);

        assertThat(purchasedLottos).hasSize(numberOfLottos);
        for (Lotto lotto : purchasedLottos) {
            assertThat(lotto.getLotto()).hasSize(6);
            assertThat(lotto.getLotto()).allMatch(num -> num >= 1 && num <= 45);
        }
    }
}
