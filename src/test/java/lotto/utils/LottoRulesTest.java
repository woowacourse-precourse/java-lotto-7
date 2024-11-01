package lotto.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoRulesTest {
    @Test
    @DisplayName("중복되지 않게 숫자 뽑기")
    void pickRandomNumbers() {
        List<Integer> numbers = LottoRules.pickRandomNumbers();
        assertEquals(numbers.size(), numbers.stream().distinct().count());
    }

    @Test
    @DisplayName("로또 번호 개수만큼의 숫자 뽑기")
    void pickRandomNumberNoDuplicate() {
        List<Integer> numbers = LottoRules.pickRandomNumbers();
        assertEquals(LottoRules.LOTTO_NUMBER_SIZE, numbers.size());
    }

    @Test
    @DisplayName("로또 가격은 0이 아닌 양의 정수 값")
    void lottoPrice() {
        assertTrue(LottoRules.LOTTO_PRICE > 0);
    }
}