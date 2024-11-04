package lotto;

import lotto.exception.ValidateValues;
import lotto.service.LottoGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGenerationTest {

    @Test
    void 구입_금액을_검증하고_정수형으로_리턴한다() {
        int purchaseAmount = ValidateValues.purchaseAmount("1000");
        assertThat(purchaseAmount).isEqualTo(1000);
    }

    @Test
    void 구입금액만큼_로또를_발행하고_로또_객체_리스트를_리턴한다() {
        String purchaseAmount = "8000";
        LottoGenerator lottoGenerator = new LottoGenerator();
        assertThat(lottoGenerator.generateLotto(purchaseAmount).size()).isEqualTo(8);
    }

}
