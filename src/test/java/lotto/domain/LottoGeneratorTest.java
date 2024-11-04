package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Test;

public class LottoGeneratorTest {

    @Test
    void 로또_번호_생성_테스트(){
        LottoGenerator generator = new LottoGenerator();
        Lotto lotto = generator.generateLotto();
        List<Integer> lottoNumbers = lotto.getNumbers();

        assertEquals(6, lottoNumbers.size());
        assertTrue(lottoNumbers.stream().allMatch(n -> n >= 1 && n <= 45));

        Set<Integer> uniqueNumbers = new HashSet<>(lottoNumbers);
        assertEquals(6, uniqueNumbers.size());
    }
}
