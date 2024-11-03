package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoManagerTest {
    private LottoManager lottoManager;

    @BeforeEach
    void setUp() {
        lottoManager = new LottoManager(8000);
    }

    @DisplayName("구입 금액을 1000으로 나눈 값 만큼 로또가 발행되어야한다.")
    @Test
    void testGenerateLotto() {
        lottoManager.generateLottoNumbers();

        List<Lotto> lottoNumbers = lottoManager.getLottoNumbers();

        assertThat(lottoNumbers.size()).isEqualTo(8);
    }

    @DisplayName("당첨 번호와 일치하는 개수가 5개인 로또가 있을 때 보너스 번호를 확인해야한다.")
    @Test
    void testCheckBonusNumber() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 7);
        int bonusNumber = 6;

        LottoRanking result = lottoManager.findLottoResult(lotto, winningNumbers, bonusNumber);

        assertThat(result).isEqualTo(LottoRanking.SECOND);
    }

    @DisplayName("당첨 번호와 일치하는 개수 만큼 올바른 당첨 결과를 반환해야한다.")
    @ParameterizedTest
    @CsvSource(value = {
            "1,2,3,4,5,6:7:FIRST",
            "1,2,3,4,5,8:6:SECOND",
            "1,2,3,4,5,7:8:THIRD",
            "1,2,3,4,10,11:12:FOURTH",
            "1,2,3,10,11,12:13:FIFTH",
            "1,2,11,12,13,14:15:NOTHING",
            "1,11,12,13,14,15:16:NOTHING",
            "11,12,13,14,15,16:17:NOTHING"
    }, delimiter = ':')
    void testLottoResult(String winningNumber, int bonusNumber, LottoRanking expectedRanking) {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> winningNumbers = List.of(winningNumber.split(","))
                .stream()
                .map(Integer::parseInt)
                .toList();

        LottoRanking result = lottoManager.findLottoResult(lotto, winningNumbers, bonusNumber);

        assertThat(result).isEqualTo(expectedRanking);
    }
}
