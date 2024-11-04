package lotto;

import model.LottoUtils;
import view.Inputview;
import view.outputView;

import java.util.List;

public class Application {
    public static void main(String[] args)
    {
        try
        {
            int bonus;
            List<List<Integer>> lottoNumbers;

            outputView output = new outputView();
            Inputview input = new Inputview();
            LottoUtils Lotto = new LottoUtils();

            output.requestPurchase();
            output.inputUsedPrice(input.getPurchaseAmount());

            output.amountPurchase();
            lottoNumbers=output.randomNumber(output.choose());
            output.printNumberLists(lottoNumbers);

            output.requestWinner();
            Lotto winner = input.getWinningNumbers();

            output.requestBonus();
            bonus = input.getBonusNumber();

            output.inputPrice(
                    Lotto.compareLists(lottoNumbers, winner.getNumbers(), bonus)
            );

            output.printWinningStatistics();
        }
        catch(IllegalArgumentException e)
        {
            System.out.println(e.getMessage());
        }

    }
}
