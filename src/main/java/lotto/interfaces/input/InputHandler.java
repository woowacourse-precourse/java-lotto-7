package lotto.interfaces.input;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.common.exception.InvalidLottoMoneyException;
import lotto.common.exception.InvalidLottoNumberException;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.money.LottoMoney;

public class InputHandler {

    public LottoMoney readPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        int purchaseAmount;
        String input = read();
        try {
            purchaseAmount = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new InvalidLottoMoneyException(input, e);
        }
        return new LottoMoney(purchaseAmount);
    }

    public Lotto readWinningLotto() {
        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> winningLotto = new ArrayList<>();
        String input = read();
        try {
            winningLotto = Arrays.stream(input.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException | NullPointerException e) {
            throw new InvalidLottoNumberException(input, e);
        }
        List<LottoNumber> lottoNumbers = winningLotto.stream()
                .map(LottoNumber::new)
                .toList();
        return new Lotto(lottoNumbers);
    }

    public LottoNumber readBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber;
        String input = read();
        try {
            bonusNumber = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new InvalidLottoNumberException(input, e);
        }
        return new LottoNumber(bonusNumber);
    }

    private String read() {
        return Console.readLine().trim();
    }
}
