package lotto.domain.lotto;

import lotto.validator.LottoValidator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

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

    @Test
    void 로또_생성_후_모든_로또_번호_개수_테스트() {
        int buyLottoCount = 5;
        lottoManager.createLottos(buyLottoCount);

        List<Lotto> lottos = lottoManager.getLottos();
        for (Lotto lotto : lottos) {
            Assertions.assertThat(lotto.getNumbers().size()).isEqualTo(6);
        }
    }

    @Test
    void 로또_번호_중복_테스트() {
        int buyLottoCount = 5;
        lottoManager.createLottos(buyLottoCount);

        List<Lotto> lottos = lottoManager.getLottos();
        for (Lotto lotto : lottos) {
            List<Integer> numbers = lotto.getNumbers();
            Assertions.assertThat(numbers).doesNotHaveDuplicates();
        }
    }

    @Test
    void 로또_번호_유효범위_테스트() {
        int buyLottoCount = 5;
        lottoManager.createLottos(buyLottoCount);

        List<Lotto> lottos = lottoManager.getLottos();
        for (Lotto lotto : lottos) {
            for (Integer number : lotto.getNumbers()) {
                Assertions.assertThat(number).isBetween(1, 45);
            }
        }
    }
}
