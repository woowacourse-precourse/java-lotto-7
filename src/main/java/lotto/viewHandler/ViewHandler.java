package lotto.viewHandler;

import lotto.dto.InputDto;
import lotto.view.Input;
import lotto.view.Output;

public class ViewHandler {
    private final ApiHandler apiHandler;
    private final Input input;
    private final Output output;

    public ViewHandler(ApiHandler apiHandler, Input input, Output output) {
        this.apiHandler = apiHandler;
        this.input = input;
        this.output = output;
    }

    public Api<InputDto> inputHandler() {
        try {

        } catch() {

        }
    }

    private Api<Integer> purchaseMoney() {
        String money = input.getPurchaseMoney();
        String moneyData = money.getData();

    }
}
