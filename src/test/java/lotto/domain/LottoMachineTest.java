package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoMachineTest {

    private LottoMachine lottoMachine;

    @BeforeEach
    void setUp() {
        lottoMachine = new LottoMachine(8000); // 8000원을 넣어 8개 티켓 생성 예상
    }

    @Test
    void 로또티켓_생성_개수_확인() {
        List<Lotto> lottos = lottoMachine.generateLottos();
        assertEquals(8, lottos.size());
    }


}
