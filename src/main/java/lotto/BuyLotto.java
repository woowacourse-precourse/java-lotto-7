package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BuyLotto {
    private List<List<Integer>> lottoList;

    public BuyLotto(int numberOfLotto) {
        lottoList = new ArrayList<>();
        buyLotto(numberOfLotto);
    }

    private void buyLotto(int numberOfLotto) {
        lottoList = IntStream.range(0, numberOfLotto)
                .mapToObj(i -> Randoms.pickUniqueNumbersInRange(1, 45, 6)
                        .stream()
                        .sorted()
                        .collect(Collectors.toList()))
                .collect(Collectors.toList());
    }

    public void printLottoList() {
        for (List<Integer> integers : lottoList) {
            System.out.println(integers);
        }
    }

    public List<List<Integer>> getLottoList() {
        return lottoList;
    }

}
