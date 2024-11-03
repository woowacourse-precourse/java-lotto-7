package lotto;

import java.util.ArrayList;
import java.util.List;
import validator.PaymentValidator;

public class Application {
    public static void main(String[] args) {
        Input input = new Input();

        Integer money = input.getMoney();
        Integer ticket = TicketVendor.vendor(money);

        List<LottoTicket> lottoTicketBundle = LottoTicketBundle.getLottoTicketBundle(ticket);
        System.out.println();

        List<Integer> inputPrizeNumber = input.getPrizeNumbers();
        Integer bonusNumber = input.getBonus();
        Lotto lotto = new Lotto(
                inputPrizeNumber,
                lottoTicketBundle,
                bonusNumber
        );

        lotto.play();
    }
}
