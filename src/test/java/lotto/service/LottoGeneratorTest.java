package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import lotto.model.Lotto;
import lotto.model.Lottos;
import org.junit.jupiter.api.Test;

class LottoGeneratorTest {
    private final LottoGenerator lottoGenerator = new LottoGenerator();

    @Test
    void generateLotto_로또번호_6개_생성되는지_확인() {
        Lotto lotto = lottoGenerator.generateLotto();
        assertThat(lotto.getNumbers()).hasSize(6);
    }

    @Test
    void generateLotto_번호가_1부터_45_사이인지_확인() {
        Lotto lotto = lottoGenerator.generateLotto();
        assertThat(lotto.getNumbers()).allMatch(num -> num >= 1 && num <= 45);
    }

    @Test
    void generateLotto_중복된_번호가_없는지_확인() {
        Lotto lotto = lottoGenerator.generateLotto();
        long uniqueCount = lotto.getNumbers().stream().distinct().count();
        assertThat(uniqueCount).isEqualTo(6);
    }

    @Test
    void generateLotto_번호가_정렬된_상태인지_확인() {
        Lotto lotto = lottoGenerator.generateLotto();
        assertThat(lotto.getNumbers()).isSorted();
    }

    @Test
    void generateLottos_금액에_따라_로또개수_정확히_생성되는지_확인() {
            int amount = 5000;
            Lottos lottos = lottoGenerator.getnerateLottos(amount);
        assertThat(lottos.getSize()).isEqualTo(amount / 1000);
    }
}