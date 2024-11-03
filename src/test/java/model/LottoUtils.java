package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoUtilsTest {

    private final LottoUtils lottoUtils = new LottoUtils();

    @DisplayName("3개 번호 일치 테스트")
    @Test
    void matchThreeNumbers() {
        List<List<Integer>> userNumbersList = Arrays.asList(
                Arrays.asList(1, 2, 3, 7, 8, 9)
        );
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        List<Integer> result = lottoUtils.compareLists(userNumbersList, winningNumbers, bonusNumber);
        assertThat(result).containsExactly(1, 0, 0, 0, 0);
    }

    @DisplayName("4개 번호 일치 테스트")
    @Test
    void matchFourNumbers() {
        List<List<Integer>> userNumbersList = Arrays.asList(
                Arrays.asList(1, 2, 3, 4, 8, 9)
        );
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        List<Integer> result = lottoUtils.compareLists(userNumbersList, winningNumbers, bonusNumber);
        assertThat(result).containsExactly(0, 1, 0, 0, 0);
    }

    @DisplayName("5개 번호 일치 (보너스 번호 불일치) 테스트")
    @Test
    void matchFiveNumbersWithoutBonus() {
        List<List<Integer>> userNumbersList = Arrays.asList(
                Arrays.asList(1, 2, 3, 4, 5, 9)
        );
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        List<Integer> result = lottoUtils.compareLists(userNumbersList, winningNumbers, bonusNumber);
        assertThat(result).containsExactly(0, 0, 1, 0, 0);
    }

    @DisplayName("5개 번호 일치 (보너스 번호 일치) 테스트")
    @Test
    void matchFiveNumbersWithBonus() {
        List<List<Integer>> userNumbersList = Arrays.asList(
                Arrays.asList(1, 2, 3, 4, 5, 7)
        );
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        List<Integer> result = lottoUtils.compareLists(userNumbersList, winningNumbers, bonusNumber);
        assertThat(result).containsExactly(0, 0, 0, 1, 0);
    }

    @DisplayName("6개 번호 모두 일치 테스트")
    @Test
    void matchSixNumbers() {
        List<List<Integer>> userNumbersList = Arrays.asList(
                Arrays.asList(1, 2, 3, 4, 5, 6)
        );
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        List<Integer> result = lottoUtils.compareLists(userNumbersList, winningNumbers, bonusNumber);
        assertThat(result).containsExactly(0, 0, 0, 0, 1);
    }

    @DisplayName("여러 개의 로또 번호 비교 테스트")
    @Test
    void compareMultipleLottoNumbers() {
        List<List<Integer>> userNumbersList = Arrays.asList(
                Arrays.asList(1, 2, 3, 7, 8, 9),  // 3개 일치
                Arrays.asList(1, 2, 3, 4, 8, 9),  // 4개 일치
                Arrays.asList(1, 2, 3, 4, 5, 9),  // 5개 일치
                Arrays.asList(1, 2, 3, 4, 5, 7),  // 5개 + 보너스 일치
                Arrays.asList(1, 2, 3, 4, 5, 6)   // 6개 일치
        );
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        List<Integer> result = lottoUtils.compareLists(userNumbersList, winningNumbers, bonusNumber);
        assertThat(result).containsExactly(1, 1, 1, 1, 1);
    }

    @DisplayName("일치하는 번호가 없는 경우 테스트")
    @Test
    void noMatchingNumbers() {
        List<List<Integer>> userNumbersList = Arrays.asList(
                Arrays.asList(7, 8, 9, 10, 11, 12)
        );
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 13;
        List<Integer> result = lottoUtils.compareLists(userNumbersList, winningNumbers, bonusNumber);
        assertThat(result).containsExactly(0, 0, 0, 0, 0);
    }
}