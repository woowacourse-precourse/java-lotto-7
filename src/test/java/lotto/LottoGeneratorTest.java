package lotto;


import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoGeneratorTest {

    @DisplayName("로또 구입 금액이 1000원 단위로 떨어지지 않으면 예외를 발생한다.")
    @Test
    void 로또_구입금액_단위_테스트() {
        assertThatThrownBy(() -> new LottoGenerator(1500))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호_6개_생성() {
        LottoGenerator lottoGenerator = new LottoGenerator(1_000);
        List<Integer> lottoNumbers = lottoGenerator.generateNumbers();
        assertThat(lottoNumbers.size())
                .isEqualTo(6);
    }

    @Test
    void 로또_번호_중복_확인() {
        LottoGenerator lottoGenerator = new LottoGenerator(1_000);
        List<Integer> lottoNumbers = lottoGenerator.generateNumbers();
        assertThat(lottoNumbers.size())
                .isEqualTo(new HashSet<>(lottoNumbers).size());
    }

    @Test
    void 로또_구입금액만큼_발행() {
        LottoGenerator lottoGenerator = new LottoGenerator(5_000);
        List<Lotto> lotties = lottoGenerator.generate();
        assertThat(lotties.size())
                .isEqualTo(5);
    }
}
