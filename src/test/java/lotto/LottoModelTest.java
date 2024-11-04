package lotto;

import lotto.dto.request.LottoBonusNumberRequest;
import lotto.dto.request.LottoMatchRequest;
import lotto.dto.response.LottoBuyResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoModelTest{
    private final LottoModel lottoModel = new LottoModel();

    @Test
    @DisplayName("로또 구매 시 입력한 금액에 따른 로또 수량이 반환되는지 확인한다.")
    void 로또_구매_테스트() {
        LottoBuyResponse response = lottoModel.buyLotto("5000"); // 5000원 구매

        assertThat(response.buyLottoNumber()).isEqualTo(5); // 5장 구매
        assertThat(response.buyResult().split("\n")).hasSize(5); // 로또 번호 5세트
    }

    @Test
    @DisplayName("로또 구매 시 입력 금액이 1000원 미만일 경우 예외 발생한다.")
    void 구매금액이_1000원_미만일_경우_예외_발생() {
        assertThatThrownBy(() -> lottoModel.buyLotto("999"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 1000원 이상 입력 가능합니다.");
    }

    @Test
    @DisplayName("로또 구매 시 입력 금액이 1000원 단위가 아닐 경우 예외 발생한다.")
    void 로또_구매_금액_1000_단위_아닐_경우_예외_발생() {
        assertThatThrownBy(() -> lottoModel.buyLotto("1500"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 입력 단위는 1000원 단위로 가능합니다.");

        assertThatThrownBy(() -> lottoModel.buyLotto("1001"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 입력 단위는 1000원 단위로 가능합니다.");
    }

    @Test
    @DisplayName("로또 번호 생성 시 입력된 당첨 번호가 올바르게 생성되는지 확인한다.")
    void 로또_생성_테스트() {
        Lotto lotto = lottoModel.makeLotto("1, 2, 3, 4, 5, 6");

        assertThat(lotto).isNotNull();
        assertThat(lotto.matchNumberCount(new LottoMatchRequest(List.of(1, 2, 3, 4, 5, 6), 7)).matchCount())
                .isEqualTo(6);
    }

    @Test
    @DisplayName("로또 번호가 1 ~ 45 범위를 벗어나면 예외 발생한다.")
    void 로또_번호_범위_테스트() {
        assertThatThrownBy(() -> lottoModel.makeLotto("0, 2, 3, 4, 5, 6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 양수만 입력가능합니다.");

        assertThatThrownBy(() -> lottoModel.makeLotto("1, 2, 3, 4, 5, 46"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 1 ~ 45 숫자만 가능합니다.");
    }

    @Test
    @DisplayName("로또 번호 입력이 숫자가 아닐 경우 예외 발생한다.")
    void 로또_번호_숫자_검증_테스트() {
        assertThatThrownBy(() -> lottoModel.buyLotto("abcd"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 숫자만 입력 가능합니다.");
    }

    @Test
    @DisplayName("보너스 번호가 로또 번호와 중복되지 않는 유효한 번호인지 검증한다.")
    void 보너스_번호_로또_번호_중복되지_않는_유효_번호_검증_테스트() {
        Lotto lotto = lottoModel.makeLotto("1, 2, 3, 4, 5, 6");
        LottoBonusNumberRequest request = new LottoBonusNumberRequest(lotto, "7");

        int bonusNumber = lottoModel.getBonusNumber(request);
        assertThat(bonusNumber).isEqualTo(7);
    }

    @Test
    @DisplayName("보너스 번호 입력이 1 ~ 45 범위를 벗아니면 예외 발생한다.")
    void 보너스_번호_범위_초과_테스트() {
        Lotto lotto = lottoModel.makeLotto("1,2,3,4,5,6");
        String bonusNumber = "46";

        assertThatThrownBy(() -> lottoModel.getBonusNumber(new LottoBonusNumberRequest(lotto, bonusNumber)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 1 ~ 45 숫자만 가능합니다.");
    }

    @Test
    @DisplayName("보너스 번호 입력이 1 ~ 45 범위를 벗아니면 예외 발생한다.")
    void 보너스_번호_범위_미만_테스트() {
        Lotto lotto = lottoModel.makeLotto("1,2,3,4,5,6");
        String bonusNumber = "0";

        assertThatThrownBy(() -> lottoModel.getBonusNumber(new LottoBonusNumberRequest(lotto, bonusNumber)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 양수만 입력가능합니다.");
    }

    @Test
    @DisplayName("보너스 번호가 로또 번호와 중복될 경우 예외 발생한다.")
    void 보너스_번호_중복_예외_발생() {
        Lotto lotto = lottoModel.makeLotto("1, 2, 3, 4, 5, 6");
        LottoBonusNumberRequest request = new LottoBonusNumberRequest(lotto,"3");

        assertThatThrownBy(() -> lottoModel.getBonusNumber(request))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 당첨 번호와 보너스 숫자는 중복될 수 없습니다.");
    }
}