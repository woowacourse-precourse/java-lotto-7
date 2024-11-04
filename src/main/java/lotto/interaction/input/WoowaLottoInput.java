package lotto.interaction.input;

import java.util.List;
import lotto.exception.LottoException;
import camp.nextstep.edu.missionutils.Console;
import lotto.parser.LottoParser;

public class WoowaLottoInput implements LottoInput{
    @Override
    public int inputPurchaseMoney() throws LottoException {
        return LottoParser.getPurchaseMoney(Console.readLine());
    }

    @Override
    public List<Integer> inputWinningNumbers() throws LottoException {
        return LottoParser.getWinningNumbers(Console.readLine());
    }

    @Override
    public int inputBonusNumber(List<Integer> winningNumbers) throws LottoException {
        return LottoParser.getBonusNumber(Console.readLine(), winningNumbers);
    }
}
