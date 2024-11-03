package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    private final int START_NUMBER = 1;
    private final int END_NUMBER = 45;
    private final int COUNT_OF_LOTTO_NUMBER = 6;
    private final String INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private final String OUTPUT_MESSAGE = "%d개를 구매했습니다.\n";

    private final int price;
    private final List<Lotto> lottoList;

    public LottoGenerator(int price) {
        this.price = price;
        lottoList = new ArrayList<>();

        generateLottoList();
        printLottoList();
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }

    private void generateLottoList() {
        for (int i = 0; i < calculateCountOfLotto(); i++) {
            lottoList.add(generateLottoNumber());
        }
    }

    private int calculateCountOfLotto() {
        return price / 1000;
    }

    private Lotto generateLottoNumber() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, COUNT_OF_LOTTO_NUMBER));
    }

    private void printLottoList() {
        System.out.printf(OUTPUT_MESSAGE, lottoList.size());

        for (Lotto lotto : lottoList) {
            System.out.println(lotto.getNumbers().toString());
        }
    }
}