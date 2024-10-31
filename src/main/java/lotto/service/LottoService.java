package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.User;
import lotto.enums.LottoConstant;
import lotto.view.ErrorOutputView;

import java.util.List;

public class LottoService {
    // 싱글톤 패턴
    private static final LottoService instance = new LottoService();
    private final UserService userService = UserService.getInstance();

    protected LottoService() {
    }

    public static LottoService getInstance() {
        return instance;
    }

    public void getLottoTickets(int userId) {
        User user = userService.findById(userId);
        int lottoTicketCount = getLottoTicketCount(user.getPurchasePrice());
        saveLottoTickets(user, lottoTicketCount);
    }

    private int getLottoTicketCount(int purchasePrice) {
        return purchasePrice / LottoConstant.PRICE.getValue();
    }

    private void saveLottoTickets(User user, int lottoTicketCount) {
        while(lottoTicketCount > 0) {
            saveLotto(user,autoCreateLottoNumbers());
            lottoTicketCount--;
        }
    }

    private void saveLotto(User user, List<Integer> lottoTickets) {
        try {
            user.addLotto(new Lotto(lottoTickets));
        } catch (IllegalArgumentException e) {
            ErrorOutputView.printErrorMessage(e.getMessage());
        }
    }

    private List<Integer> autoCreateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

}
