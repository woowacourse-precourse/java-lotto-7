package lotto.util;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoNumberGeneratorTest {

    @DisplayName("생성한 로또 번호가 중복이 없는지 확인한다")
    @Test
    void 로또_번호_중복_확인_테스트() {
        for (int i = 0; i < 100; i++) {
            List<Integer> lottoNumbers = LottoNumberGenerator.generate();
            Assertions.assertThat(lottoNumbers).doesNotHaveDuplicates();
        }
    }

    @DisplayName("생성한 로또 번호가 6개인지 확인한다")
    @Test
    void 로또_번호_6자리_확인_테스트() {
        for (int i = 0; i < 100; i++) {
            List<Integer> lottoNumbers = LottoNumberGenerator.generate();
            Assertions.assertThat(lottoNumbers).hasSize(6);
        }
    }

}
