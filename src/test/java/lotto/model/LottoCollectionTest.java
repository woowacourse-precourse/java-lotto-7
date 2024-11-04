package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class LottoCollectionTest {

    @Test
    void toString_양식() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Lotto> lottos = List.of(lotto, lotto);
        LottoCollection lottoCollection = new LottoCollection(lottos);

        // when
        String result = lottoCollection.toString();

        // then
        assertThat(result).isEqualTo("[1, 2, 3, 4, 5, 6]\n[1, 2, 3, 4, 5, 6]\n");
    }


}