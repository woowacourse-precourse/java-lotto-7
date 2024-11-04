package lotto.model.number_generator;

import lotto.model.lotto.Lotto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LottoNumberGeneratorTest {

    @DisplayName("생성되는 로또의 번호 수가 " + Lotto.NUMBER_COUNT + "개가 아니면 예외가 발생한다.")
    @Test
    void createNumberTest() {
        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
        List<Integer> numbers = lottoNumberGenerator.generate();

        Assertions.assertEquals(Lotto.NUMBER_COUNT, numbers.size());
    }
}
