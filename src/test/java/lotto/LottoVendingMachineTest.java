package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DisplayName("로또 자판기 테스트")
public class LottoVendingMachineTest {

    @Nested
    @DisplayName("예외처리 테스트")
    class ValidationTest {


        @Test
        void 로또_구입_금액의_범위는_1000원_이상_50000원_이하이다() {

            LottoVendingMachine machine = new LottoVendingMachine();

            String minMoney = "0";
            String maxMoney = "51000";


            assertThat(machine.validateMoney(minMoney))
                    .isEqualTo(false);

            assertThat(machine.validateMoney(maxMoney))
                    .isEqualTo(false);
        }

        @Test
        void 로또_구입_금액은_1000원으로_나누어_떨어져야_한다() {

            LottoVendingMachine machine = new LottoVendingMachine();

            String minRemainMoney = "1001";
            String maxRemainMoney = "1999";

            assertThat(machine.validateMoney(minRemainMoney))
                    .isEqualTo(false);

            assertThat(machine.validateMoney(maxRemainMoney))
                    .isEqualTo(false);

        }

        @Test
        void 로또_구입_금액은_숫자로_입력받아야_한다(){

            LottoVendingMachine machine = new LottoVendingMachine();

            String money = "1000r";

            assertThat(machine.validateMoney(money))
                    .isEqualTo(false);

        }
    }

    @Test
    void 사용자가_구입한_금액_1000원_당_하나의_복권이_생성되어야_한다(){

        LottoVendingMachine machineTestMin = new LottoVendingMachine();
        LottoVendingMachine machineTestMax = new LottoVendingMachine();

        int minMoney = 1000;
        int maxMoney = 50000;

        int minAssertSize = 1;
        int maxAssertSize = 50;

        List<Lotto> minLottos = machineTestMin.createLottos(minMoney);
        List<Lotto> maxLottos = machineTestMax.createLottos(maxMoney);

        assertThat(minLottos.size()).isEqualTo(minAssertSize);
        assertThat(maxLottos.size()).isEqualTo(maxAssertSize);

    }

}
