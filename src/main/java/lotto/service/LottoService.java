package lotto.service;

import java.util.List;
import lotto.domain.Customer;
import lotto.domain.Price;
import lotto.domain.dto.WinningNumbersDto;
import lotto.exceptionHandler.ExceptionHandler;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoService {

    private Price price;
    private Customer customer;
    private WinningNumbersDto winningNumbersDto;

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
}