package lotto.service.issuing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.strategy.number.LottoNumberGeneratorStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

// LottoIssuingServiceImpl에 대한 단위 테스트
public class LottoIssuingServiceImplTest {

    @Test
    @DisplayName("로또 티켓 발행 테스트")
    void issueLottosTest() {
        // 로또 번호 생성 전략 임시 구현
        LottoNumberGeneratorStrategy mockStrategy = () -> List.of(1, 2, 3, 4, 5, 6);
        LottoIssuingServiceImpl service = new LottoIssuingServiceImpl(mockStrategy);

        // 구매 개수가 3일 때, 로또 티켓 3장을 발행
        Lottos lottos = service.issueLottos(3);

        assertNotNull(lottos);

        // Lottos의 로또 티켓 수를 검증 (get 메소드가 없으므로 빈 리스트를 만든 후 로또를 추가하여 개수 비교)
        List<Lotto> issuedLottos = new ArrayList<>();
        lottos.forEachLotto(issuedLottos::add); // forEachLotto 메서드를 이용해 로또 리스트를 생성

        assertEquals(3, issuedLottos.size());

        for (Lotto lotto : issuedLottos) {
            assertNotNull(lotto);
        }
    }
}
