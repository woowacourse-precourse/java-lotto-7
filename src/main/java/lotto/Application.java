package lotto;

import model.LottoUtils;
import view.Inputview;
import view.outputView;

import java.util.List;

public class Application {
    public static void main(String[] args)
    {
        int bonus;
        List<List<Integer>> lottoNumbers;

        outputView output = new outputView();
        Inputview input = new Inputview();
        LottoUtils Lotto = new LottoUtils();

        output.reqeustPurchase();
        output.inputUsedPrice(input.Purchase());

        output.amountPurchase();
        lottoNumbers=output.randomNumber(output.choose());
        output.printNumberLists(lottoNumbers);

        output.reqeustWinner();
        Lotto winner = input.winningNumbr();

        output.reqeustbonus();
        bonus = input.bonusNumber();

        output.inputPrice(
                Lotto.compareLists(lottoNumbers, winner.getNumbers(), bonus)
        );

        output.printWinningStatistics();
    }
}
