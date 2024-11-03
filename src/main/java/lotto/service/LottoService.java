package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoPrice;
import lotto.view.ClientInput;
import lotto.view.ClientOutput;

public class LottoService {
    public int purchaseTicket() {
        ClientInput clientInput = new ClientInput();
        LottoPrice lottoPrice = new LottoPrice(clientInput.enterPurchaseAmount());
        return lottoPrice.getTicketQuantity();
    }

    public List<List<Integer>> generateLottoNumbers(int ticketQuantity) {
        List<List<Integer>> lottoTickets = new ArrayList<>();
        ClientOutput clientOutput = new ClientOutput();
        for (int ticket = 0; ticket < ticketQuantity; ticket++) {
            Lotto ticketNumbers = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            lottoTickets.add(ticketNumbers.getNumbers());
        }
        clientOutput.lottoPurchaseMessageOutput(ticketQuantity, lottoTickets);

        return lottoTickets;
    }

    public List<String> generateWinningNumber() {
        ClientInput clientInput = new ClientInput();
        List<String> numbers = new ArrayList<>();
        String winningNumber = clientInput.enterWinningNumber();
        String bonusNumber = clientInput.enterBonusNumber();
        String string = winningNumber + "," + bonusNumber;
        numbers.add(string);
        return numbers;
    }
}
