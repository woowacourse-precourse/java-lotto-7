package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoAmountTest {

    @Test
    void 구매한_로또_개수_테스트() {
        LottoAmount lottoAmount = new LottoAmount("8000");
        Assertions.assertThat(lottoAmount.getAmount()).isEqualTo(8);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1400", "1000원", "만 사천원", "100,000", "0"})
    void 구매금액_오류입력_테스트(String testPrice){
        Assertions.assertThatThrownBy(() -> new LottoAmount(testPrice))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
