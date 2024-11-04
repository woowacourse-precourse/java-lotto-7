package lotto.parser;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoParserTest {

    @Test
    @DisplayName("정상 로또 번호 입력")
    void lottoNumbers() {
        List<Integer> winningNumbers = LottoParser.getWinningNumbers("1,2,3,4,5,6");
        Assertions.assertEquals(6, winningNumbers.size());
        Assertions.assertEquals(List.of(1, 2, 3, 4, 5, 6), winningNumbers);
    }

    @Test
    @DisplayName("정상 보너스 번호 입력")
    void bonusNumber() {
        int bonusNumber = LottoParser.getBonusNumber("7", List.of(1, 2, 3, 4, 5, 6));
        Assertions.assertEquals(7, bonusNumber);
    }
}