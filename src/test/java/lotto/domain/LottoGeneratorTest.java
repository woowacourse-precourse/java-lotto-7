package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static lotto.domain.LottoGenerator.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoGeneratorTest {

    private LottoGenerator lottoGenerator;

    @BeforeEach
    void setUp() {
        lottoGenerator = new LottoGenerator();
    }

    @Test
    void 번호_6개_생성() {
        assertEquals(COUNT, lottoGenerator.lottoNumbers().size());
    }

    @Test
    void 번호_범위_검증() {
        assertThat(lottoGenerator.lottoNumbers())
                .allMatch(number -> number >= START_INCLUSIVE && number <= END_INCLUSIVE);
    }

    @Test
    void 번호_중복_검증() {
        assertThat(lottoGenerator.lottoNumbers()).doesNotHaveDuplicates();
    }
}
