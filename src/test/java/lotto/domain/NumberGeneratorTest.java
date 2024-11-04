package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.HashSet;
import java.util.List;
import static org.assertj.core.api.Assertions.*;

class NumberGeneratorTest {

    private final NumberGenerator numberGenerator = new NumberGenerator();

    @DisplayName("구매한 수량만큼 로또 번호 생성하는 기능 테스트")
    @Test
    void 생성된_로또_번호_리스트의_크기는_구매한_수량과_같아야_한다() {
        int numberOfTickets = 5;
        List<Lotto> generatedLottos = numberGenerator.generatingNumbers(numberOfTickets);
        assertThat(generatedLottos).hasSize(numberOfTickets);
    }

    @DisplayName("구매한 수량만큼 로또 번호 생성하는 기능 테스트")
    @Test
    void 생성된_로또_번호는_6개여야_하고_1부터_45_사이여야_한다() {
        List<Lotto> generatedLottos = numberGenerator.generatingNumbers(5);

        for (Lotto lotto : generatedLottos) {
            List<Integer> numbers = lotto.getNumbers();

            assertThat(numbers).hasSize(6);
            assertThat(new HashSet<>(numbers)).hasSize(6);
            assertThat(numbers).allMatch(num -> num >= 1 && num <= 45)
                    .isSorted();
        }
    }
}
