package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoJudge {
    private List<Integer> answers = new ArrayList<>();
    private List<Integer> numbers = new ArrayList<>();
    private int bonusNumber = -1;
    private int correctCount = 0;

    public LottoJudge(List<Integer> answers, List<Integer> numbers, int bonusNumber) {
        this.answers = answers;
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    public Grade judge(){
        for (Integer number : numbers) {
            judgeCount(number);
        }
        return judgeGrade();
    }

    private Grade judgeGrade(){
        if (correctCount == 3){
            return Grade.MATCH3;
        }
        if (correctCount == 4){
            return Grade.MATCH4;
        }
        if(correctCount == 5){
            return judgeBonusGrade();
        }
        if (correctCount == 6){
            return Grade.MATCH6;
        }
        return Grade.MATCH_NONE;
    }

    private Grade judgeBonusGrade(){
        if(judgeBonusNumber()){
            return Grade.MATCH5_BONUS;
        }
        return Grade.MATCH5;
    }

    private void judgeCount(int number){
        if(judgeOneNumber(number)){
            correctCount++;
        }
    }

    public Boolean judgeOneNumber(int number) {
        return answers.contains(number);
    }

    public Boolean judgeBonusNumber() {
        return numbers.contains(bonusNumber);
    }
}
