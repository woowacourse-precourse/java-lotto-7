package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGeneratorTest {

    @Test
    @DisplayName("generateLotto 메서드는 지정된 수의 로또를 생성한다")
    void generateLotto_createsSpecifiedNumberOfLottos() {
        LottoGenerator lottoGenerator = new LottoGenerator();
        int lottoCount = 5;

        List<Lotto> lottos = lottoGenerator.generateLotto(lottoCount);

        assertEquals(lottoCount, lottos.size(), "생성된 로또의 수가 요청한 개수와 일치해야 합니다.");
    }

    @Test
    @DisplayName("generateLottoNumbers 메서드는 6개의 고유한 번호를 가진 Lotto 객체를 생성한다")
    void generateLottoNumbers_createsLottoWithUniqueNumbers() {
        LottoGenerator lottoGenerator = new LottoGenerator();

        Lotto lotto = lottoGenerator.generateLottoNumbers();

        assertEquals(6, lotto.getNumbers().size(), "생성된 로또의 번호 수는 6이어야 합니다.");
        assertTrue(lotto.getNumbers().stream().distinct().count() == 6, "생성된 로또의 번호는 고유해야 합니다.");
        assertTrue(lotto.getNumbers().stream().allMatch(num -> num >= 1 && num <= 45),
            "생성된 로또의 번호는 1에서 45 사이여야 합니다.");
    }
}