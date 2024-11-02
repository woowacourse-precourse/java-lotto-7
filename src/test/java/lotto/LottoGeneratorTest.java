package lotto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoGeneratorTest {
    LottoGenerator lottoGenerator = new LottoGenerator();

    @Test
    void 구입_금액이_1000원_미만이면_예외가_발생한다() {
        assertThatThrownBy(() -> lottoGenerator.getLottoCount(-1000))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구입_금액이_1000원_단위가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> lottoGenerator.getLottoCount(1500))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
