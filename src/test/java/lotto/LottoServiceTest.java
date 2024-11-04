package lotto;

import lotto.Service.LottoService;
import lotto.model.Lotto;
import lotto.validator.InputValidator;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class LottoServiceTest {
    private final InputValidator validator = new InputValidator();
    private final LottoService lottoService = new LottoService(validator);

    @Test
    void testLottoCreation_ValidNumbers() {
        List<Integer> validWinningNumbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(validWinningNumbers);

        assertNotNull(lotto);
        assertEquals(6, lotto.getNumbers().size());
        assertTrue(lotto.getNumbers().containsAll(validWinningNumbers));
    }


    @Test
    void testLottoCreation_DuplicateNumbers() {
        // 중복된 당첨 번호를 입력했을 때 IllegalArgumentException이 발생해야 함
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            // 유효성 검사를 우회하기 위해 직접 Lotto 객체 생성
            new Lotto(List.of(1, 1, 2, 3, 4, 5));
        });
        assertEquals("[ERROR] 로또 번호는 중복될 수 없습니다.", exception.getMessage());
    }

    @Test
    void testLottoCreation_InsufficientNumbers() {
        // 6개 미만의 번호를 입력했을 때 IllegalArgumentException이 발생해야 함
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Lotto(List.of(1, 2, 3));
        });
        assertEquals("[ERROR] 로또 번호는 6개여야 합니다.", exception.getMessage());
    }

    @Test
    void testLottoCreation_ExcessNumbers() {
        // 6개 초과의 번호를 입력했을 때 IllegalArgumentException이 발생해야 함
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Lotto(List.of(1, 2, 3, 4, 5, 6, 7));
        });
        assertEquals("[ERROR] 로또 번호는 6개여야 합니다.", exception.getMessage());
    }

    @Test
    void testGenerateLottoNumbers_withValidAmount() {
        int amount = 8;
        List<Lotto> lottoList = lottoService.generateLottoNumbers(amount);

        assertEquals(amount, lottoList.size());

        for (Lotto lotto : lottoList) {
            List<Integer> numbers = lotto.getNumbers();

            assertEquals(6, numbers.size());

            assertTrue(numbers.stream().allMatch(num -> num >= 1 && num <= 45));

            assertEquals(6, numbers.stream().distinct().count());

            List<Integer> sortedNumbers = numbers.stream().sorted().collect(Collectors.toList());
            assertEquals(sortedNumbers, numbers);
        }
    }
}

