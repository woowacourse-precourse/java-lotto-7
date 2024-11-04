package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.service.LottoInputConverter;

public class CliInputView {

    private LottoInputConverter lottoInputConverter;

    public CliInputView() {
        this.lottoInputConverter = new LottoInputConverter();
    }

    public int getMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String money = Console.readLine();

        return lottoInputConverter.convertMoney(money);
    }

    public List<Integer> getWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String winningNumbers = Console.readLine();

        return lottoInputConverter.convertNumbers(winningNumbers);
    }

    public int getBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        String bonusNumber = Console.readLine();

        return lottoInputConverter.convertBonusNumber(bonusNumber);
    }

}
