package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.validation.LotteryValidator;

public class InputView {
    private final LotteryValidator lotteryValidator;

    public InputView() {
        this.lotteryValidator = new LotteryValidator();
    }

    public int readPurchaseAmount() {
        String inputPurchaseAmount = Console.readLine();
        while (!lotteryValidator.validateInputPurchaseAmount(inputPurchaseAmount)) {
            inputPurchaseAmount = Console.readLine();
        }
        return Integer.parseInt(inputPurchaseAmount);
    }

    public List<Integer> readLottoNumbers() {
        String inputLottoNumbers = Console.readLine();
        while (!lotteryValidator.validateInputLottoNumbers(inputLottoNumbers)) {
            inputLottoNumbers = Console.readLine();
        }

        List<Integer> lottoNumbers = new ArrayList<>();

        for (final String lottoNumber : inputLottoNumbers.split(",")) {
            lottoNumbers.add(Integer.parseInt(lottoNumber));
        }

        return lottoNumbers;
    }
}
