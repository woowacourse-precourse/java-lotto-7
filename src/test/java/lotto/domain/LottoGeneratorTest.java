package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class LottoGeneratorTest {

    @Test
    void 로또_번호_생성_테스트(){
        List<Lotto> lottos = LottoGenerator.generateLottos(5);

        assertThat(lottos).hasSize(5);
        for(Lotto lotto : lottos){
            assertThat(lotto.getNumbers()).hasSize(6).doesNotHaveDuplicates().isSorted();
        }
    }
}
