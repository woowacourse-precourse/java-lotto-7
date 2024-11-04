package lotto.core;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.core.Lotto;
import lotto.core.LottoGenerator;
import lotto.core.LottoNumber;
import org.junit.jupiter.api.Test;

public class LottoGeneratorTest {

    private static final LottoGenerator LOTTO_GENERATOR = new LottoGenerator();

    @Test
    void 로또_숫자_리스트_생성() {
        assertThat(LOTTO_GENERATOR.createNumbers()).isNotNull();
    }

    @Test
    void 로또_숫자_리스트_정렬() {
        assertThat(LOTTO_GENERATOR.createNumbers()).isSorted();
    }


    @Test
    void 로또_하나_생성() {
        List<LottoNumber> numbers = List.of(LottoNumber.from(1), LottoNumber.from(2), LottoNumber.from(3),
                LottoNumber.from(4), LottoNumber.from(5), LottoNumber.from(6));

        assertThat(LOTTO_GENERATOR.createLotto(numbers)).isEqualTo(new Lotto(numbers));
    }

    @Test
    void 구매_개수_만큼_로또_생성() {
        int purchaseCount = 3;

        assertThat(LOTTO_GENERATOR.createLottos(purchaseCount)).isNotNull();
        assertThat(LOTTO_GENERATOR.createLottos(purchaseCount).size()).isEqualTo(3);
    }
}
