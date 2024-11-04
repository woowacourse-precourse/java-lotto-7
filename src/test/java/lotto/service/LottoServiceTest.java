package lotto.service;

import lotto.model.Lotto;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoServiceTest {

    private final LottoService lottoService = new LottoService();

    @Test
    void 구매금액에_따른_로또_개수_확인() {
        int amount = 5000; // 총 금액
        int expectedCount = amount / 1000; // 예상 로또 개수

        List<Lotto> lottos = lottoService.purchase(amount);

        assertEquals(expectedCount, lottos.size(), "입력한 금액에 따라 올바른 수의 로또가 생성되어야 합니다.");
    }

    @Test
    void 구매금액이_0원일_경우_로또_생성되지_않음() {
        int amount = 0;

        List<Lotto> lottos = lottoService.purchase(amount);

        // 금액이 0원일 경우, 생성된 로또는 없음을 확인
        assertEquals(0, lottos.size(), "구매 금액이 0원이면 로또가 생성되지 않아야 합니다.");
    }

    @Test
    void 구매금액이_부족할_경우_로또_생성되지_않음() {
        int amount = 500; // 로또 가격보다 낮은 금액

        List<Lotto> lottos = lottoService.purchase(amount);

        // 금액이 부족하여 로또가 생성되지 않는지 확인
        assertEquals(0, lottos.size(), "로또 한 장의 가격보다 낮은 금액으로는 로또가 생성되지 않아야 합니다.");
    }

    @Test
    void 로또_개수_확인() {
        // 로또 5개 생성 요청
        int count = 5;
        List<Lotto> lottos = lottoService.create(count);

        // 생성된 로또의 개수가 요청한 개수와 동일한지 확인
        assertEquals(count, lottos.size(), "요청한 개수만큼 로또가 생성되어야 합니다.");
    }

    @Test
    void 로또_번호_유효성_확인() {
        // 로또 1개 생성 요청
        List<Lotto> lottos = lottoService.create(1);
        Lotto lotto = lottos.get(0);

        // 로또 번호가 6개인지 확인
        assertEquals(6, lotto.getNumbers().size(), "로또는 6개의 숫자로 구성되어야 합니다.");

        // 로또 번호가 중복되지 않음을 확인
        assertEquals(6, new HashSet<>(lotto.getNumbers()).size(), "로또 번호는 중복되지 않아야 합니다.");

        // 각 번호가 1~45 범위 내에 있는지 확인
        assertTrue(lotto.getNumbers().stream().allMatch(num -> num >= 1 && num <= 45),
                "로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }
}
