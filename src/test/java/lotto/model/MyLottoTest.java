package lotto.model;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MyLottoTest {
    @Test
    @DisplayName("나의 로또 객체를 생성할 수 있다.")
    void should_CreateMyLotto_When_GivenLottos() {
        //given
        List<Lotto> lottos = Arrays.asList(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        //when
        MyLotto myLotto = new MyLotto(lottos);
        //then
        Assertions.assertThat(myLotto).isNotNull();
    }

}