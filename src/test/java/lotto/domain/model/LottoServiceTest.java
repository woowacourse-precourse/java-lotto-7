package lotto.domain.model;

import lotto.common.config.Factory;
import lotto.common.constant.LottoConst;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;


class LottoServiceTest {

    LottoService lottoService;

    @BeforeEach
    void setUp() {
        Factory factory = new Factory();
        lottoService = factory.lottoService();
    }


    @Nested
    @DisplayName("issueByAmount 메서드는")
    class IssueByAmountTest {

        @ParameterizedTest
        @ValueSource(ints = {1000, 2000, 3000, 4000})
        @DisplayName("금액에 맞게 로또를 발행하여 리턴한다.")
        void issueByAmount(int input) {
            //given
            //when
            List<Lotto> lottos = lottoService.issueByAmount(input);

            //then
            Assertions.assertThat(lottos).hasSize(input / LottoConst.LOTTO_PRICE);
        }

    }
}