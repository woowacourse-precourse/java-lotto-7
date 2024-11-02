package lotto.core.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import lotto.core.validate.InputValidate;

public class WinnerLotto {

    private Lotto winningNumber;
    private Integer bonusNumber;
    private final Map<ScoreBoard, Integer> scoreResult;
    private final InputValidate inputValidate;

    public WinnerLotto() {
        this.scoreResult = new HashMap<>();
        this.inputValidate = new InputValidate();
    }

    public void createWinnerLotto(String inputNumbers,String BonusNumber) {
        this.winningNumber = inputWinningNumber(inputNumbers);
        this.bonusNumber = inputBonusNumber(BonusNumber);
    }

    public Lotto inputWinningNumber(String inputNumbers) {
        List<Integer> validatedCompleteNumbers = winningNumbersValidate(inputNumbers);
        return new Lotto(validatedCompleteNumbers);
    }

    private List<Integer> winningNumbersValidate(String givenNumbers) {
        List<String> givenNumberStrings = Arrays.asList(givenNumbers.split(","));
        return inputValidate.inputNumbersIntegerValidate(givenNumberStrings);
    }

    public Integer inputBonusNumber(String BonusNumber) {
        return lottoBonusNumberValidate(BonusNumber);
    }

    private Integer lottoBonusNumberValidate(String inputNumber) {
        int givenNumber = inputValidate.inputSingleNumberValidate(inputNumber);
        if (1 > givenNumber || givenNumber > 46) throw new IllegalArgumentException("입력 범위 밖.");
        if(this.winningNumber.existNumber(givenNumber)) throw new IllegalArgumentException("보너스 번호가 이미 당첨 번호에 있습니다.");
        return givenNumber ;
    }

    public void matchWinnerLotto(Set<Lotto> lottos) {
        for (Lotto userLotto : lottos) {
            ScoreBoard result = userLotto.matchNumbers(this.winningNumber, this.bonusNumber);
            scoreResult.put(result, scoreResult.getOrDefault(result, 0) + 1);
        }
    }

    public List<ScoreBoard.ResultDto> getResultBoard() {
        return ScoreBoard.generateResultBoard(scoreResult, 0);
    }

    public Integer calculatePrize() {
        return ScoreBoard.calculatePrize(scoreResult);
    }

}
