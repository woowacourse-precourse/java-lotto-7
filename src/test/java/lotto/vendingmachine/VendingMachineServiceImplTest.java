package lotto.vendingmachine;

import lotto.AppConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

class VendingMachineServiceImplTest {

    VendingMachineService vendingMachineService;

    @BeforeEach
    void beforeEach() {
        AppConfig appConfig = new AppConfig();
        vendingMachineService = appConfig.vendingMachineService();
    }

    @Test
    @DisplayName("로또 생성 테스트")
    void 로또_생성_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    List<Lotto> lottos = vendingMachineService.generate(3);
                    Set<CharSequence> output = new HashSet<>();
                    for (int i = 0; i < 3; i++) {
                        output.add(lottos.get(i).toString());
                    }

                    assertThat(output).contains(
                            "[8, 21, 23, 41, 42, 43]",
                            "[3, 5, 11, 16, 32, 38]",
                            "[7, 11, 16, 35, 36, 44]"
                    );
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44)
        );
    }
}