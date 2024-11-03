package lotto;

import lotto.controller.LottoController;
import lotto.dto.WinningResultDto;
import lotto.dto.WinningResultsDto;
import lotto.model.Bonus;
import lotto.model.Buy;
import lotto.model.Lotto;
import lotto.model.Winning;
import lotto.view.LottoView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

   @Test
    void 로또_번호의_입력_값_숫자_입력후_리스트_반환(){
        String userInput = "1, 2, 3, 4, 5, 6";
       LottoView view = new LottoView();

       LottoController lottoController = new LottoController(view);
        List<Integer> userNumbers = lottoController.setUserNumbers(userInput);
        assertThat(userNumbers).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    void 로또_번호의_입력_값_숫자가_아닌_입력값이_있으면_예외가_발생한다(){
        String userInput = "1,e,f";
        LottoView view = new LottoView();

        LottoController lottoController = new LottoController(view);
        assertThatThrownBy(() -> lottoController.setUserNumbers(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 숫자여야 합니다.");
    }

    @Test
    void 로또_번호의_입력_값_중복_이씨으면_예외가_발생한다(){
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 중복되지 않는 숫자를 입력해야 합니다.");
    }

    @Test
    void 보너스_번호의_입력_값_중복_있으면_예외가_발생한다(){
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertThatThrownBy(() -> new Bonus(lotto, 6))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 입력하신 로또 번호와 중복되지 않아야 합니다.");
    }

    @Test
    void 로또_번호의_입력_값_범위에_벗어나면_예외가_발생한다(){
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 100)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 1에서 45 사이의 숫자를 입력해야 합니다.");
    }

    @Test
    void 구매_금액_천단위_아니면_예외가_발생한다(){
        assertThatThrownBy(() -> new Buy(-10003))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 구매 금액 단위는 1000원 단위 입니다.");

    }
    @Test
    void 구매_금액_양수가_아니면_예외가_발생한다(){
        assertThatThrownBy(() -> new Buy(-1000))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 구매 금액은 양수만 입력해 주세요.");

    }

    @Test
    void 유저_구매_횟수만큼_로또_발행(){
        Integer userPurcharsePriceCount = 4;
        Winning winning = new Winning(userPurcharsePriceCount);

        assertThat(winning.getWinningTickets().size()).isEqualTo(4);
    }

    @Test
    void 당첨_결과_리스트_담기(){
        Integer userPurcharsePriceCount = 3;
        Winning winning = new Winning(userPurcharsePriceCount);
        List<Integer> userNumbers = List.of(1, 2, 3, 4, 5, 6);
        Integer userBonusNumber = 7;

        WinningResultsDto winningResultsDto = winning.compareNumbers(userNumbers, userBonusNumber);
        List<WinningResultDto> results = winningResultsDto.getResults();

        assertThat(results.size()).isEqualTo(3);
    }

}
