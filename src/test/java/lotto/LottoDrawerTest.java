package lotto;

import java.util.Arrays;
import java.util.List;
import lotto.domain.lottoGeneratir.LottoGenerator;
import lotto.domain.lottoGeneratir.RandomLottoGenerator;
import lotto.dto.data.Lotto;
import lotto.dto.data.WinningLotto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoDrawerTest {
    private LottoGenerator lottoGenerator;

    @BeforeEach
    void beforeEach() {
        lottoGenerator = new RandomLottoGenerator();
    }

    @Test
    void 랜덤_로또_생성_테스트() {
        //given
        List<List<Integer>> randomNumbers = Arrays.asList(
                Arrays.asList(1, 3, 5, 6, 8, 9),
                Arrays.asList(11, 12, 23, 34, 41, 45)
        );

        List<Lotto> expectedLottos = Arrays.asList(
                new Lotto(Arrays.asList(1, 3, 5, 6, 8, 9)),
                new Lotto(Arrays.asList(11, 12, 23, 34, 41, 45))
        );

        //when
        List<Lotto> lottos = (List<Lotto>) lottoGenerator.generateLottos(randomNumbers);

        //then
        for (int i = 0; i < expectedLottos.size(); i++) {
            Assertions.assertEquals(lottos.get(i).getNumbers(), expectedLottos.get(i).getNumbers());
        }
    }

    @Test
    void 추첨_로또_생성_테스트() {
        //given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        WinningLotto expectedLotto = new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6), 8);

        //when
        WinningLotto winningLotto = (WinningLotto) lottoGenerator.generateWinningLotto(numbers, 7);

        //then
        Assertions.assertEquals(winningLotto.getNumbers(), expectedLotto.getNumbers());
    }
}