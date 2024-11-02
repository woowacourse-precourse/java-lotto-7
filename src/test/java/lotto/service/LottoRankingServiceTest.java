package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.model.FirstRankLotto;
import lotto.model.Lotto;
import lotto.model.constant.LottoRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoRankingServiceTest {

    private final LottoRankingService lottoRankingService;

    LottoRankingServiceTest() {
        this.lottoRankingService = new LottoRankingService();
    }

    @Test
    @DisplayName("getRank 정상 작동 테스트")
    void getRank_ReturnCorrectly() {
        // given
        FirstRankLotto firstRankLotto = generateFirstRankLotto();

        Lotto firstRankingLotto = generateFirstRankingLotto();
        Lotto secondRankingLotto = generateSecondRankingLotto();
        Lotto thirdRankingLotto = generateThirdRankingLotto();
        Lotto fourthRankingLotto = generateFourthRankingLotto();
        Lotto fifthRankingLotto = generateFifthRankingLotto();
        Lotto otherRankingLotto = generateOtherRankingLotto();

        // when
        LottoRank resultFirstLottoRank = lottoRankingService.getRank(firstRankingLotto, firstRankLotto);
        LottoRank resultSecondLottoRank = lottoRankingService.getRank(secondRankingLotto, firstRankLotto);
        LottoRank resultThirdLottoRank = lottoRankingService.getRank(thirdRankingLotto, firstRankLotto);
        LottoRank resultFourthLottoRank = lottoRankingService.getRank(fourthRankingLotto, firstRankLotto);
        LottoRank resultFifthLottoRank = lottoRankingService.getRank(fifthRankingLotto, firstRankLotto);
        LottoRank resultOtherLottoRank = lottoRankingService.getRank(otherRankingLotto, firstRankLotto);

        // then
        assertThat(resultFirstLottoRank).isEqualTo(LottoRank.FIRST);
        assertThat(resultSecondLottoRank).isEqualTo(LottoRank.SECOND);
        assertThat(resultThirdLottoRank).isEqualTo(LottoRank.THIRD);
        assertThat(resultFourthLottoRank).isEqualTo(LottoRank.FOURTH);
        assertThat(resultFifthLottoRank).isEqualTo(LottoRank.FIFTH);
        assertThat(resultOtherLottoRank).isEqualTo(LottoRank.OTHERS);
    }

    private static FirstRankLotto generateFirstRankLotto() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 45;

        return new FirstRankLotto(numbers, bonusNumber);
    }

    private static Lotto generateFirstRankingLotto() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        return new Lotto(numbers);
    }

    private static Lotto generateSecondRankingLotto() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 45);
        return new Lotto(numbers);
    }

    private static Lotto generateThirdRankingLotto() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 7);
        return new Lotto(numbers);
    }

    private static Lotto generateFourthRankingLotto() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 7, 8);
        return new Lotto(numbers);
    }

    private static Lotto generateFifthRankingLotto() {
        List<Integer> numbers = List.of(1, 2, 3, 7, 8, 9);
        return new Lotto(numbers);
    }

    private static Lotto generateOtherRankingLotto() {
        List<Integer> numbers = List.of(1, 2, 7, 8, 9, 10);
        return new Lotto(numbers);
    }
}
