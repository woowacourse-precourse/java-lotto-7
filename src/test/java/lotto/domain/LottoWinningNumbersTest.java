package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoWinningNumbersTest {

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6:7"}, delimiter = ':')
    void 로또_당첨_번호_생성_테스트(String first, String second){
        LottoWinningNumbers lotto = new LottoWinningNumbers();
        lotto.setMainNumbers(first);
        lotto.setBonusNumber(second);
        lotto.generate();

        List<Integer> winningNumbers = lotto.getWinningNumbers();
        assertThat(winningNumbers).containsExactly(1, 2, 3, 4, 5, 6);

        int bonusNumber = lotto.getBonusNumber();
        assertThat(bonusNumber).isEqualTo(7);
    }
}