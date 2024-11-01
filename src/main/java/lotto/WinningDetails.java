package lotto;

import java.util.ArrayList;
import java.util.List;

public class WinningDetails {
    private Integer third = 0;
    private Integer fourth = 0;
    private Integer fifth = 0;
    private Integer fifthBonus = 0;
    private Integer sixth = 0;

    public void sumUpGrades(List<MyResult> myResults){
        for(MyResult result : myResults){
            if(result.getMatches() == 3) this.third++;
            else if(result.getMatches() == 4) this.fourth++;
            else if(result.getMatches() == 5 && result.getIsBonus()) this.fifth++;
            else if(result.getMatches() == 5 && !result.getIsBonus()) this.fifthBonus++;
            else if(result.getMatches() == 6) this.sixth++;
        }
    }

    public static List<MyResult> saveMyGrades(List<Lotto> lottoList, Lotto answer, int bonus){
        List<MyResult> myResults = new ArrayList<>();
        for(int i = 0; i < lottoList.size(); i++){
            MyResult gradedLotto = Lotto.gradeLotto(answer, lottoList.get(i), bonus);
            myResults.add(gradedLotto);
        }
        return myResults;
    }

    public Integer getThird() {
        return third;
    }
    public Integer getFourth() {
        return fourth;
    }
    public Integer getFifth() {
        return fifth;
    }
    public Integer getFifthBonus() {
        return fifthBonus;
    }
    public Integer getSixth() {
        return sixth;
    }
}
