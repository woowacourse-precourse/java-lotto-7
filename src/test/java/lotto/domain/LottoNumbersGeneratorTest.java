package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumbersGeneratorTest {

    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;
    private static final int PICK_COUNT = 6;

    @Test
    @DisplayName("생성된 로또 번호가 오름차순인지 확인")
    void lottoNumbersAscendingOrderTest() {
        List<Integer> testLottoNumbers = LottoNumbersGenerator.generate();

        assertThat(testLottoNumbers)
                .isSortedAccordingTo(Comparator.naturalOrder());
    }

    @Test
    @DisplayName("생성된 로또 번호의 범위가 1~45 인지 확인")
    void lottoNumberRangeTest() {

        List<Integer> testLottoNumbers = LottoNumbersGenerator.generate();

        for (int lottoNumber : testLottoNumbers) {
            assertThat(lottoNumber).isBetween(START_NUMBER, END_NUMBER);
        }
    }

    @Test
    @DisplayName("생성된 로또 번호가 6개인지 확인")
    void lottoNumbersPickCountTest() {
        List<Integer> testLottoNumbers = LottoNumbersGenerator.generate();

        assertThat(testLottoNumbers.size()).isEqualTo(PICK_COUNT);
    }

    @Test
    @DisplayName("생성된 로또 번호가 중복되지 않는지 확인")
    void lottoNumbersNotDuplicatedTest() {
        List<Integer> testLottoNumbers = LottoNumbersGenerator.generate();
        Set<Integer> distinctLottoNumbers = new HashSet<>(testLottoNumbers);

        assertThat(testLottoNumbers.size())
                .isEqualTo(distinctLottoNumbers.size());
    }

}