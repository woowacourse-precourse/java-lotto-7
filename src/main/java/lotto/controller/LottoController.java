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
        while (true) {
            // to output -> "구입 금액을 입력해주세요."
            try {
                String moneyString = Console.readLine();
                Long money = changeStringToMoney(moneyString);
                lottos.buyLottos(money);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e);
            }
        }

        // to output -> "X개를 구매했습니다. \n~~~  \n~~~"

        while (true) {
            try {
                // to output -> "당첨 번호를 입력해 주세요."
                String winningNumbersString = Console.readLine();
                List<Integer> winningNumbers = changeStringToNumberList(winningNumbersString);
                lottos.setWinningNumbers(winningNumbers);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e);
            }
        }

        while (true) {
            try {// to output -> "보너스 번호를 입력해 주세요."
                String bonusNumberString = Console.readLine();
                Integer bonusNumber = changeStringToNumber(bonusNumberString);
                lottos.setBonusNumber(bonusNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e);
            }
        }

        // to output -> "당첨 통계 ~~"
    }

    private Long changeStringToMoney(String moneyString) throws IllegalArgumentException {
        validateMoney(moneyString);
        return Long.parseLong(moneyString);
    }

    private void validateMoney(String moneyString) throws IllegalArgumentException {

    }

    private List<Integer> changeStringToNumberList(String numbersString) throws IllegalArgumentException {

    }

    private Integer changeStringToNumber(String numberString) throws IllegalArgumentException {

    private void validateLottoNumbersString(String numberString) throws IllegalArgumentException {
    }

    private void validateBonusNumberString(String numberString) throws IllegalArgumentException {
    }
}
