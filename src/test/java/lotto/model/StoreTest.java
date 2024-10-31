package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StoreTest {

    @Test
    @DisplayName("로또 번호의 개수가 6개인지 확인한다.")
    void 로또_번호가_6개인지_확인한다() {
        Store store = new Store();
        List<Integer> numbers = store.createNumbers();
        assertEquals(numbers.size(), 6);
    }
    @Test
    @DisplayName("로또 번호의 범위가 1부터 45 사이인지 확인한다.")
    void 로또_번호의_범위가_1부터_45_사이인지_확인한다() {
        Store store = new Store();
        List<Integer> numbers = store.createNumbers();
        assertTrue(numbers.stream().allMatch(value -> value >= 1 && value <= 45));
    }
    @Test
    @DisplayName("로또 번호에 중복이 있는지 확인한다.")
    void 로또_번호에_중복이_있는지_확인한다() {
        Store store = new Store();
        List<Integer> numbers = store.createNumbers();

        assertEquals(numbers.size(), numbers.stream().distinct().count());
    }
}