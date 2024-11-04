package lotto;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LottoMachineTest {
    @Test
    void 로또_번호_생성_성공() {
        LottoMachine machine = new LottoMachine();
        List<Integer> numbers = machine.generateNumbers();

        // 사이즈 6인지 확인
        assertEquals(6, numbers.size());

        // 번호들이 중복된 것이 없는지 확인
        assertEquals(6, new HashSet<>(numbers).size());

        // 번호의 범위 확인 (1~45)
        assertTrue(numbers.stream()
                .allMatch(num -> num >= 1 && num <= 45));

        // 정렬 되었는지 확인
        assertEquals(numbers, numbers.stream()
                .sorted()
                .collect(Collectors.toList()));
    }
}
