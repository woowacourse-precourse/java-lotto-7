package lotto.model.service;

import java.util.List;
import lotto.model.domain.Lotto;
import lotto.model.domain.LottoMachine;

public class LottoService {

    public int moneyValidator(String inputMoney) {
        moneyNotNullValidator(inputMoney);
        return moneyNumberValidator(inputMoney);
    }

    public List<Lotto> activateLottoMachine(int money) {
        LottoMachine lottoMachine = new LottoMachine(money);
        return lottoMachine.multipleLottoGenerator();
    }

    private static void moneyNotNullValidator(String inputMoney) {
        if (inputMoney.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 로또를 구매하려는 금액을 입력해 주세요.");
        }
    }

    private static int moneyNumberValidator(String inputMoney) {
        try {
            return Integer.parseInt(inputMoney);
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 로또를 구매하려는 금액을 숫자로 입력해 주세요.");
        }
    }

}
