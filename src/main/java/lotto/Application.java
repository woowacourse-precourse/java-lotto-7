package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        LottoMachineController controller = new LottoMachineController();
        int price = controller.handleInputPrice();
        List<Lotto> lottos = controller.getLotto(price);

        List<Integer> winningNumbers = controller.handleInputWinningNumbers();
        int bonusNumber = controller.handleInputBonusNumber();

        controller.printWinningStatistics(lottos, winningNumbers, bonusNumber, price);
    }
}
