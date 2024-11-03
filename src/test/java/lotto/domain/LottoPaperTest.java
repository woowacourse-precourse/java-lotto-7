package lotto.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LottoPaperTest {

    private static final int lottoCount = 5;

    @Test
    @DisplayName("LottoPaper가 지정된 수의 로또를 생성하는지 테스트")
    void makeLottoPaperCreatesCorrectNumberOfLottos() {

        LottoPaper lottoPaper = LottoPaper.makeLottoPaper(lottoCount);

        Assertions.assertEquals(lottoCount, lottoPaper.getLottoCount());
    }

    @Test
    @DisplayName("생성된 로또 번호가 6개의 숫자로 이루어졌는지 테스트")
    void eachLottoHasSixNumbers() {
        LottoPaper lottoPaper = LottoPaper.makeLottoPaper(lottoCount);
        List<List<Integer>> lottoNumbers = lottoPaper.getLottoNumbers();

        for (List<Integer> numbers : lottoNumbers) {
            Assertions.assertEquals(6, numbers.size());
        }
    }

    @Test
    @DisplayName("각 로또 번호가 1에서 45 사이의 숫자로 구성되었는지 테스트")
    void eachLottoHasValidNumbers() {
        LottoPaper lottoPaper = LottoPaper.makeLottoPaper(lottoCount);
        List<List<Integer>> lottoNumbers = lottoPaper.getLottoNumbers();

        for (List<Integer> numbers : lottoNumbers) {
            for (Integer number : numbers) {
                Assertions.assertTrue(number >= 1 && number <= 45);
            }
        }
    }

    @Test
    @DisplayName("로또 번호가 중복되지 않는지 테스트")
    void eachLottoHasNoDuplicateNumbers() {
        LottoPaper lottoPaper = LottoPaper.makeLottoPaper(lottoCount);
        List<List<Integer>> lottoNumbers = lottoPaper.getLottoNumbers();

        for (List<Integer> numbers : lottoNumbers) {
            int distinctCount = (int) numbers.stream().distinct().count();
            Assertions.assertEquals(6, distinctCount);
        }
    }
}
