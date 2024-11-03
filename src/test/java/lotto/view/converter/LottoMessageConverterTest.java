package lotto.view.converter;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoMessageConverterTest {

    private LottoMessageConverter lottoMessageConverter = new LottoMessageConverter();

    @DisplayName("로또 객체들을 출력형식과 맞게 변환시켜준다")
    @Test
    void convertToMessage() {
      // given
        List<Lotto> lottos = List.of(
                new Lotto(Arrays.asList(1,2,3,4,5,6)),
                new Lotto(Arrays.asList(2,3,4,5,6,7)),
                new Lotto(Arrays.asList(3,4,5,6,7,8))
        );
      // when
        List<String> messages = lottoMessageConverter.convert(lottos);
      // then
        assertEquals(3, messages.size());
        assertThat(messages.get(0)).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }
}
