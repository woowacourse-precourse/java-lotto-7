package lotto.service;

import lotto.Lotto;
import lotto.util.RandomUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoService {
    public List<Lotto> generateLottos(int size) {
        List<Lotto> lottos = IntStream.range(0, size)
                .mapToObj(i -> new Lotto(RandomUtil.getSixRandomNumbers(1, 45)))
                .collect(Collectors.toList());
        return lottos;
    }
}
