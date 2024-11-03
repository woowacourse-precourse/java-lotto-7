package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class LottoCompanyTest {
    private static final int NO_BONUS_NUMBER = 0;
    private static final int HAS_BONUS_NUMBER = 7;
    private final Money money = new Money();
    private final List<Integer> simpleNumbers = List.of(1, 2, 3, 4, 5, 6);

    @DisplayName("5등에 대해 로또 당첨 여부를 확인할 수 있다.")
    @ParameterizedTest
    @ValueSource(ints = {1})
    void 로또_5등_당첨_테스트(int expectedCount) {
        // 5등은 3개 번호 일치
        PrizeResult prizeResult = initLottoTestWithNoBonusNumber(
                List.of(1, 2, 3, -1, -2, -3));         // 쓰레기 음수 값으로 당첨 가능성 차단
        EnumMap<Prize, Integer> map = prizeResult.getPrizeResult();
        int thirdPrizeCount = map.getOrDefault(Prize.FIFTH, 0);
        assertThat(thirdPrizeCount).isEqualTo(expectedCount);
    }

    @DisplayName("4등에 대해 로또 당첨 여부를 확인할 수 있다.")
    @ParameterizedTest
    @ValueSource(ints = {1})
    void 로또_4등_당첨_테스트(int expectedCount) {
        // 4등은 4개 번호 일치
        PrizeResult prizeResult = initLottoTestWithNoBonusNumber(List.of(1, 2, 3, 4, -2, -3));
        EnumMap<Prize, Integer> map = prizeResult.getPrizeResult();
        int thirdPrizeCount = map.getOrDefault(Prize.FOURTH, 0);
        assertThat(thirdPrizeCount).isEqualTo(expectedCount);
    }

    @DisplayName("3등에 대해 로또 당첨 여부를 확인할 수 있다.")
    @ParameterizedTest
    @ValueSource(ints = {1})
    void 로또_3등_당첨_테스트(int expectedCount) {
        // 3등은 5개 번호 일치
        PrizeResult prizeResult = initLottoTestWithNoBonusNumber(List.of(1, 2, 3, 4, 5, -3));
        EnumMap<Prize, Integer> map = prizeResult.getPrizeResult();
        int thirdPrizeCount = map.getOrDefault(Prize.THIRD, 0);
        assertThat(thirdPrizeCount).isEqualTo(expectedCount);
    }

    @DisplayName("2등에 대해 로또 당첨 여부를 확인할 수 있다.")
    @ParameterizedTest
    @ValueSource(ints = {1})
    void 로또_2등_당첨_테스트(int expectedCount) {
        // 2등은 5개 번호 + 보너스 번호 일치
        WinningLotto winningLotto = new WinningLotto(new Lotto(simpleNumbers), HAS_BONUS_NUMBER);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7)); // 보너스 번호 = 7
        LottoCompany lottoCompany = new LottoCompany(winningLotto, money);

        PrizeResult prizeResult = lottoCompany.getWinningResults(List.of(lotto));
        EnumMap<Prize, Integer> map = prizeResult.getPrizeResult();
        int thirdPrizeCount = map.getOrDefault(Prize.SECOND, 0);
        assertThat(thirdPrizeCount).isEqualTo(expectedCount);
    }

    @DisplayName("1등에 대해 로또 당첨 여부를 확인할 수 있다.")
    @ParameterizedTest
    @ValueSource(ints = {1})
    void 로또_1등_당첨_테스트(int expectedCount) {
        // 1등은 6개 번호 일치
        PrizeResult prizeResult = initLottoTestWithNoBonusNumber(List.of(1, 2, 3, 4, 5, 6));
        EnumMap<Prize, Integer> map = prizeResult.getPrizeResult();
        int thirdPrizeCount = map.getOrDefault(Prize.FIRST, 0);
        assertThat(thirdPrizeCount).isEqualTo(expectedCount);
    }

    private PrizeResult initLottoTestWithNoBonusNumber(List<Integer> numbers) {
        WinningLotto winningLotto = new WinningLotto(new Lotto(simpleNumbers), NO_BONUS_NUMBER);
        Lotto lotto = new Lotto(numbers);
        LottoCompany lottoCompany = new LottoCompany(winningLotto, money);

        return lottoCompany.getWinningResults(List.of(lotto));
    }
}
