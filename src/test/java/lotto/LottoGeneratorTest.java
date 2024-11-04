package lotto;


import java.util.HashSet;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoGeneratorTest {

    @Test
    void 로또_번호_6개_생성() {
        LottoGenerator lottoGenerator = new LottoGenerator();
        List<Integer> lottoNumbers = lottoGenerator.generateNumbers();
        assertThat(lottoNumbers.size())
                .isEqualTo(6);
    }

    @Test
    void 로또_번호_중복_확인() {
        LottoGenerator lottoGenerator = new LottoGenerator();
        List<Integer> lottoNumbers = lottoGenerator.generateNumbers();
        assertThat(lottoNumbers.size())
                .isEqualTo(new HashSet<>(lottoNumbers).size());
    }

    @Test
    void 로또_구입금액만큼_발행() {
        LottoGenerator lottoGenerator = new LottoGenerator();
        List<Lotto> lotties = lottoGenerator.generate(5_000);
        assertThat(lotties.size())
                .isEqualTo(5);
    }
}
