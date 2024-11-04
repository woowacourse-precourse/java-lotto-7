package lotto.vendingmachine;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.AppConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
                    for (Lotto lotto : lottos) {
                        output.add(lotto.toString());
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

    @Test
    @DisplayName("로또 저장 테스트")
    void 로또_저장_테스트() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1,2,3,4,5,6)));
        lottos.add(new Lotto(List.of(7,8,9,10,11,12)));

        Set<CharSequence> output = new HashSet<>();
        vendingMachineService.recordLottos(lottos);
        for (Lotto lotto : vendingMachineService.getIssuedLottoTickets()) {
            output.add(lotto.toString());
        }

        assertThat(output).contains(
                "[1, 2, 3, 4, 5, 6]",
                "[7, 8, 9, 10, 11, 12]"
        );
    }
}