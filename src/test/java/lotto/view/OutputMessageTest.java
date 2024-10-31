package lotto.view;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class OutputMessageTest {

    @Test
    void 로또_구매수량에_대한_메시지가_정확하게_들어있는지_확인() {

        int lottoQuantity = 3;

        assertThat(OutputMessage.OUTPUT_PURCHASE_QUANTITY.format(lottoQuantity))
                .isEqualTo(String.format("\n%d개를 구매했습니다.", lottoQuantity));
    }
    
}