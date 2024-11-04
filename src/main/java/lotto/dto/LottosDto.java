package lotto.dto;

import java.util.List;
import lotto.model.domain.Lotto;

public class LottosDto {

    List<Lotto> myLottos;

    public LottosDto(List<Lotto> myLottos) {
        this.myLottos = myLottos;
    }

    public List<Lotto> getMyLottos() {
        return myLottos;
    }

    public void setMyLottos(List<Lotto> myLottos) {
        this.myLottos = myLottos;
    }
}
