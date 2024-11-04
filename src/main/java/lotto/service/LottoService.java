package lotto.service;

import lotto.domain.*;
import lotto.util.*;

import java.util.ArrayList;
import java.util.List;

public class LottoService {

    public static final int LOTTO_PRICE = 1000;
    private final List<Lotto> lottos = new ArrayList<>();

    public void generateLottos(int purchaseAmount) {
        int count = purchaseAmount / LOTTO_PRICE;
        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto(LottoNumberGenerator.generate()));
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

}
