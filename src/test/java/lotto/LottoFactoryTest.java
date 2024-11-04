package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class LottoFactoryTest {
    @Test
    void 로또가_1000원에_한장이라_할때_지불한_금액만큼의_로또가_생성돼야_한다() {
        LottoFactory factory = LottoFactory.getInstance();
        List<Lotto> lotto = factory.createLotto(12000);
        assertEquals(12, lotto.size());
    }
}