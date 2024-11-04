package lotto;

import lotto.input.LottoInput;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoInput lottoInput = new LottoInput();
        int cost = lottoInput.readCost();
        List<Integer> winningNumbers = lottoInput.readWinningNumbers();
        int bonusNumber = lottoInput.readBonus();




    }
}
