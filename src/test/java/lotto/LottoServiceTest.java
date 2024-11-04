package lotto;

import java.util.List;
import lotto.util.LottoPrizeRankType;
import lotto.util.WinningLottoStore;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoServiceTest {

    LottoManager lottoManager;
    LottoService lottoService;

    @BeforeEach
    void init() {
        WinningLottoStore.setUpLottoStore(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);
        lottoManager = new LottoManager();
        lottoService = new LottoService(lottoManager);
    }
    @DisplayName("로또 구입 금액이 판매금액으로 나누어지지 않으면 예외 발생한다. ")
    @Test
    void invalidLottoAmount() {
        final String purchaseLottoAmount = "14100";
        Assertions.assertThatThrownBy(
                () -> lottoService.purchaseLottoTickets(purchaseLottoAmount))
                        .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 판매 금액(1000원)에 맞게 입력해주세요.");
    }

    @DisplayName("포맷에 맞지 않은 당첨번호와 보너스번호를 입력하면 예외 발생한다.")
    @Test
    void invalidInputLottoNumbers() {
        final String invalidDelimiter = "1,2,3#4,5,6";
        final String invalidLength = "1,2,3,4,5";
        final String invlaidNum = "a,2,3,4,5,6";
        final String overHeadNum = "46,2,3,4,5,6";
        final String validWinningNum = "1,2,3,4,5,6";
        final String bonusNum = "7";
        final String invalidBonusNum = "a";
        SoftAssertions softAssertions = new SoftAssertions();

        softAssertions.assertThatThrownBy(
                        () -> lottoService.setWinningLottoStore(invalidDelimiter, bonusNum))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자를 입력하세요.");
        softAssertions.assertThatThrownBy(
                        () -> lottoService.setWinningLottoStore(invalidLength, bonusNum))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 6개 입니다.");
        softAssertions.assertThatThrownBy(
                        () -> lottoService.setWinningLottoStore(invlaidNum, bonusNum))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자를 입력하세요.");
        softAssertions.assertThatThrownBy(
                        () -> lottoService.setWinningLottoStore(overHeadNum, bonusNum))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 1~45 숫자를 입력하세요");
        softAssertions.assertThatThrownBy(
                        () -> lottoService.setWinningLottoStore(validWinningNum, invalidBonusNum))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자를 입력하세요.");

        softAssertions.assertAll();
    }

    @DisplayName("당첨번호와 보너스번호가 중복하면 예외 발생한다.")
    @Test
    void duplicateWinningAndBonusNumber() {
        final String winningNum = "1,2,3,4,5,6";
        final String duplicateBonusNum = "1";
        Assertions.assertThatThrownBy(
                        () -> lottoService.setWinningLottoStore(winningNum, duplicateBonusNum))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨 번호와 보너스 번호가 중복되었습니다.");
    }

    @DisplayName("당첨결과가 LottoPrizeRankType과 맞게 반환된다.")
    @Test
    void getLottoResults() {
        final Lotto firstLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        final Lotto secondLotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        final Lotto zeroLotto = new Lotto(List.of(1, 2, 9, 10, 11, 12));
        int totalPrize = 2000000000 + 30000000;
        int totalCost = 3000;
        float rateOfReturn = (float) totalPrize / totalCost * 100;
        SoftAssertions softAssertions = new SoftAssertions();

        LottoResultDto resultDto = lottoService.getLottoResults(
                List.of(firstLotto, secondLotto, zeroLotto));
        softAssertions.assertThat(resultDto.rankLotto().keySet())
                .isNotEmpty()
                .contains(LottoPrizeRankType.FIRST, LottoPrizeRankType.SECOND)
                .doesNotContain(LottoPrizeRankType.ZERO);
        softAssertions.assertThat(resultDto.rateOfReturn())
                .isEqualTo(rateOfReturn);

        softAssertions.assertAll();
    }
}