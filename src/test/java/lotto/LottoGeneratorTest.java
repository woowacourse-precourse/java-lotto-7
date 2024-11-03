package lotto;

import org.junit.jupiter.api.Test;
import java.util.HashSet;
import static org.assertj.core.api.Assertions.assertThat;

class LottoGeneratorTest {
    @Test
    void 로또_생성_테스트() {
        Lotto lotto = LottoGenerator.generate();
        assertThat(lotto.getNumbers()).hasSize(6); // 번호 6개인지 확인
        assertThat(new HashSet<>(lotto.getNumbers())).hasSize(6); // 중복 없는지 확인
        assertThat(lotto.getNumbers()).allMatch(num -> num >= 1 && num <= 45); // 번호 범위 확인
    }
}
