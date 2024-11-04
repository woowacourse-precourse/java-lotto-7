package lotto;

import lotto.domain.Lotto;
import lotto.model.LottoResult;

import java.util.List;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        GameController controller = new GameController();

        int lottoTickets = controller.getLottoTickets();
        List<Lotto> lottoList = controller.generateLottoNumbers(lottoTickets);
        Set<Integer> winningNumbers = controller.getWinningNumbers();
        int bonusNumber = controller.getBonusNumber();

        LottoResult lottoInfo = LottoResult.create(
                lottoList,
                winningNumbers,
                bonusNumber
        );

        controller.printResult(lottoInfo);
    }
}
