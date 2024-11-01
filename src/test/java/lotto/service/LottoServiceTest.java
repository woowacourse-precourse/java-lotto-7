package lotto.service;

import lotto.model.Lotto;
import lotto.utils.LottoRules;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoServiceTest {
    private static final LottoService lottoService = new LottoService();

    @Test
    @DisplayName("로또 발행하기")
    void lottoGenerate() {
        Assertions.assertThat(lottoService.generateLotto()).isInstanceOf(Lotto.class);
    }

}