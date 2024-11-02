package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Service.IssueMyLottoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;

public class IssueMyLottosTest extends NsTest {
    IssueMyLottoService issueMyLottoService = new IssueMyLottoService();

    @DisplayName("로또_발행: 티켓 개수를 입력받아 로또 번호를 생성한다.")
    @Test
    void 알맞는_개수의_로또_번호를_만든다() {
        assertRandomUniqueNumbersInRangeTest(() -> {
                    issueMyLottoService.issueMyLottos(3).getLottos().equals(List.of(
                            List.of(8, 21, 23, 41, 42, 43),
                            List.of(3, 5, 11, 16, 32, 38),
                            List.of(7, 11, 16, 35, 36, 44)
                    ));
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
