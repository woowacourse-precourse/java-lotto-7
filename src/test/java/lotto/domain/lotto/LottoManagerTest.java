package lotto.domain.lotto;

import lotto.validator.LottoValidator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LottoManagerTest {
    private LottoValidator lottoValidator;
    private LottoNumbersGenerator lottoNumbersGenerator;
    private LottoManager lottoManager;

    @BeforeEach
    void setup() {
        lottoValidator = new LottoValidator();
        lottoNumbersGenerator = new LottoNumbersGenerator(lottoValidator);
        lottoManager = new LottoManager(lottoNumbersGenerator);
    }

    @Test
    void 로또_구매_개수_테스트() {
        int buyLottoCount = 8;

        lottoManager.createLottos(buyLottoCount);

        int size = lottoManager.getLottos().size();

        Assertions.assertThat(size).isEqualTo(8);
    }
}
