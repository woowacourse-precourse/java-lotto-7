package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;

import java.util.List;

public class View {
    public String getInputAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }
    public void printLottos(List<Lotto> lottos) {
        System.out.println(lottos.toString());
    }
    public void getLottoWinningNumbers(String winningNumbers) {
        System.out.println(winningNumbers);
    }
    public void getLottoBonusNumber(String bonusNumber) {
        System.out.println(bonusNumber);
    }
    public void printWinningStatistics(List<Lotto> lottos) {
        System.out.println("당첨 통계");
    }

}
