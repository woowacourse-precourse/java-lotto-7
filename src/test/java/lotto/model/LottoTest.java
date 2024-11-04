package lotto.model;

import lotto.model.Lotto;
import lotto.service.LottoGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    private final LottoGenerator lottoGenerator = new LottoGenerator();

    @Test
    void 로또번호가_정렬된_상태로_저장되는지_확인() {
        Lotto lotto = lottoGenerator.generateLotto();
        assertThat(lotto.getNumbers()).isSorted();
    }

    @Test
    void 로또번호가_6개인지_확인() {
        Lotto lotto = lottoGenerator.generateLotto();
        assertThat(lotto.getNumbers()).hasSize(6);
    }
}
