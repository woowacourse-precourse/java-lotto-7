package lotto.domain;

import static lotto.exception.ErrorMessage.BONUS_NUMBER_DUPLICATE;
import static org.assertj.core.api.Assertions.*;

import java.util.List;
import lotto.domain.vo.LottoNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class WinningLottoTests {
    private Lotto winningLottoNumbers;

    @BeforeEach
    void setUp() {
        winningLottoNumbers = Lotto.from(List.of(1, 2, 3, 4, 5, 6));
    }

    @Test
    void testCreateWinningLottoWithValidBonusNumber() {
        LottoNumber bonusNumber = LottoNumber.of(7);

        WinningLotto winningLotto = WinningLotto.of(winningLottoNumbers, bonusNumber);

        assertThat(winningLotto).isNotNull();
    }

    @Test
    void testCreateWinningLottoWithDuplicateBonusNumberThrowsException() {
        LottoNumber duplicateBonusNumber = LottoNumber.of(6);

        assertThatThrownBy(() -> WinningLotto.of(winningLottoNumbers, duplicateBonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(BONUS_NUMBER_DUPLICATE.getMessage());
    }

    @ParameterizedTest
    @CsvSource({
            "4,5,6,7,8,9,10,3,false",    // 4, 5, 6 일치, 보너스 불일치
            "7,8,9,10,11,12,10,0,true",   // 일치 번호 없음, 보너스 일치
            "7,8,9,10,11,12,13,0,false"   // 일치 번호 없음, 보너스 불일치
    })
    void testWinningLottoMatchingCounts(
            int n1, int n2, int n3, int n4, int n5, int n6,
            int bonus,
            int expectedMatchCount,
            boolean expectedBonusMatch
    ) {
        Lotto lotto = Lotto.from(List.of(n1, n2, n3, n4, n5, n6));
        LottoNumber bonusNumber = LottoNumber.of(bonus);
        WinningLotto winningLotto = WinningLotto.of(winningLottoNumbers, bonusNumber);

        int matchedCount = winningLotto.getCountMatchedNumber(lotto);
        boolean bonusMatch = winningLotto.checkBonusNumberMatched(lotto);

        assertThat(matchedCount).isEqualTo(expectedMatchCount);
        assertThat(bonusMatch).isEqualTo(expectedBonusMatch);
    }
}