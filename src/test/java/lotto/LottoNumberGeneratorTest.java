package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

class LottoNumberGeneratorTest {

    @Test
    @DisplayName("로또 번호 생성 시 중복이 없어야 하며, 번호는 6개여야 한다")
    void 로또_번호_생성_중복_확인() {
        List<Integer> numbers = LottoNumberGenerator.generate();

        // 번호 개수 확인
        assertThat(numbers).hasSize(6);

        // 중복 확인
        assertThat(numbers).doesNotHaveDuplicates();
    }

    @Test
    @DisplayName("로또 번호는 1부터 45 사이의 숫자여야 한다")
    void 로또_번호_범위_확인() {
        List<Integer> numbers = LottoNumberGenerator.generate();

        // 모든 번호가 1부터 45 사이에 있는지 확인
        assertThat(numbers).allMatch(num -> num >= 1 && num <= 45);
    }
}
