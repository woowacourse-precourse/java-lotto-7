package lotto.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WinningNumberServiceTest {
    private WinningNumberService winningNumberService; // 클래스 필드를 private로 설정

    @BeforeEach
    void setUp() {
        winningNumberService = new WinningNumberService(); // 필드에 인스턴스 할당
    }

    @Test
    void generateWinningNumbers() {
        List<Integer> winningNumbers = winningNumberService.generateWinningNumbers("1,3,5,9,10,11");
        System.out.println(winningNumbers);
        assertEquals(List.of(1, 3, 5, 9, 10, 11), winningNumbers); // 예상 결과와 비교
    }

    @Test
    void generateWinningNumbers_WithInvalidInput() {
        winningNumberService.generateWinningNumbers("1,3,5,9,10,abc");
    }

    @Test
    void generateWinningNumbers_WithOutOfRangeInput() {
        winningNumberService.generateWinningNumbers("1,3,5,9,10,46");
    }
}
