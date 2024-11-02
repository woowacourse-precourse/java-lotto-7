package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.model.service.LottoGenerateService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoGenerateServiceTest {
    private final LottoGenerateService lottoGenerator = new LottoGenerateService();

    @DisplayName("로또 생성 테스트")
    @ParameterizedTest
    @CsvSource({"6000,6", "8000,8", "100000,100",})
    void generateLottosTest(int amount, int expected) {
        assertThat(lottoGenerator.generateLottos(amount)).hasSize(expected);
    }

}