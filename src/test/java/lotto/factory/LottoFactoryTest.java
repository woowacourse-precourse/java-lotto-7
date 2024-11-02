package lotto.factory;

import lotto.model.Lotto;
import org.junit.jupiter.api.Test;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LottoFactoryTest {

    @Test
    void 로또_개수_확인() {
        // 로또 5개 생성 요청
        int count = 5;
        List<Lotto> lottos = LottoFactory.create(count);

        // 생성된 로또의 개수가 요청한 개수와 동일한지 확인
        assertEquals(count, lottos.size(), "요청한 개수만큼 로또가 생성되어야 합니다.");
    }

    @Test
    void 로또_번호_유효성_확인() {
        // 로또 1개 생성 요청
        List<Lotto> lottos = LottoFactory.create(1);
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
