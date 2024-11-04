package lotto;



import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGeneratorTest {

    @Test
    @DisplayName("로또 번호 발행 개수 테스트")
    void testGenerateLottosCount() {
        int purchaseAmount = 5000;  // 5,000원 -> 5개의 로또 발행
        List<Lotto> lottos = LottoGenerator.generateLottos(purchaseAmount);

        Assertions.assertEquals(5, lottos.size(), "발행된 로또 개수가 일치해야 합니다.");
    }

    @Test
    @DisplayName("로또 번호의 유효성 테스트 - 각 번호는 6개이고 중복되지 않아야 한다")
    void testLottoNumbersValidity() {
        List<Integer> numbers = LottoGenerator.generateLottos(1000).get(0).getNumbers();

        Assertions.assertEquals(6, numbers.size(), "로또 번호는 6개여야 합니다.");

        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        Assertions.assertEquals(6, uniqueNumbers.size(), "로또 번호는 중복되지 않아야 합니다.");
    }

    @Test
    @DisplayName("로또 번호의 범위 테스트 - 번호는 1부터 45 사이여야 한다")
    void testLottoNumbersRange() {
        List<Integer> numbers = LottoGenerator.generateLottos(1000).get(0).getNumbers();

        boolean allInRange = numbers.stream().allMatch(num -> num >= 1 && num <= 45);
        Assertions.assertTrue(allInRange, "모든 로또 번호는 1부터 45 사이여야 합니다.");
    }

    @Test
    @DisplayName("로또 번호 정렬 테스트 - 오름차순으로 정렬되어야 한다")
    void testLottoNumbersSorted() {
        List<Integer> numbers = LottoGenerator.generateLottos(1000).get(0).getNumbers();

        for (int i = 0; i < numbers.size() - 1; i++) {
            Assertions.assertTrue(numbers.get(i) < numbers.get(i + 1), "로또 번호는 오름차순으로 정렬되어야 합니다.");
        }
    }
}