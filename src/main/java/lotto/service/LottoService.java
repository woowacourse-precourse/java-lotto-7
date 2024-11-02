package lotto.service;

import lotto.model.Lotto;
import lotto.utility.LottoNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class LottoService {
    private static final int LOTTO_PRICE = 1000;

    // 구입 금액에 맞춰 로또 여러 장 발행
    public List<Lotto> purchaseLottos(int amount) {
        int numberOfLottos = amount / LOTTO_PRICE;
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < numberOfLottos; i++) {
            List<Integer> numbers = LottoNumberGenerator.generate();
            lottos.add(new Lotto(numbers));
        }

        return lottos;
    }

    // 당첨 결과 계산 (추후 구현)
    public void calculateResults(List<Lotto> userLottos, Lotto winningLotto, int bonusNumber) {
        // TODO: 당첨 번호와 보너스 번호를 기반으로 당첨 통계 계산
    }

    // 수익률 계산 (추후 구현)
    public double calculateProfitRate(int totalWinnings, int totalSpent) {
        // TODO: 수익률 계산
        return (double) totalWinnings / totalSpent * 100;
    }
}
