package lotto.model;

import java.util.ArrayList;
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
        List<Lotto> lottos = List.of(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        //when
        MyLotto myLotto = new MyLotto(lottos);
        //then
        Assertions.assertThat(myLotto).isNotNull();
    }

    @Test
    @DisplayName("나의 로또 리스트를 반환한다.")
    void should_ReturnLottos_When_GivenLottos() {
        //given
        List<Lotto> lottos = Arrays.asList(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        MyLotto myLotto = new MyLotto(lottos);
        //when
        List<Lotto> result = myLotto.getLottos();
        //then
        Assertions.assertThat(result).isEqualTo(lottos);

    }

    @Test
    @DisplayName("나의 로또에 로또를 추가할 수 있다.")
    void should_AddLotto_When_GivenLotto() {
        //given
        List<Lotto> lottos = new ArrayList<>();
        MyLotto myLotto = new MyLotto(lottos);
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7));
        //when
        myLotto.addLotto(lotto);
        //then
        Assertions.assertThat(myLotto.getLottos().size()).isEqualTo(1);
    }
}