package lotto.domain;

import lotto.LottoManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호_리스트는_정상적으로_비교_되어야_한다() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto compareLotto =  new Lotto(List.of(1, 2, 3, 10, 5, 8));
        int expected = 4;

        Assertions.assertEquals(expected, lotto.compareLottoNumber(compareLotto.getNumbers()));
    }

    @Test
    void 로또_번호가_정상적으로_저장되어야_한다() {
        List<Integer> lottoList = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(lottoList);

        Assertions.assertEquals(lottoList, lotto.getNumbers());
    }

    @Test
    void 로또의_크기에_맞게_로또를_만들어야_한다() {
        Lotto lotto = Lotto.makeRandomLottoList(1).getFirst();
        int expected = 6;
        Assertions.assertEquals(expected,lotto.getNumbers().size());
    }

    @Test
    void 기대하는_로또_번호_목록이_알맞게_생성되야_한다() {
        List<Integer> expected = List.of(1, 2, 3, 4, 5, 6);
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    Lotto lotto = Lotto.makeRandomLottoList(1).getFirst();
                    Assertions.assertEquals(
                            expected,
                            lotto.getNumbers()
                    );
                },
                expected
        );
    }

    @Test
    void 시도에_맞춰서_랜덤_로또를_알맞은_개수를_뽑아야_한다() {
        List<Lotto> lottoList = Lotto.makeRandomLottoList(4);

        long expected = 4;

        Assertions.assertEquals(expected,lottoList.size());
    }

    @Test
    void 랜덤_로또를_알맞게_뽑아야_한다() {
        List<Lotto> expected = getRandomList().stream()
                .map(Lotto::new)
                .toList();

        assertRandomUniqueNumbersInRangeTest(
                () -> Assertions.assertEquals(expected,Lotto.makeRandomLottoList(4)),
                getRandomList().get(0),
                getRandomList().get(1),
                getRandomList().get(2),
                getRandomList().get(3)
        );
    }

    private List<List<Integer>> getRandomList() {
        return List.of(
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42));
    }
}
