package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class list_numTest {

    @Test
    @DisplayName("로또 번호 생성 개수 테스트")
    public void testLottoNumberGenerationCount() {
        list_num listNum = new list_num();
        int num = 5;
        List<ArrayList<Integer>> result = listNum.list(num);
        assertEquals(num, result.size(), "생성된 리스트의 개수가 요청된 개수와 일치해야 합니다.");
    }

    @Test
    @DisplayName("로또 번호 범위 및 중복 확인 테스트")
    public void testLottoNumberRangeAndUniqueness() {
    	list_num listNum = new list_num();
        int num = 3;
        List<ArrayList<Integer>> result = listNum.list(num);

        for (ArrayList<Integer> ticket : result) {
            assertEquals(6, ticket.size(), "각 로또 번호 리스트는 6개의 숫자를 포함해야 합니다.");

            for (int number : ticket) {
                assertTrue(number >= 1 && number <= 45, "로또 번호는 1에서 45 사이의 값이어야 합니다.");
            }
            Set<Integer> uniqueNumbers = new HashSet<>(ticket);
            assertEquals(6, uniqueNumbers.size(), "로또 번호는 중복되지 않아야 합니다.");
        }
    }

    @Test
    @DisplayName("로또 번호 정렬 확인 테스트")
    public void testLottoNumberSorting() {
    	list_num listNum = new list_num();
        int num = 4;
        List<ArrayList<Integer>> result = listNum.list(num);

        for (ArrayList<Integer> ticket : result) {
            ArrayList<Integer> sortedTicket = new ArrayList<>(ticket);
            Collections.sort(sortedTicket);
            assertEquals(sortedTicket, ticket, "각 로또 번호는 오름차순으로 정렬되어야 합니다.");
        }
    }
}