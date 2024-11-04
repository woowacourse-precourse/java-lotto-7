package lotto.util;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LottoUtilsTest {

    @Test
    public void 로또번호_생성_테스트() {
        List<Integer> lottoNumbers = LottoUtils.generateRandomLottoNumbers();

        assertEquals(6, lottoNumbers.size());
        assertTrue(lottoNumbers.stream().allMatch(num -> num >= 1 && num <= 45));
        assertEquals(lottoNumbers.size(), lottoNumbers.stream().distinct().count());
    }
}
