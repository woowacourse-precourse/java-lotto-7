package lotto.model;

import java.util.List;

public class MyLotto {
    List<Lotto> lottos;
    Long firstPlace;
    Long secondPlace;
    Long thirdPlace;
    Long fourthPlace;
    Long fifthPlace;

    public MyLotto(List<Lotto> lottos) {
        this.lottos = lottos;
        this.firstPlace = 0L;
        this.secondPlace = 0L;
        this.thirdPlace = 0L;
        this.fourthPlace = 0L;
        this.fifthPlace = 0L;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
    public Long getFirstPlace() { return firstPlace; }
    public Long getSecondPlace() { return secondPlace; }
    public Long getThirdPlace() { return thirdPlace; }
    public Long getFourthPlace() { return fourthPlace; }
    public Long getFifthPlace() { return fifthPlace; }
    public void updateFirstPlace() { firstPlace++; }
    public void updateSecondPlace() { secondPlace++; }
    public void updateThirdPlace() { thirdPlace++; }
    public void updateFourthPlace() { fourthPlace++; }
    public void updateFifthPlace() { fifthPlace++; }
}
