package lotto.service;

import lotto.exception.InputValidation;
import lotto.exception.ValidateValues;
import lotto.view.InputView;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class LottoResultManager {

    public List<Integer> getWinningNumbers() {
        String inputWinningNumbers = InputView.getWinningNumbers();
        List<Integer> winningNumbers = new ArrayList<>();

        if(InputValidation.NOT_BLANK.validate(inputWinningNumbers)){
            StringTokenizer tokenizer = new StringTokenizer(inputWinningNumbers,",");
            while(tokenizer.hasMoreTokens()){
                String winnerNumber = tokenizer.nextToken();
                if(ValidateValues.winningNumber(winnerNumber)){
                    winningNumbers.add(Integer.parseInt(winnerNumber));
                }
            }
        }
        return winningNumbers;
    }

}
