package lotto.util;

import lotto.domain.Lotto;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoListGeneratorTest {

    @Test
    void generateTest() {
        // given
        int count = 5;
        // when
        List<Lotto> generateLottos = LottoListGenerator.generateLottos(count);
        // then
        assertEquals(count, generateLottos.size());
    }
}