package lotto.service;

import lotto.HtTest;
import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineServiceTest extends HtTest {
    private final LottoMachineService lottoMachineService = new LottoMachineService();

    @Test
    void 삼천원_구매_테스트() {
        input("3000\n");
        lottoMachineService.purchaseLotto();

        assertThat(output()).contains("3개를 구매했습니다.");

        Pattern lottoPattern = Pattern.compile("\\[(1|[1-9]|[1-3][0-9]|4[0-5]), (1|[1-9]|[1-3][0-9]|4[0-5]), (1|[1-9]|[1-3][0-9]|4[0-5]), (1|[1-9]|[1-3][0-9]|4[0-5]), (1|[1-9]|[1-3][0-9]|4[0-5]), (1|[1-9]|[1-3][0-9]|4[0-5])]");

        long matchCount = output().lines()
                .filter(line -> lottoPattern.matcher(line).matches())
                .count();

        assertThat(matchCount).isEqualTo(3);
    }
}