package lotto.interaction.input;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import lotto.exception.LottoException;
import lotto.exception.LottoExceptionCode;
import lotto.parser.LottoParser;

public class LottoStandardInput implements LottoInput{
    private final BufferedReader br;
    public LottoStandardInput(BufferedReader br) {
        this.br = br;
    }

    @Override
    public int inputPurchaseMoney() throws LottoException {
        try {
            return LottoParser.getPurchaseMoney(br.readLine());
        }catch (IOException exception) {
            exception.printStackTrace();
            throw new LottoException(LottoExceptionCode.IO_EXCEPTION_OCCUR);
        }
    }

    @Override
    public List<Integer> inputWinningNumbers() throws LottoException{
        try {
            return LottoParser.getWinningNumbers(br.readLine());
        } catch (IOException exception) {
            exception.printStackTrace();
            throw new LottoException(LottoExceptionCode.IO_EXCEPTION_OCCUR);
        }
    }

    @Override
    public int inputBonusNumber(List<Integer> winningNumbers) throws LottoException{
        try {
            return LottoParser.getBonusNumber(br.readLine(), winningNumbers);
        } catch (IOException exception) {
            exception.printStackTrace();
            throw new LottoException(LottoExceptionCode.IO_EXCEPTION_OCCUR);
        }
    }
}
