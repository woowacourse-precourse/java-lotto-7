package lotto.model.service;

import static lotto.config.LottoConfig.LOTTO_SIZE;
import static lotto.config.LottoConfig.MAX_NUMBER;
import static lotto.config.LottoConfig.MIN_NUMBER;
import static lotto.config.LottoConfig.PRICE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.config.LottoRank;
import lotto.model.domain.Lotto;
import lotto.model.domain.LottoResult;
import lotto.model.domain.WinningLotto;

public class LottoService {
    public List<Lotto> purchaseLottos(int amount){
        //로또를 몇개 구매했는지 확인하는 메소드
        return generateLottos(amount / PRICE);
    }

    private List<Lotto> generateLottos(int count){
        // 로또의 번호를 랜덤하게 생성하는 메소드
        return IntStream.range(0, count)
                .mapToObj(i -> new Lotto(Randoms.pickUniqueNumbersInRange(
                        MIN_NUMBER,
                        MAX_NUMBER,
                        LOTTO_SIZE)))
                .collect(Collectors.toList());
    }

    public static LottoResult calculateResult(List<Lotto> lottos, WinningLotto winningLotto) {
        //결과를 계산하는 메소드
        LottoResult result = new LottoResult();
        lottos.forEach(lotto -> {
            LottoRank rank = checkRank(lotto, winningLotto);
            result.addRank(rank);
        });
        return result;
    }

    private static LottoRank checkRank(Lotto lotto, WinningLotto winningLotto) {
        //당첨번호와 생성한 번호가 일치하는지 확인하는 메소드
        int matchCount = lotto.getMatchCount(winningLotto.getLotto());
        boolean matchBonus = lotto.contains(winningLotto.getBonusNumber());
        return LottoRank.valueOf(matchCount, matchBonus);
    }
}