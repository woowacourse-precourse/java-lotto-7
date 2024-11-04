package lotto;

import java.util.List;


//번호를 만드는 애들
public class Lotto {
    private final List<Integer> lottos;

    public Lotto(List<Integer> lottos) {
        validate(lottos);
        this.lottos = lottos;
    }


    private void validate(List<Integer> lottos) {
        if (lottos.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    public List<Integer> getNumbers() {
        return lottos;
    }


}
