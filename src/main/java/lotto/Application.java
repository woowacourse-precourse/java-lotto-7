package lotto;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Ticket;
import lotto.io.Input;
import lotto.io.Output;
import lotto.service.LottoService;

public class Application {
    public static void main(String[] args) {
        int price = Input.price();
        List<Lotto> lottos = LottoService.generateLottos(price);
        Output.lottos(lottos);
        List<Integer> winningNumbers = Input.winningNumbers();
        int bonusNumber = Input.bonusNumber(winningNumbers);
        Ticket ticket = new Ticket(lottos, price, winningNumbers, bonusNumber);
        Output.result(ticket);
    }
}
