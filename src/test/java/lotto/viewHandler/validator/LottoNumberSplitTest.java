package lotto.viewHandler.validator;

import lotto.viewHandler.exception.NotLottoNumberSize;
import lotto.viewHandler.validator.validatorImpl.LottoNumberSplit;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberSplitTest {
    private final LottoNumberSplit lottoNumberSplit;

    public LottoNumberSplitTest() {
        this.lottoNumberSplit = new LottoNumberSplit();
    }

    @Test
    void 정상_작동_확인() {
        String input = "1,2,3,4,5,6";
        List<String> expect = List.of("1", "2", "3", "4", "5", "6");
        List<String> result = lottoNumberSplit.validate(input);
        assertThat(result).isEqualTo(expect);
    }

    @Test
    void 검증_확인() {
        String input = "1,23,4,5,6";
        assertThatThrownBy(() -> {
            lottoNumberSplit.validate(input);
        }).isInstanceOf(NotLottoNumberSize.class);
    }
}