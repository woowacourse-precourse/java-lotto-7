package lotto.service;

import lotto.model.Lotto;
import org.junit.jupiter.api.BeforeEach;
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
    public void testGenerateLottos_SizeCheck() {
        int purchaseAmount = 5000; // 5장 생성할 수 있는 금액
        List<Lotto> lottos = lottoService.generateLottos(purchaseAmount);

        // 로또 장수가 올바른지 확인
        assertEquals(5, lottos.size(), "로또 장수는 5장이어야 합니다.");
    }

    @Test
    public void testLottoNumberCount() {
        List<Lotto> lottos = lottoService.generateLottos(5000); // 5장 생성

        for (Lotto lotto : lottos) {
            List<Integer> numbers = lotto.getNumbers();

            // 번호 개수 검증
            assertEquals(6, numbers.size(), "각 로또는 6개의 숫자를 가져야 합니다.");
        }
    }

    @Test
    public void testLottoNumberUniqueness() {
        List<Lotto> lottos = lottoService.generateLottos(5000); // 5장 생성

        for (Lotto lotto : lottos) {
            List<Integer> numbers = lotto.getNumbers();

            // 중복 없는지 확인
            assertEquals(6, numbers.stream().distinct().count(), "로또 번호는 중복되지 않아야 합니다.");
        }
    }

    @Test
    public void testLottoNumberRange() {
        List<Lotto> lottos = lottoService.generateLottos(5000); // 5장 생성

        for (Lotto lotto : lottos) {
            List<Integer> numbers = lotto.getNumbers();

            // 범위 검증 (1~45)
            assertTrue(numbers.stream().allMatch(num -> num >= 1 && num <= 45), "로또 번호는 1~45 사이여야 합니다.");
        }
    }
}
