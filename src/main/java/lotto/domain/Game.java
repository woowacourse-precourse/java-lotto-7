package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private static final int LOTTO_MAX_COUNT = 100;

    private List<Lotto> lottos;
    private List<Integer> winningNumbers;
    private List<Lotto> winningLottos;


    // 생성자
    public Game(List<Lotto> lottos) {
        validateLottoMaxCount(lottos);
        this.lottos = lottos;
        this.winningNumbers = new ArrayList<>();
    }

    // 당첨 결과 비교



    // 수익률 계산


    // 등록된 로또 최대 개수 검증
    private void validateLottoMaxCount(List<Lotto> lottos) {
        if (lottos.size() > LOTTO_MAX_COUNT) {
            throw new IllegalArgumentException("[ERROR] 로또는 최대 100개까지만 발행할 수 있습니다.");
        }
    }
}
