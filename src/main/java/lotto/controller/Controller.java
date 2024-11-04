package lotto.controller;

import java.util.function.Supplier;
import lotto.dto.EarnedLottos;
import lotto.dto.WinningStatistics;
import lotto.model.AnswerNumbers;
import lotto.model.BonusNumber;
import lotto.model.Customer;
import lotto.model.LottoGenerator;
import lotto.model.Money;
import lotto.model.MyLotto;
import lotto.model.Seller;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoGenerator lottoGenerator;

    public Controller(InputView inputView, OutputView outputView, LottoGenerator lottoGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoGenerator = lottoGenerator;
    }

    public void run() {
        Customer customer = tryforCorrectInput(this::createCustomer);

        Seller seller = new Seller(lottoGenerator);
        seller.sellTo(customer);

        outputView.printLottoNumbers(EarnedLottos.from(customer.getMyLotto()));

        AnswerNumbers answerNumbers = tryforCorrectInput(this::createAnswerNumbers);
        BonusNumber bonusNumber = tryforCorrectInput(this::createBonusNumber);

        float earningRate = customer.getEarningRate(answerNumbers, bonusNumber);
        outputView.printWinningHistory(new WinningStatistics(customer.getWinningHistory()));
        outputView.printEarningRate(earningRate);
    }

    private Customer createCustomer() {
        Money money = tryforCorrectInput(() -> new Money(inputView.getAmount()));
        MyLotto myLotto = MyLotto.emptyMyLotto();
        return new Customer(money, myLotto);
    }

    private BonusNumber createBonusNumber() {
        String bonusNumber = inputView.getBonusNumber();
        return new BonusNumber(bonusNumber);
    }

    private AnswerNumbers createAnswerNumbers() {
        String answer = inputView.getAnswer();
        return AnswerNumbers.from(answer);
    }

    private <T> T tryforCorrectInput(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            outputView.printExceptionMessage(e);
            return tryforCorrectInput(supplier);
        }
    }
}