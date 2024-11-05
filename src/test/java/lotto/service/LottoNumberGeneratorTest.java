package lotto.service;

import lotto.model.Lottos;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LottoNumberGeneratorTest {

    private LottoNumberGenerator lottoNumberGenerator;

    @BeforeEach
    void setUp() {
        lottoNumberGenerator = new LottoNumberGenerator();
    }

    @Test
    @DisplayName("지정한 개수만큼의 로또가 생성되는지 확인")
    void ShouldGenerateSpecifiedNumberOfLottos() {
        int lottoCount = 5;
        Lottos lottos = lottoNumberGenerator.generateLottoNumbers(lottoCount);
        assertEquals(lottoCount, lottos.getLottos().size());
    }
}
