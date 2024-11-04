package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import lotto.model.LottoManager;
import org.junit.jupiter.api.Test;

class LottoManagerTest {
    @Test
    void 당첨_번호_입력_중복된_번호_예외() {
        LottoManager lottoManager = new LottoManager();

        assertThatThrownBy(() -> lottoManager.generateCustomLotto("1,2,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨_번호_입력_범위_밖_예외() {
        LottoManager lottoManager = new LottoManager();

        assertThatThrownBy(() -> lottoManager.generateCustomLotto("1,2,202,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_발급_번호_범위_내() {
        LottoManager lottoManager = new LottoManager();
        List<Integer> numbers = lottoManager.addLotto();

        assertThat(numbers)
                .allMatch(number -> number >= 1 && number <= 45);
    }
}