package lotto.util.handler;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;

import lotto.util.messages.ErrorMessage;
import lotto.view.InputView;

public class InputHandler {
    private final InputView inputView = new InputView();

    // 로또 갯수 반환으로 변경
    public int getPurchasePrice() {
        String inputPurchasePrice;
        int price;
        inputView.printInputPrice();

        inputPurchasePrice = Console.readLine();

        try {
            price = Integer.parseInt(inputPurchasePrice);
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessage.PRICE_IS_NOT_NUMBER.getMessage());
        }

        if (price < 1000) {
            throw new IllegalArgumentException(ErrorMessage.PRICE_IS_UNDER_1000.getMessage());
        }
        return price / 1000;
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

        try {
            return Integer.parseInt(inputBonusNumber);
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessage.IS_NOT_INTEGER.getMessage());
        }
    }
}
