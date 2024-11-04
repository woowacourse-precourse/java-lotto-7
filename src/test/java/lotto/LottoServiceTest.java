package lotto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.ValueSources;

import java.util.List;

public class LottoServiceTest {

    private final LottoService lottoService = new LottoService();

    @DisplayName("구입 양 만큼의 6개 번호를 가진 로또를 리스트를 반환한다.")
    @ParameterizedTest(name = "로또의 개수가 {0}이면 크기가 6인 {0}개의 로또를 반환한다.")
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8})
    void 로또_리스트_반환_테스트(int lottoAmount) {
        List<List<Integer>> lottos = lottoService.publishLotto(lottoAmount);
        Assertions.assertAll(() ->
                        Assertions.assertEquals(lottoAmount, lottos.size()),
                () -> {
                    for (List<Integer> lotto : lottos) {
                        Assertions.assertEquals(6, lotto.size());
                    }
                }
        );
    }

    @DisplayName("로또와 당첨 번호를 비교하여 First Rank를 반환한다.")
    @Test
    void 로또_당첨_순위_반환_테스트_FIRST() {

        //given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        List<Integer> lotto = List.of(1, 2, 3, 4, 5, 6);

        //when
        LottoRank lottoRank = lottoService.prizeWinningDiscriminationPerLotto(winningNumbers, bonusNumber, lotto);
        //then
        Assertions.assertEquals(LottoRank.First, lottoRank);
    }

    @DisplayName("로또와 당첨 번호를 비교하여 Second Rank를 반환한다.")
    @Test
    void 로또_당첨_순위_반환_테스트_SECOND() {
        //given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        List<Integer> lotto = List.of(1, 2, 3, 4, 5, 7);
        //when
        LottoRank lottoRank = lottoService.prizeWinningDiscriminationPerLotto(winningNumbers, bonusNumber, lotto);
        //then
        Assertions.assertEquals(LottoRank.Second, lottoRank);
    }

    @DisplayName("로또와 당첨 번호를 비교하여 Third Rank를 반환한다.")
    @Test
    void 로또_당첨_순위_반환_테스트_THIRD() {
        //given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        List<Integer> lotto = List.of(1, 2, 3, 4, 5, 8);
        //when
        LottoRank lottoRank = lottoService.prizeWinningDiscriminationPerLotto(winningNumbers, bonusNumber, lotto);
        //then
        Assertions.assertEquals(LottoRank.Third, lottoRank);
    }

    @DisplayName("로또와 당첨 번호를 비교하여 Fourth Rank를 반환한다.")
    @Test
    void 로또_당첨_순위_반환_테스트_FOURTH() {
        //given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        List<Integer> lotto = List.of(1, 2, 3, 4, 7, 8);
        //when
        LottoRank lottoRank = lottoService.prizeWinningDiscriminationPerLotto(winningNumbers, bonusNumber, lotto);
        //then
        Assertions.assertEquals(LottoRank.Fourth, lottoRank);
    }

    @DisplayName("로또와 당첨 번호를 비교하여 Fifth Rank를 반환한다.")
    @Test
    void 로또_당첨_순위_반환_테스트_FIFTH() {
        //given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        List<Integer> lotto = List.of(1, 2, 3, 7, 8, 9);
        //when
        LottoRank lottoRank = lottoService.prizeWinningDiscriminationPerLotto(winningNumbers, bonusNumber, lotto);
        //then
        Assertions.assertEquals(LottoRank.Fifth, lottoRank);
    }

    @DisplayName("로또와 당첨 번호를 비교하여 None Rank를 반환한다.")
    @Test
    void 로또_당첨_순위_반환_테스트_NONE() {
        //given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        List<Integer> lotto = List.of(10, 20, 30, 40, 50, 60);
        //when
        LottoRank lottoRank = lottoService.prizeWinningDiscriminationPerLotto(winningNumbers, bonusNumber, lotto);
        //then
        Assertions.assertEquals(LottoRank.None, lottoRank);
    }


    @DisplayName("로또 갯수에 따른 로또들이 주어지면, 당첨 통계를 반환한다.")
    @Test
    void 로또_당첨_통계_반환_테스트() {
        //given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        List<List<Integer>> lottos = List.of(
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 4, 5, 7),
                List.of(1, 2, 3, 4, 5, 8),
                List.of(1, 2, 3, 4, 7, 8),
                List.of(1, 2, 3, 7, 8, 9),
                List.of(10, 20, 30, 40, 50, 60)
        );
        //when
        var result = lottoService.calculateStatistic(winningNumbers, bonusNumber, lottos);
        //then
        Assertions.assertAll(
                () -> Assertions.assertEquals(1, result.get(LottoRank.First)),
                () -> Assertions.assertEquals(1, result.get(LottoRank.Second)),
                () -> Assertions.assertEquals(1, result.get(LottoRank.Third)),
                () -> Assertions.assertEquals(1, result.get(LottoRank.Fourth)),
                () -> Assertions.assertEquals(1, result.get(LottoRank.Fifth)),
                () -> Assertions.assertEquals(1, result.get(LottoRank.None))
        );
    }

    @DisplayName("로또 갯수 반환 테스트")
    @Test
    void 로또_갯수_반환_테스트() {
        //given
        int purchaseAmount = 10000;
        //when
        int result = lottoService.calCulateLottoAmount(purchaseAmount);
        //then
        Assertions.assertEquals(10, result);
    }
}
