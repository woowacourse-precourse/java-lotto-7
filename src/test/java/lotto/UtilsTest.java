package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.lang.reflect.Field;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UtilsTest {
    @BeforeEach
    void resetCounts() throws NoSuchFieldException, IllegalAccessException {
        for (LottoWinner winner : LottoWinner.values()) {
            Field countField = LottoWinner.class.getDeclaredField("count");
            countField.setAccessible(true); // private 필드 접근 허용
            countField.setInt(winner, 0);   // count 값을 0으로 초기화
        }
    }

    @Test
    void 천원으로_1등에_당첨되면_수익률이_2_000_000이다() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> winningNumber = List.of(1, 2, 3, 4, 5, 6);
        int bonus_number = 7;
        lotto.checkLottoWin(winningNumber, bonus_number);
        assertThat(Utils.calculateProfitRate(1000))
                .isEqualTo("200000000.0");
    }

    @Test
    void 당첨되지_않으면_수익률이_0이다() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> winningNumber = List.of(11, 12, 13, 14, 15, 16);
        int bonus_number = 7;
        lotto.checkLottoWin(winningNumber, bonus_number);
        assertThat(Utils.calculateProfitRate(1000))
                .isEqualTo("0.0");
    }

    @Test
    void 문장을_comma_단위로_split_한다() {
        assertThat(Utils.parseByComma("1, 2, 3, 4, 5, 6"))
                .containsExactly("1", "2", "3", "4", "5", "6");
    }

    @Test
    void List_내의_숫자형_문자를_정렬하여_int형으로_변환한다() {
        List<String> text = Utils.parseByComma("1, 6, 3, 2, 4, 5");
        assertThat(Utils.convertToSortedNumber(text)).containsExactly(1, 2, 3, 4, 5, 6);
    }
}
