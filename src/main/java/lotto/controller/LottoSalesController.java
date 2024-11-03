package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.InputAmount;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoSalesController {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoSalesController(InputView inputView, OutputView outputView){
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        InputAmount inputAmount = repeatGetAmountUntilValid();

        // 구입 개수 구하기 & 출력
        // 로또 자동 발행

        // 당첨 번호 입력받기
        // 보너스 번호 입력받기


        Console.close();
    }

    private InputAmount repeatGetAmountUntilValid() {
        InputAmount inputAmount = null;
        while(inputAmount == null) {
            inputAmount = tryGetAmount();
        }
        return inputAmount;
    }

    private InputAmount tryGetAmount() {
        try {
            outputView.printInputAmount();
            return new InputAmount(inputView.getAmount());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

}
