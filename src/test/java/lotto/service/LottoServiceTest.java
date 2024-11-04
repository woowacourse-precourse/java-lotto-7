package lotto.service;

import lotto.model.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LottoServiceTest {
    private LottoService lottoService;

    @BeforeEach
    public void setUp() {
        lottoService = new LottoService();
    }

    @Test
    @DisplayName("구매한 로또 장수가 올바른지 테스트")
    public void testGenerateLottos_SizeCheck() {
        int purchaseAmount = 5000;
        List<Lotto> lottos = lottoService.generateLottos(purchaseAmount);

        assertEquals(5, lottos.size(), "로또 장수는 5장이어야 합니다.");
    }

    @Test
    @DisplayName("각 로또가 6개의 숫자를 가지는지 테스트")
    public void testLottoNumberCount() {
        List<Lotto> lottos = lottoService.generateLottos(5000);

        for (Lotto lotto : lottos) {
            List<Integer> numbers = lotto.getNumbers();

            assertEquals(6, numbers.size(), "각 로또는 6개의 숫자를 가져야 합니다.");
        }
    }

    @Test
    @DisplayName("각 로또가 1~45의 숫자만을 가지는지 테스트")
    public void testLottoNumberRange() {
        List<Lotto> lottos = lottoService.generateLottos(5000); // 5장 생성

        for (Lotto lotto : lottos) {
            List<Integer> numbers = lotto.getNumbers();

            assertTrue(numbers.stream().allMatch(num -> num >= 1 && num <= 45), "로또 번호는 1~45 사이여야 합니다.");
        }
    }
}
