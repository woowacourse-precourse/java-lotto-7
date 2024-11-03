package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import lotto.constant.ExceptionMessage;
import lotto.entity.BonusNumber;
import lotto.entity.IssuedLotto;
import lotto.entity.Lotto;
import lotto.entity.PurchaseAmount;
import lotto.entity.WinnerNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class LotteryMachineModelTest {

    private LotteryMachineModel lotteryMachineModel;

    @BeforeEach
    void init() {
        lotteryMachineModel = new LotteryMachineModel();
    }

    @Test
    void 기본_생성자는_로또구매금액을_0으로_초기화한다() {
        // given

        // when

        // then
        assertThat(lotteryMachineModel.getPurchaseAmount().purchaseAmount()).isEqualTo(0L);
    }

    @ParameterizedTest
    @ValueSource(longs = {1000L, (Long.MAX_VALUE - Long.MAX_VALUE % 1000)})
    void insertPurchaseAmount_로또구매금액_저장에_성공한다(Long insertPurchaseAmount) {
        // given
        PurchaseAmount purchaseAmount = new PurchaseAmount(insertPurchaseAmount);

        // when
        lotteryMachineModel.insertPurchaseAmount(purchaseAmount);

        // then
        assertThat(lotteryMachineModel.getPurchaseAmount().purchaseAmount()).isEqualTo(insertPurchaseAmount);
    }

    @Test
    void insertPurchaseAmount_0원은_입력할_수_없다() {
        // given
        Long insertPurchaseAmount = 0L;
        PurchaseAmount purchaseAmount = new PurchaseAmount(insertPurchaseAmount);

        // when

        // then
        assertThatThrownBy(() -> lotteryMachineModel.insertPurchaseAmount(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .extracting(Throwable::getMessage)
                .isEqualTo(ExceptionMessage.PURCHASE_AMOUNT_IS_POSITIVE);
    }

    @ParameterizedTest
    @MethodSource("lotto.parameterizedTest.MethodSource#provideLottoNumbers")
    void settingWinnerNumber_당첨번호_저장에_성공한다(List<Integer> winnerNumbers) {
        // given
        WinnerNumber winnerNumber = new WinnerNumber(winnerNumbers);

        // when
        lotteryMachineModel.settingWinnerNumber(winnerNumber);

        // then
        assertThat(lotteryMachineModel.getWinnerNumber().numbers()).isEqualTo(winnerNumbers);
    }

    @ParameterizedTest
    @MethodSource("lotto.parameterizedTest.MethodSource#generateNormalLottoNumber")
    void settingBonusNumber_당첨번호_저장에_성공한다(Integer number) {
        // given
        List<Integer> winnerNumbers = List.of(1, 2, 3, 4, 5, 6);
        lotteryMachineModel.settingWinnerNumber(new WinnerNumber(winnerNumbers));
        if (winnerNumbers.contains(number)) {
            return;
        }

        BonusNumber bonusNumber = new BonusNumber(number);

        // when
        lotteryMachineModel.settingBonusNumber(bonusNumber);

        // then
        assertThat(lotteryMachineModel.getBonusNumber().number()).isEqualTo(number);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void settingBonusNumber_당첨번호와_중복되어_실패한다(Integer number) {
        // given
        List<Integer> winnerNumbers = List.of(1, 2, 3, 4, 5, 6);
        WinnerNumber winnerNumber = new WinnerNumber(winnerNumbers);
        lotteryMachineModel.settingWinnerNumber(winnerNumber);

        BonusNumber bonusNumber = new BonusNumber(number);

        // when

        // then
        assertThatThrownBy(() -> lotteryMachineModel.settingBonusNumber(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .extracting(Throwable::getMessage)
                .isEqualTo(ExceptionMessage.BONUS_NUMBER_DUPLICATED);
    }

    @ParameterizedTest
    @MethodSource("lotto.parameterizedTest.MethodSource#provideLottoNumbers")
    void settingIssuedLotto_발매된_로또_저장에_성공한다(List<Integer> numbers) {
        // given
        Lotto lotto = new Lotto(numbers);
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(lotto);
        IssuedLotto issuedLotto = new IssuedLotto(lottos);

        // when
        lotteryMachineModel.settingIssuedLotto(issuedLotto);

        // then
        assertThat(lotteryMachineModel.getIssuedLotto().lottos()).isEqualTo(lottos);
    }

    @Test
    void consumePurchaseAmount_구매금액_소모에_성공한다() {
        // given
        PurchaseAmount purchaseAmount = new PurchaseAmount(8000L);
        lotteryMachineModel.insertPurchaseAmount(purchaseAmount);

        // when
        lotteryMachineModel.consumePurchaseAmount();

        // then
        assertThat(lotteryMachineModel.getPurchaseAmount().purchaseAmount()).isEqualTo(0L);
    }
}