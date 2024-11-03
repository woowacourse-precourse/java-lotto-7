package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.message.LottoMessage;
import lotto.validate.LottosValidate;

public class Lottos {

    private final List<List<Lotto>> lottos;

    public Lottos() {
        this.lottos = new ArrayList<>();
    }

    public void makeLottos(User user) {
        int lottoAmount = user.getNumOfLottos();

        for (int lotto = 0; lotto < lottoAmount; lotto++) {
            lottos.add(new ArrayList<>());
        }
    }

    public int getLottosSize() {
        return lottos.size();
    }

    public void addLottoToList(int index, Lotto lotto) {
        int lottosTotalAmount = getLottosSize();
        if (!LottosValidate.isValidRangeOfList(index, lottosTotalAmount)) {
            throw new IndexOutOfBoundsException(LottoMessage.OUT_OF_RANGE_LOTTO_AMOUNT.getMessage());
        }

        lottos.get(index).add(lotto);
    }
}
