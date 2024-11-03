package lotto.Model;

import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

public class WinningDetails {
    private Integer third = 0;
    private Integer fourth = 0;
    private Integer fifth = 0;
    private Integer fifthBonus = 0;
    private Integer sixth = 0;

    public void sumUpGrades(List<MyResults> myResults) {
        for (MyResults result : myResults) {
            if (result.getMatches() == 3) this.third++;
            else if (result.getMatches() == 4) this.fourth++;
            else if (result.getMatches() == 5 && !result.getIsBonus()) this.fifth++;
            else if (result.getMatches() == 5 && result.getIsBonus()) this.fifthBonus++;
            else if (result.getMatches() == 6) this.sixth++;
        }
    }

    public static List<MyResults> saveMyGrades(List<Lotto> lottos, Lotto answer, int bonus) {
        List<MyResults> myResults = new ArrayList<>();
        for (int i = 0; i < lottos.size(); i++) {
            MyResults gradedLotto = Lotto.gradeLotto(answer, lottos.get(i), bonus);
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

    public void setThird(Integer third) {
        this.third = third;
    }

    public void setFourth(Integer fourth) {
        this.fourth = fourth;
    }

    public void setFifth(Integer fifth) {
        this.fifth = fifth;
    }

    public void setFifthBonus(Integer fifthBonus) {
        this.fifthBonus = fifthBonus;
    }

    public void setSixth(Integer sixth) {
        this.sixth = sixth;
    }
}
