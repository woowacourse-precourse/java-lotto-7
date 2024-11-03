package lotto.commons.beans;

import lotto.core.controller.PurchaseLottoController;
import lotto.core.service.CreateBonusLottoNumberService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BeanFactoryTest {

    @Test
    void getBean_always_equals_instance() {
        // given
        // when
        var aInstance = BeanFactory.getBean(PurchaseLottoController.class);
        var bInstance = BeanFactory.getBean(PurchaseLottoController.class);
        var cInstance = BeanFactory.getBean(CreateBonusLottoNumberService.class);
        var dInstance = BeanFactory.getBean(CreateBonusLottoNumberService.class);
        // then
        Assertions.assertEquals(aInstance.hashCode(), bInstance.hashCode());
        Assertions.assertEquals(aInstance, bInstance);
        Assertions.assertNotEquals(aInstance.hashCode(), cInstance.hashCode());
        Assertions.assertNotEquals(aInstance, cInstance);
        Assertions.assertEquals(cInstance.hashCode(), dInstance.hashCode());
        Assertions.assertEquals(cInstance, dInstance);
    }
}
