package lotto;

import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MakeNumberTest {

    @Test
    void testGenerateLottoNumbers() {
        MakeNumber makeNumber = new MakeNumber();
        int total = 3;
        List<List<Integer>> lottoNumbers = makeNumber.generateLottoNumbers(total);

        // 생성된 리스트의 크기가 기대값과 일치하는지 확인
        assertEquals(total, lottoNumbers.size());

        // 각 리스트의 크기와 범위를 확인
        for (List<Integer> numbers : lottoNumbers) {
            assertEquals(6, numbers.size()); // 각 로또 번호 리스트는 6개의 숫자를 포함해야 함
            for (int num : numbers) {
                assertTrue(num >= 1 && num <= 45, "숫자가 범위를 벗어남: " + num);
            }
        }
    }

    @Test
    void testSort() {
        MakeNumber makeNumber = new MakeNumber();
        List<Integer> list = new ArrayList<>(Arrays.asList(5, 3, 8, 1, 7));
        makeNumber.sort(list);

        // 리스트가 정렬되었는지 확인
        assertEquals(Arrays.asList(1, 3, 5, 7, 8), list);
    }

    @Test
    void testRandomNumber() {
        MakeNumber makeNumber = new MakeNumber();
        int total = 2;
        List<List<Integer>> purchasedNumbers = makeNumber.randomNumber(total);

        // 생성된 리스트의 크기가 기대값과 일치하는지 확인
        assertEquals(total, purchasedNumbers.size());

        // 각 리스트의 크기와 범위를 확인
        for (List<Integer> numbers : purchasedNumbers) {
            assertEquals(6, numbers.size()); // 각 로또 번호 리스트는 6개의 숫자를 포함해야 함
            for (int num : numbers) {
                assertTrue(num >= 1 && num <= 45, "숫자가 범위를 벗어남: " + num);
            }
        }
    }

    @Test
    void testBubbleSortAndSwap() {
        MakeNumber makeNumber = new MakeNumber();
        List<Integer> list = new ArrayList<>(Arrays.asList(10, 2, 33, 21, 5));
        makeNumber.sort(list);

        // 버블 정렬 후 리스트가 정렬되었는지 확인
        assertEquals(Arrays.asList(2, 5, 10, 21, 33), list);
    }
}
