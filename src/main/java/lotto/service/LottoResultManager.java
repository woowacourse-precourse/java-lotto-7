package lotto.service;

import lotto.exception.ValidateWinningNumbers;
import lotto.view.InputView;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class LottoResultManager {

    public List<String> getWinningNumbers() {
        String inputWinningNumbers = InputView.getWinningNumbers();
        List<String> winningNumbers = new ArrayList<>();

        if(ValidateWinningNumbers.NOT_BLANK.validateNumbers(inputWinningNumbers)){
            StringTokenizer tokenizer = new StringTokenizer(inputWinningNumbers,",");
            while(tokenizer.hasMoreTokens()){
                String winnerNumber = tokenizer.nextToken();
                if(ValidateWinningNumbers.NOT_NUMBER.validateNumbers(winnerNumber)
                    && ValidateWinningNumbers.NOT_INTEGER.validateNumbers(winnerNumber)
                    && ValidateWinningNumbers.NOT_IN_RANGE.validateNumbers(winnerNumber)){
                    winningNumbers.add(winnerNumber);
                }
            }
        }
        return winningNumbers;
    }

}
