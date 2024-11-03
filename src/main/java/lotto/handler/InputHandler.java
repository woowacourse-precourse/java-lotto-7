package lotto.handler;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;

import lotto.util.messages.ErrorMessage;
import lotto.view.InputView;

public class InputHandler {
    private final InputView inputView = new InputView();

    public int getPurchasePrice() {
        String inputPurchasePrice;
        int price;

        inputView.printInputPurchasePrice();

        inputPurchasePrice = Console.readLine();

        // 입력받은 구입금액이 정수인지 판별
        try {
            price = Integer.parseInt(inputPurchasePrice);
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessage.PRICE_IS_NOT_NUMBER.getMessage());
        }

        // 입력받은 구입금액이 1000원 이상인지 판별
        if (price < 1000) {
            throw new IllegalArgumentException(ErrorMessage.PRICE_IS_UNDER_1000.getMessage());
        }
        return price;
    }

    public List<Integer> getLottoNumber() {
        String inputLottoNumbers;

        inputView.printInputLottoNumber();
        inputLottoNumbers = Console.readLine();

        return Arrays.stream(inputLottoNumbers.split(","))
                .filter(element -> !element.isEmpty())
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public int getBonusNumber() {
        String inputBonusNumber;
        inputView.printInputBonusNumber();
        inputBonusNumber = Console.readLine();

        // 입력받은 보너스 번호가 정수인지 판별
        try {
            return Integer.parseInt(inputBonusNumber);
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_IS_NOT_INTEGER.getMessage());
        }
    }
}
