package lotto.numberGenerator;

import lotto.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoRandomNumberGeneratorTest {

    LottoRandomNumberGenerator lottoRandomNumberGenerator = new LottoRandomNumberGenerator();

    @Test
    void generateLottoNumbers() {
        Lotto numbers = lottoRandomNumberGenerator.generateLottoNumbers();
        Assertions.assertThat(numbers).isInstanceOf(Lotto.class);
    }
}