package lotto;

import java.util.List;

public class GradeSaver {
    private Integer third = 0;
    private Integer fourth = 0;
    private Integer fifth = 0;
    private Integer fifthBonus = 0;
    private Integer sixth = 0;

    public GradeSaver sumUpGrades(List<MyResult> resultList){
        for(MyResult result : resultList){
            if(result.getMatches() == 3) this.third++;
            else if(result.getMatches() == 4) this.fourth++;
            else if(result.getMatches() == 5 && result.getBonusPoint()) this.fifth++;
            else if(result.getMatches() == 5 && !result.getBonusPoint()) this.sixth++;
            else if(result.getMatches() == 6) this.sixth++;
        }
        return this;
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
