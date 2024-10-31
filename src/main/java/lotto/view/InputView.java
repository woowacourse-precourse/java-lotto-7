package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.dto.LottoInputDto;

import java.util.Arrays;
import java.util.List;

public class InputView {

    public LottoInputDto enterInput() {
        long purchaseAmount = enterPurchaseAmount();
        List<Integer> winningNumber = enterWinningNumber();
        int bonusNumber = enterBonusNumber();

        return new LottoInputDto(purchaseAmount, winningNumber, bonusNumber);
    }

    private long enterPurchaseAmount() {
        return Long.parseLong(Console.readLine());
    }

    private List<Integer> enterWinningNumber() {
        return Arrays.stream(Console.readLine().split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();
    }

    private int enterBonusNumber() {
        return Integer.parseInt(Console.readLine());
    }
}
