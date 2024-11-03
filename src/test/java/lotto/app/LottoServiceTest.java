package lotto.app;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.PositiveNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoServiceTest {

    LottoService lottoService;

    static class MockRandomValueGenerator implements RandomValueGenerator {

        @Override
        public List<Integer> generate() {
            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < 6; i++) {
                result.add(i * 2);
            }

            return result;
        }
    }

    @BeforeEach
    void before() {
        lottoService = new LottoService(new MockRandomValueGenerator());
    }


    @Test
    void amount만큼_복권을_구매한다() {
        // given
        PositiveNumber amount = new PositiveNumber(6L);

        // when
        List<Lotto> lottoList = lottoService.purchaseAll(amount);

        // then
        assertThat(lottoList.size()).isEqualTo(6);
    }
}