package lotto.model.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoWinningNumbersTest {
    @Test
    public void 당첨번호_정상_생성_테스트() throws Exception {
        //given
        List<Integer> inputWinningLottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        int inputBonusNumber = 7;

        //when
        Lotto winningNumbers = new Lotto(inputWinningLottoNumbers);
        BonusNumber bonusNumber = new BonusNumber(inputBonusNumber);
        LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers(winningNumbers, bonusNumber);

        //then
        assertEquals(lottoWinningNumbers.getWinningLottoNumbers(), winningNumbers);
        assertEquals(lottoWinningNumbers.getWinningBonusNumber(), bonusNumber);
    }

    @ParameterizedTest
    @ValueSource(ints = {5, 6, 7, 8})
    public void 당첨_번호에_특정_번호를_담고있는지_여부_확인하기(int value) throws Exception {
        //given
        List<Integer> inputWinningLottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        int inputBonusNumber = 7;

        //when
        Lotto winningNumbers = new Lotto(inputWinningLottoNumbers);
        BonusNumber bonusNumber = new BonusNumber(inputBonusNumber);
        LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers(winningNumbers, bonusNumber);

        //then
        assertEquals(lottoWinningNumbers.isContainsWinningNumbers(value), inputWinningLottoNumbers.contains(value));
        assertEquals(lottoWinningNumbers.isContainsBonusNumber(value), inputBonusNumber == value);
    }
}