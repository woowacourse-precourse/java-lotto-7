package lotto.controller;

import java.util.List;
import lotto.domain.FirstTicket;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Ticket;
import lotto.utils.RandomNumbersGenerator;
import lotto.utils.StringUtil;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Controller {
    private static final String SPLIT_DELIMITER = ", ";


    public void run() {
        Lotto lotto = createLotto();

        createAutoTickets(lotto);

        FirstTicket firstTicket = createFirstTicket();
        OutputView.printResult(lotto.getResult(firstTicket), lotto.getYield(firstTicket));
    }

    private Lotto createLotto() {
        try {
            return new Lotto(requestAmount());
        } catch (IllegalArgumentException exception) {
            OutputView.printErrorMessage(exception.getMessage());
            return createLotto();
        }
    }

    private FirstTicket createFirstTicket() {
        Ticket firstTicket = requestFirstNumbers();
        LottoNumber bonusNumber = requestBonusNumber();
        try {
            return new FirstTicket(firstTicket, bonusNumber);
        } catch (IllegalArgumentException exception) {
            OutputView.printErrorMessage(exception.getMessage());
            return createFirstTicket();
        }
    }

    private Ticket requestFirstNumbers() {
        try {
            List<Integer> integers = StringUtil.splitToIntegers(InputView.requestFirstNumbers(), SPLIT_DELIMITER);
            return Ticket.createByIntegers(integers, false);
        } catch (IllegalArgumentException exception) {
            OutputView.printErrorMessage(exception.getMessage());
            return requestFirstNumbers();
        }
    }

    private int requestAmount() {
        return InputView.requestAmount();
    }


    private void createAutoTickets(Lotto lotto) {
        int numberOfPurchasableCount = lotto.findCountOfPurchasable();
        for (int i = 0; i < numberOfPurchasableCount; i++) {
            lotto.addTicket(Ticket.createByImplementation(new RandomNumbersGenerator(), true));
        }
    }

    private LottoNumber requestBonusNumber() {
        try {
            return new LottoNumber(InputView.requestBonusNumber());
        } catch (IllegalArgumentException exception) {
            OutputView.printErrorMessage(exception.getMessage());
            return requestBonusNumber();
        }
    }
}
