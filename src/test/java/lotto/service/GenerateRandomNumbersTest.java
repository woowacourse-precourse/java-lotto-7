package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

class GenerateRandomNumbersTest {

    private GenerateRandomNumbers generateRandomNumbers;

    @BeforeEach
    void setUp() {
        generateRandomNumbers = new GenerateRandomNumbers();
    }

    @RepeatedTest(100)
    void 로또_번호_생성_테스트() {
        List<Integer> lottoNumbers = generateRandomNumbers.generateLottoNumbers();

        assertThat(lottoNumbers).hasSize(6);
        assertThat(lottoNumbers).doesNotHaveDuplicates();
        assertThat(lottoNumbers).allMatch(num -> num >= 1 && num <= 45);
        assertThat(lottoNumbers).isSorted();
    }
}
