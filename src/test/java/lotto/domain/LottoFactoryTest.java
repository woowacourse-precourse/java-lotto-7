package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import camp.nextstep.edu.missionutils.test.Assertions;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoFactoryTest {

    private LottoFactory lottoFactory = new LottoFactory();

    @DisplayName("입력한 개수만큼 로또를 생성한다.")
    @Test
    void createLottosByCount() {
        Assertions.assertSimpleTest(() -> {
            int count = 5;
            List<Lotto> lottos = lottoFactory.createByCount(count);
            assertEquals(count, lottos.size());
        });
    }
}
