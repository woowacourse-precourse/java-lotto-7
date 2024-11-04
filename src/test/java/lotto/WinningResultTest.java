package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.WinningRank;
import lotto.domain.WinningResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class WinningResultTest {
    private final WinningResult winningResult = new WinningResult();

    @ParameterizedTest
    @DisplayName("로또 당첨 등수 반환 테스트")
    @CsvSource(value = {
            "3, false, FIFTH",
            "4, false, FOURTH",
            "5, false, THIRD",
            "5, true, SECOND",
            "6, false, FIRST"})
    void 로또_당첨_등수_반환_테스트(int matchCount, boolean matchBonus, WinningRank excepted) {
        assertThat(winningResult.getLottoRank(matchCount, matchBonus)).isEqualTo(excepted);
    }

    @ParameterizedTest
    @DisplayName("로또 숫자 비교 후 등수 반환 테스트")
    @CsvSource(value = {
            "1,2,3,4,5,6:1,2,3,4,5,6:7:FIRST",  // 6개 일치 - 1등
            "1,2,3,4,5,6:1,2,3,4,5,7:6:SECOND", // 5개 일치, 보너스 일치 - 2등
            "1,2,3,4,5,6:1,2,3,4,5,8:7:THIRD", // 5개 일치, 보너스 불일치 - 3등
            "1,2,3,4,5,6:1,2,3,4,8,9:7:FOURTH", // 4개 일치 - 4등
            "1,2,3,4,5,6:1,2,3,7,8,9:4:FIFTH",  // 3개 일치 - 5등
            "1,2,3,4,5,6:1,2,7,8,9,10:3:NONE", // 2개 일치 - NONE
            "1,2,3,4,5,6:1,7,8,9,10,11:2:NONE", // 1개 일치 - NONE
            "1,2,3,4,5,6:7,8,9,10,11,12:1:NONE" // 일치하는 숫자 없음 - NONE

    }, delimiter = ':')
    void 로또_숫자_비교_후_당첨_등수_반환_테스트(String lottoNumbers, String winningNumbers, int bonusNumber,
                                 WinningRank expectedRank) {
        Lotto lotto = new Lotto(integerListConverter(lottoNumbers));
        List<Integer> winningList = integerListConverter(winningNumbers);

        WinningRank result = winningResult.compareLottoNumbers(lotto, winningList, bonusNumber);
        assertThat(result).isEqualTo(expectedRank);
    }

    private static List<Integer> integerListConverter(String input) {
        List<Integer> numbers = new ArrayList<>();

        String[] numbersString = input.split(",");
        for (String s : numbersString) {
            numbers.add(Integer.parseInt(s));
        }

        return numbers;
    }

    @ParameterizedTest
    @DisplayName("수익률 계산 테스트")
    @CsvSource(value = {"5000, 8000, 62.5", "0, 3000, 0.0"})
    void 수익률_계산_테스트(long prizeMoney, int amount, String excepted) {
        winningResult.setPrizeMoney(prizeMoney);
        assertThat(winningResult.getRateOfReturn(amount)).contains(excepted);
    }

    @Test
    @DisplayName("총 수익금 int형 범위 초과 테스트")
    void 총_수익금_int형_범위_초과_테스트() {
        winningResult.setPrizeMoney(4_000_000_000L);
    }

    @Test
    @DisplayName("총 수익금 int형 범위 초과 시 수익률 계산 테스트")
    void 총_수익금_int형_범위_초과_시_수익률_계산_테스트() {
        winningResult.setPrizeMoney(4_000_000_000L);
        assertThat(winningResult.getRateOfReturn(100_000_000)).contains("4000.0");
    }
}
