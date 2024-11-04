package lotto.service;

import java.util.ArrayList;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class LottoGeneratorTest {

    private final LottoGenerator generator = new LottoGenerator();

    @Test
    @DisplayName("지정된 개수만큼 로또가 생성되어야 한다.")
    void 지정된_개수만큼_로또가_생성되어야_한다() {
        int count = 5;
        List<Lotto> lottos = generator.generateLottos(count);
        assertEquals(count, lottos.size(), "생성된 로또의 개수가 입력된 개수와 일치해야 합니다.");
    }

    @Test
    @DisplayName("각 로또는 6개의 고유한 번호를 가져야 한다.")
    void 각_로또는_6개의_고유한_번호를_가져야_한다() {
        int count = 3;
        List<Lotto> lottos = generator.generateLottos(count);
        for (Lotto lotto : lottos) {
            List<Integer> numbers = lotto.getNumbers();
            assertEquals(6, numbers.size(), "각 로또는 6개의 번호를 가져야 합니다.");
            assertEquals(6, numbers.stream().distinct().count(), "로또 번호는 중복되지 않아야 합니다.");
        }
    }

    @Test
    @DisplayName("로또 번호는 1부터 45 사이여야 한다.")
    void 로또_번호는_1부터_45_사이여야_한다() {
        int count = 3;
        List<Lotto> lottos = generator.generateLottos(count);
        for (Lotto lotto : lottos) {
            for (int number : lotto.getNumbers()) {
                assertTrue(number >= 1 && number <= 45, "로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    @Test
    @DisplayName("로또 번호는 오름차순으로 정렬되어야 한다.")
    void 로또_번호는_오름차순으로_정렬되어야_한다() {
        int count = 3;
        List<Lotto> lottos = generator.generateLottos(count);
        for (Lotto lotto : lottos) {
            List<Integer> numbers = lotto.getNumbers();
            // 가변 리스트로 복사
            List<Integer> sortedNumbers = new ArrayList<>(numbers);
            sortedNumbers.sort(Integer::compareTo);
            assertEquals(sortedNumbers, numbers, "로또 번호는 오름차순으로 정렬되어야 합니다.");
        }
    }

}
