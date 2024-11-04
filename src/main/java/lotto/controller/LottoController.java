package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.view.LottoOutput;
import lotto.entity.Lottos;

public class LottoController {

    private final Lottos lottos;
    private final LottoOutput lottoOutput;

    public LottoController(Lottos lottos, LottoOutput output) {
        this.lottos = lottos;
        this.lottoOutput = output;
    }

    public void startLotto() {
        // to output -> "구입 금액을 입력해주세요."
        String moneyString = Console.readLine();
        Long money = changeStringToMoney(moneyString);
        lottos.buyLottos(money);

        // to output -> "X개를 구매했습니다. \n~~~  \n~~~"

        // to output -> "당첨 번호를 입력해 주세요."
        String winningNumbersString = Console.readLine();
        List<Integer> winningNumbers = changeStringToNumberList(winningNumbersString);

        // to output -> "보너스 번호를 입력해 주세요."
        String bonusNumberString = Console.readLine();
        Integer bonusNumber = changeStringToNumber(bonusNumberString);

        lottos.setWinningNumbers(winningNumbers, bonusNumber);

        // to output -> "당첨 통계 ~~"
    }

    private Long changeStringToMoney(String moneyString) {
        validateMoney(moneyString);
        return Long.parseLong(moneyString);
    }

    private void validateMoney(String moneyString) {

    }

    private List<Integer> changeStringToNumberList(String numbersString) {

    }

    private Integer changeStringToNumber(String numberString) {

    }
}
