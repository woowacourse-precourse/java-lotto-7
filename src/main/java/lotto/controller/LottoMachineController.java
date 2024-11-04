package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.IntStream;
import lotto.domain.BonusNumber;
import lotto.domain.CustomerLotto;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import lotto.dto.GeneratedTickets;
import lotto.dto.LottoResults;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoMachineController {
    public static final int TICKET_PRICE = 1000;

    private final InputView inputView;
    private final OutputView outputView;

    public LottoMachineController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        CustomerLotto customerLotto = createCustomerLotto();
        printCustomerLotto(customerLotto);
        WinningLotto winningLotto = createWinningLotto();
        displayLottoResults(customerLotto, winningLotto);
    }

    private CustomerLotto createCustomerLotto() {
        List<Lotto> tickets = purchaseTickets();
        return CustomerLotto.of(tickets);
    }

    private void printCustomerLotto(CustomerLotto customerLotto) {
        outputView.printGeneratedTickets(GeneratedTickets.from(customerLotto));
    }

    private WinningLotto createWinningLotto() {
        Lotto winningLotto = readValidLotto();
        BonusNumber bonusNumber = createBonusNumber(winningLotto.getNumbers());
        return WinningLotto.of(winningLotto, bonusNumber);
    }

    private Lotto readValidLotto() {
        try {
            return createValidLotto(inputWinningLottoNumbers());
        } catch (IllegalArgumentException e) {
            return readValidLotto();
        }
    }

    private List<Integer> inputWinningLottoNumbers() {
        return inputView.readWinningLottoNumbers();
    }

    private void displayLottoResults(CustomerLotto customerLotto, WinningLotto winningLotto) {
        LottoResults lottoResults = customerLotto.compareWinningLotto(winningLotto);
        outputView.printRank(lottoResults);
    }

    private List<Lotto> purchaseTickets() {
        int price = inputView.readLottoPurchasePrice();
        return generateTickets(price / TICKET_PRICE);
    }

    private Lotto createValidLotto(List<Integer> winningLottoNumbers) {
        try {
            return Lotto.of(winningLottoNumbers);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    private BonusNumber createBonusNumber(List<Integer> winningLottoNumbers) {
        return readValidBonusNumber(winningLottoNumbers);
    }

    private List<Lotto> generateTickets(int price) {
        return IntStream.range(0, price)
                .mapToObj(i -> Lotto.of(Randoms.pickUniqueNumbersInRange(1, 45, 6)))
                .toList();
    }

    private BonusNumber readValidBonusNumber(List<Integer> winningLottoNumbers) {
        try {
            int bonusNumberValue = inputView.readBonusNumber();
            return BonusNumber.of(bonusNumberValue, winningLottoNumbers);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return readValidBonusNumber(winningLottoNumbers);
        }
    }
}
