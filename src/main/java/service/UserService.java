package service;

import camp.nextstep.edu.missionutils.Randoms;
import domain.Lotto;
import domain.User;
import domain.WinningLotto;
import java.util.ArrayList;
import java.util.List;
import util.LottoGenerator;

public class UserService {

    private final LottoGenerator lottoGenerator;

    public UserService(LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    public void issueLotto(User user) {
        int purchaseCount = user.getPurchaseCount();
        List<Lotto> lottos = new ArrayList<>();
        for(int i = 0; i < purchaseCount; i++) {
            lottos.add(lottoGenerator.generateLotto());
        }
        user.updateLottos(lottos);
    }

    public void updateRateOfReturn(User user) {
        double rateOfReturn = calculateRateOfReturn(user);
        user.updateRateOfReturn(rateOfReturn);
    }

    private double calculateRateOfReturn(User user) {
        int totalPrizeMoney = calculateTotalPrizeMoney(user);
        return (double) totalPrizeMoney / user.getAmount() * 100;
    }

    private int calculateTotalPrizeMoney(User user){
        return user.getWinningLottos().stream()
                .mapToInt(WinningLotto::getPrizeMoney)
                .sum();
    }
}
