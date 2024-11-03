package lotto;

import lotto.model.lotto.Lotto;
import lotto.model.lotto.LottoGenerator;
import lotto.number_generator.LottoNumberGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoGeneratorTest {

    @DisplayName("생성되는 로또의 번호 수가 " + Lotto.NUMBER_COUNT + "개가 아니면 예외가 발생한다.")
    @Test
    void createNumberTest() {
        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
        LottoGenerator lottoGenerator = new LottoGenerator(lottoNumberGenerator);

        Assertions.assertEquals(Lotto.NUMBER_COUNT, lottoGenerator.createNumbers().size());
    }
}
