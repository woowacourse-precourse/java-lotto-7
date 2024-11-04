package lotto.lottoMachine;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

class LottoNumberGeneratorTest extends NsTest {

    @DisplayName("로또 번호가 범위 내에서 올바르게 생성되는지 테스트")
    @Test
    void 로또_번호가_범위_내에서_올바르게_생성되는지_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    LottoNumberGenerator generator = new LottoNumberGenerator();
                    List<Integer> generatedLottoNumbers = generator.generateLottoNumbers();

                    // Then
                    assertThat(generatedLottoNumbers).containsExactly(3, 8, 15, 21, 36, 42);
                },
                List.of(3, 8, 15, 21, 36, 42) // 테스트용으로 설정된 로또 번호
        );
    }

    @DisplayName("로또 번호가 오름차순으로 정렬되어 반환되는지 테스트")
    @Test
    void 로또_번호가_오름차순으로_정렬되어_반환되는지_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    LottoNumberGenerator generator = new LottoNumberGenerator();
                    List<Integer> generatedLottoNumbers = generator.generateLottoNumbers();

                    // Then
                    List<Integer> sortedLottoNumbers = List.of(5, 11, 16, 23, 34, 45);
                    assertThat(generatedLottoNumbers).isEqualTo(sortedLottoNumbers);
                },
                List.of(45, 11, 16, 23, 34, 5) // 테스트용으로 설정된 로또 번호
        );
    }

    @Override
    public void runMain() {
    }
}
