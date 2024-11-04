package lotto.back.support;

import lotto.back.global.support.ApplicationContext;
import lotto.back.global.support.BeanConfig;
import lotto.back.lotto.controller.LottoController;
import lotto.back.lotto.repository.PrizeLottoRepository;
import lotto.back.lotto.repository.PurchasedLottosRepository;
import lotto.back.lotto.service.LottoService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BeanConfigTest {

    @BeforeAll
    static void setUp() {
        ApplicationContext.init();
    }

    @ParameterizedTest
    @ValueSource(classes = {
            LottoController.class,
            LottoService.class,
            PurchasedLottosRepository.class,
            PrizeLottoRepository.class
    })
    void 빈_생성_테스트(Class<?> beanClass) {
        // given
        Object bean = BeanConfig.getBean(beanClass);

        // when, then
        Assertions.assertThat(bean)
                .isNotNull()
                .isInstanceOf(beanClass);
    }
}