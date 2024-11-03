package lotto.util;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.controller.LottoController;
import lotto.view.LottoView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SingletonObjectProviderTest {

    @DisplayName("싱글톤 객체 동일성 확인")
    @Test
    void getSingletonObjectTrue() {
        //given
        LottoController singletonObject = SingletonObjectProvider.getSingletonObject(LottoController.class);

        //when
        LottoController object = SingletonObjectProvider.getSingletonObject(LottoController.class);

        //then
        assertThat(singletonObject).isEqualTo(object);
    }

    @DisplayName("싱글톤 객체 동일성X 확인")
    @Test
    void getSingletonObjectFalse() {
        //given
        LottoController singletonObject = SingletonObjectProvider.getSingletonObject(LottoController.class);

        //when
        LottoView object = SingletonObjectProvider.getSingletonObject(LottoView.class);

        //then
        assertThat(singletonObject).isNotEqualTo(object);
    }
}