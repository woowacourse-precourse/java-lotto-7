package lotto.model.generator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LottoNumberGeneratorTest {
    @DisplayName("6개의 숫자가 생성되고, 중복이 없으며, 정렬된 상태로 반환되는지 테스트")
    @Test
     void generateLottoNumberTest() {
        LottoNumberGenerator generator = new LottoNumberGenerator();
        List<Integer> lottoNumbers = generator.generateLottoNumber();

        assertEquals(6, lottoNumbers.size());

        assertEquals(6, new HashSet<>(lottoNumbers).size());

        for (int i = 0; i < lottoNumbers.size() - 1; i++) {
            assertTrue(lottoNumbers.get(i) < lottoNumbers.get(i + 1));
        }

        for (int number : lottoNumbers) {
            assertTrue(number >= 1 && number <= 45);
        }
    }
}
