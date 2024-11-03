package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.TestConstants.LOTTO_NUMBERS;
import static lotto.TestConstants.SORTED_LOTTO_NUMBERS;
import static lotto.common.Constants.LOTTO_SIZE;
import static org.junit.jupiter.api.Assertions.*;

class LottoServiceTest {
    private final LottoService lottoService = new LottoService();


    @Test
    @DisplayName("6개의 숫자로 이루어진 로또가 오름차순으로 생성된다.")
    public void testGenerateLotto () {
        // given
        List<Integer> numbers = LOTTO_NUMBERS;

        // when
        Lotto lotto = lottoService.generateLotto(numbers);

        // then
        assertEquals(lotto.size(), LOTTO_SIZE);

        assertTrue(lotto.compare(SORTED_LOTTO_NUMBERS));
    }

    @Test
    @DisplayName("로또의 묶음이 잘 저장된다.")
    public void createLottos () {
        // given
        List<Lotto> givenLottos = List.of(
                new Lotto(SORTED_LOTTO_NUMBERS),
                new Lotto(SORTED_LOTTO_NUMBERS)
        );

        // when
        Lottos lottos = lottoService.generateLottos(givenLottos);

        // then
        assertEquals(lottos.size(), givenLottos.size());
    }
}