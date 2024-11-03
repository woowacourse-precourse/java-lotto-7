package lotto.utils;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GeneratorTest {

    @DisplayName("LottoNumberGenerate_메서트_테스트_01")
    @Test
    void _1부터_45까지_숫자를_6개_랜덤_생성한다() {
        List<Integer> lottoNumbers = Generator.lottoNumberGenerate();

        assertThat(lottoNumbers).hasSize(6);
        assertThat(new HashSet<>(lottoNumbers)).hasSize(6);
    }
}
