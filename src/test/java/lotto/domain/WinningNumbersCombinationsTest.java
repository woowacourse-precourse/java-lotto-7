package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import lotto.dto.BonusNumber;
import lotto.dto.WinningNumbers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WinningNumbersCombinationsTest {
    private WinningNumbers winningNumbers;
    private BonusNumber bonusNumber;
    private WinningNumbersCombinations winningNumbersCombinations;

    @BeforeEach
    void setUp() {
        // 기본적인 WinningNumbers 및 BonusNumber 설정
        winningNumbers = new WinningNumbers("1,2,3,4,5,6");
        bonusNumber = new BonusNumber("7");
        winningNumbersCombinations = new WinningNumbersCombinations(winningNumbers, bonusNumber);
    }

    @Test
    void compareWinningNumbers() {
        // 로또 번호 생성
        Lotto lottoWithFiveMatches = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8));
        Lotto lottoWithNoMatches = new Lotto(Arrays.asList(8, 9, 10, 11, 12, 13));

        // 일치하는 번호 개수 확인
        int winningCount = winningNumbersCombinations.compareWinningNumbers(lottoWithFiveMatches);
        assertThat(winningCount).isEqualTo(5); // 5개의 번호가 일치해야 함

        // 일치하는 번호가 없는 경우
        winningCount = winningNumbersCombinations.compareWinningNumbers(lottoWithNoMatches);
        assertThat(winningCount).isEqualTo(0); // 일치하는 번호가 없어야 함
    }


    @Test
    void compareBonusNumber() {
        // 로또 번호 생성
        Lotto lottoWithBonus = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)); // 보너스 번호가 포함됨
        Lotto lottoWithoutBonus = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8)); // 보너스 번호가 없음

        // 보너스 번호와의 일치 여부 확인
        boolean isBonusMatched = winningNumbersCombinations.compareBonusNumber(lottoWithBonus);
        assertThat(isBonusMatched).isTrue(); // 보너스 번호가 일치해야 함

        isBonusMatched = winningNumbersCombinations.compareBonusNumber(lottoWithoutBonus);
        assertThat(isBonusMatched).isFalse(); // 보너스 번호가 일치하지 않아야 함
    }
}