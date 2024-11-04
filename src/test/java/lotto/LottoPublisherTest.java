package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoPublisherTest {
    @Test
    void 발행을_요청한_개수만큼_로또가_발행_되어야_한다() {
        //when
        List<Lotto> lottos = LottoPublisher.generateLotto(5);

        //then
        assertThat(lottos).hasSize(5);
    }

}