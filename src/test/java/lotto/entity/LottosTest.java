package lotto.entity;

import lotto.enums.Prize;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LottosTest {

    private Lottos lottos;
    private WinningNumbers winningNumbers;

    @BeforeEach
    void setUp() {
        // 로또 리스트 생성
        List<Lotto> lottoList = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)), // 6개 일치 - 1등
                new Lotto(List.of(1, 2, 3, 4, 5, 7)), // 5개 일치 + 보너스 일치 - 2등
                new Lotto(List.of(1, 2, 3, 4, 5, 8)), // 5개 일치 - 3등
                new Lotto(List.of(1, 2, 3, 4, 9, 10)), // 4개 일치 - 4등
                new Lotto(List.of(1, 2, 3, 11, 12, 13)) // 3개 일치 - 5등
        );
        lottos = new Lottos(lottoList);

        // 당첨 번호와 보너스 번호 설정
        List<Integer> winningNums = List.of(1, 2, 3, 4, 5, 6);
        int bonusNum = 7;
        winningNumbers = new WinningNumbers(winningNums, bonusNum);
    }

    @Test
    @DisplayName("유효한 당첨 번호와 보너스 번호로 올바른 당첨 결과 계산")
    void calculateCorrectResultsWithValidWinningNumbers() {
        // When
        List<Prize> results = lottos.calculateResults(winningNumbers);

        // Then
        assertEquals(Prize.FIRST, results.get(0));  // 6개 일치 - 1등
        assertEquals(Prize.SECOND, results.get(1)); // 5개 일치 + 보너스 일치 - 2등
        assertEquals(Prize.THIRD, results.get(2));  // 5개 일치 - 3등
        assertEquals(Prize.FOURTH, results.get(3)); // 4개 일치 - 4등
        assertEquals(Prize.FIFTH, results.get(4));  // 3개 일치 - 5등
    }

    @Test
    @DisplayName("Lottos 객체가 로또 개수를 올바르게 반환")
    void returnCorrectSizeForLottos() {
        // When & Then
        assertEquals(5, lottos.size());
    }

    @Test
    @DisplayName("Lottos 객체가 로또 리스트를 올바르게 문자열로 반환")
    void returnCorrectStringRepresentationForLottos() {
        // Given
        String expectedString = "[1, 2, 3, 4, 5, 6]\n" +
                "[1, 2, 3, 4, 5, 7]\n" +
                "[1, 2, 3, 4, 5, 8]\n" +
                "[1, 2, 3, 4, 9, 10]\n" +
                "[1, 2, 3, 11, 12, 13]";

        // When
        String result = lottos.toString();

        // Then
        assertEquals(expectedString, result);
    }
}
