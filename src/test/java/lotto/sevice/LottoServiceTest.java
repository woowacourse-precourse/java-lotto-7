package lotto.sevice;

import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoServiceTest {

    private LottoGenerator generator;

    @BeforeEach
    void setUp() {
        generator = new LottoGenerator();
    }

    @Test
    void 주어진_금액에_따라_로또를_생성한다() {
        List<Lotto> issuedLottos = new ArrayList<>();
        int purchaseCount = 8;

        for (int i = 0; i < purchaseCount; i++) {
            issuedLottos.add(generator.generate());
        }

        Assertions.assertThat(issuedLottos.size()).isEqualTo(8);

    }
}