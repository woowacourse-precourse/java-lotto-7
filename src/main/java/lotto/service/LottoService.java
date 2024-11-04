package lotto.service;

import java.util.EnumMap;
import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.Customer;
import lotto.domain.Price;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;
import lotto.domain.dto.WinningNumbersDto;
import lotto.exceptionHandler.ExceptionHandler;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoService {

    private Price price;
    private Customer customer;
    private WinningNumbersDto winningNumbersDto;
    private BonusNumber bonusNumber;
    private WinningLotto winningLotto;
    private EnumMap<Rank, Integer> result;

    public void inputPrice() {
        ExceptionHandler.handle(() -> {
            int value = InputView.inputPrice();
            price = Price.from(value);
        });
    }

    public void initCustomer() {
        customer = Customer.from(price.getValue());
    }

    public void purchaseLottos() {
        customer.purchaseLottos();
    }

    public void showLottos() {
        OutputView.lottosPurchasedMessage(customer);
        OutputView.lottosPurchased(customer);
    }

    public void setWinningNumbers() {
        ExceptionHandler.handle(() -> {
            List<Integer> numbers = InputView.winningNumbers();
            winningNumbersDto = new WinningNumbersDto(numbers);
        });
    }

    public void setBonusNumber() {
        ExceptionHandler.handle(() -> {
            int number = InputView.bonusNumber(winningNumbersDto);
            bonusNumber = BonusNumber.from(number);
        });
    }

    public void initWinningLotto() {
        List<Integer> winningNumbers = winningNumbersDto.numbers();
        int number = bonusNumber.getNumber();
        winningLotto = WinningLotto.of(winningNumbers, number);
    }

    public void result() {
        result = customer.result(winningLotto);
        OutputView.resultMessage(result);
    }
}