package domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class LottoGeneratorTest {

    @Test
    void 로또_숫자_리스트_생성() {
        LottoGenerator lottoGenerator = new LottoGenerator();
        assertThat(lottoGenerator.createNumbers()).isNotNull();
    }

    @Test
    void 로또_숫자_리스트_정렬() {
        LottoGenerator lottoGenerator = new LottoGenerator();
        assertThat(lottoGenerator.createNumbers()).isSorted();
    }


    @Test
    void 로또_하나_생성() {
        List<LottoNumber> numbers = List.of(LottoNumber.from(1), LottoNumber.from(2), LottoNumber.from(3),
                LottoNumber.from(4), LottoNumber.from(5), LottoNumber.from(6));
        LottoGenerator lottoGenerator = new LottoGenerator();
        assertThat(lottoGenerator.createLotto(numbers)).isEqualTo(new Lotto(numbers));
    }

    @Test
    void 구매_개수_만큼_로또_생성() {
        int purchaseCount = 3;
        LottoGenerator lottoGenerator = new LottoGenerator();

        assertThat(lottoGenerator.createLottos(purchaseCount)).isNotNull();
        assertThat(lottoGenerator.createLottos(purchaseCount).size()).isEqualTo(3);
    }
}
