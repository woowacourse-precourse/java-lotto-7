package lotto.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoGeneratorTest {

    @Test
    @DisplayName("구입 금액이 0일 때 로또 번호 생성이 비어있어야 한다.")
    void generateLottoNumbers_zeroCount() {
        int count = 0;
        List<List<Integer>> lottos = LottoGenerator.generateLottoNumbers(count);
        assertNotNull(lottos, "로또 리스트는 null이 아니어야 합니다.");
        assertTrue(lottos.isEmpty(), "구입 금액이 0일 때 로또 리스트는 비어있어야 합니다.");
    }

    @Test
    @DisplayName("구입 금액에 따른 로또 개수가 정확히 생성되어야 한다.")
    void generateLottoNumbers_correctLottoCount() {
        int count = 5;
        List<List<Integer>> lottos = LottoGenerator.generateLottoNumbers(count);
        assertNotNull(lottos, "로또 리스트는 null이 아니어야 합니다.");
        assertEquals(count, lottos.size(), "로또 개수가 입력값과 일치해야 합니다.");
    }

    @Test
    @DisplayName("각 로또는 정확히 6개의 번호를 가져야 한다.")
    void generateLottoNumbers_eachLottoHasSixNumbers() {
        int count = 3;
        List<List<Integer>> lottos = LottoGenerator.generateLottoNumbers(count);
        for (List<Integer> lotto : lottos) {
            assertEquals(6, lotto.size(), "각 로또는 정확히 6개의 번호를 가져야 합니다.");
        }
    }

    @Test
    @DisplayName("각 로또의 번호는 1부터 45 사이의 숫자여야 한다.")
    void generateLottoNumbers_numbersInRange() {
        int count = 3;
        List<List<Integer>> lottos = LottoGenerator.generateLottoNumbers(count);
        for (List<Integer> lotto : lottos) {
            for (int number : lotto) {
                assertTrue(number >= 1 && number <= 45, "로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    @Test
    @DisplayName("각 로또의 번호는 중복되지 않아야 한다.")
    void generateLottoNumbers_uniqueNumbers() {
        int count = 3;
        List<List<Integer>> lottos = LottoGenerator.generateLottoNumbers(count);
        for (List<Integer> lotto : lottos) {
            Set<Integer> uniqueNumbers = new HashSet<>(lotto);
            assertEquals(6, uniqueNumbers.size(), "로또 번호는 중복되지 않아야 합니다.");
        }
    }

    @Test
    @DisplayName("각 로또의 번호는 오름차순으로 정렬되어야 한다.")
    void generateLottoNumbers_sortedNumbers() {
        int count = 3;
        List<List<Integer>> lottos = LottoGenerator.generateLottoNumbers(count);
        for (List<Integer> lotto : lottos) {
            for (int i = 0; i < lotto.size() - 1; i++) {
                assertTrue(lotto.get(i) <= lotto.get(i + 1), "로또 번호는 오름차순으로 정렬되어야 합니다.");
            }
        }
    }

    @Test
    @DisplayName("여러 로또를 생성할 때 모든 로또는 고유해야 한다.")
    void generateLottoNumbers_uniqueLottos() {
        int count = 100;
        List<List<Integer>> lottos = LottoGenerator.generateLottoNumbers(count);
        Set<List<Integer>> uniqueLottos = new HashSet<>(lottos);
        assertEquals(count, uniqueLottos.size(), "모든 로또는 고유해야 합니다.");
    }

    @Test
    @DisplayName("구입 금액이 음수일 때 로또가 생성되지 않아야 한다.")
    void generateLottoNumbers_negativeCount() {
        int count = -5;
        List<List<Integer>> lottos = LottoGenerator.generateLottoNumbers(count);
        assertNotNull(lottos, "로또 리스트는 null이 아니어야 합니다.");
        assertTrue(lottos.isEmpty(), "구입 금액이 음수일 때 로또 리스트는 비어있어야 합니다.");
    }

    @Test
    @DisplayName("로또 번호 생성 시 중복된 로또가 생성되지 않아야 한다.")
    void generateLottoNumbers_noDuplicateLottos() {
        int count = 1000;
        List<List<Integer>> lottos = LottoGenerator.generateLottoNumbers(count);
        Set<List<Integer>> uniqueLottos = new HashSet<>(lottos);
        assertEquals(count, uniqueLottos.size(), "중복된 로또가 생성되지 않아야 합니다.");
    }
}
