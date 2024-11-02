package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import lotto.domain.generator.LottoNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottosTest {

    @DisplayName("로또가 리스트에 추가되는데 성공한다.")
    @Test
    void 로또_리스트_추가_성공() {
        Lottos lottos = new Lottos();
        LottoNumberGenerator lottoNumberGenerator = () -> List.of(1, 2, 3, 4, 5, 6);

        lottos.addLotto(lottoNumberGenerator);

        assertEquals(1, lottos.getLottos().size());
    }

}