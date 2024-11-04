package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GeneratorTest extends NsTest {

    @Test
    void 자동생성된_로또_번호와_결과_테스트() {

        String input = "7";
        System.setIn(new ByteArrayInputStream(input.getBytes()));


        Genarator generator = new Genarator();
        List<Lotto> generatedLottos = generator.autoGen();

        int expectedSize = Integer.parseInt(input.trim());
        assertThat(generatedLottos).hasSize(expectedSize);
        for (Lotto lotto : generatedLottos) {
            assertThat(lotto.getNumbers())
                    .hasSize(6)
                    .allMatch(number -> number >= 1 && number <= 45)
                    .doesNotHaveDuplicates();
        }

    }

    @Override
    protected void runMain() {

    }
}