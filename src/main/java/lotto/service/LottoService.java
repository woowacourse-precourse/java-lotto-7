package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.LottoTickets;
import lotto.domain.User;
import lotto.enums.LottoConstant;
import lotto.util.ProgramExit;
import lotto.view.ErrorOutputView;
import lotto.view.OutputView;

import java.util.List;

import static lotto.enums.LottoConstant.ACCESS_COUNT;
import static lotto.view.OutputView.PURCHASED_LOTTO_COUNT;

public class LottoService {
    // 싱글톤 패턴
    private static final LottoService instance = new LottoService();
    private final UserService userService = UserService.getInstance();

    protected LottoService() {
    }

    public static LottoService getInstance() {
        return instance;
    }

    public void displayPurchaseLottoTickets(int userId) {
        LottoTickets lottoTickets = getLottoTicketsByUserId(userId);
        OutputView.printMessage(
                "\n" + lottoTickets.size() + PURCHASED_LOTTO_COUNT.getMessage());
        OutputView.printMessage(getLottoList(lottoTickets));
    }

    private LottoTickets getLottoTicketsByUserId(int userId) {
        User user = userService.findById(userId);
        return user.getLottoTickets();
    }

    private String getLottoList(LottoTickets lottoTickets) {
        StringBuilder sb = new StringBuilder();
        for(Lotto lotto : lottoTickets.getTickets()) {
            sb.append(lotto.getNumbers()).append("\n");
        }
        return sb.toString();
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
        for (int i = 0; i < lottoTicketCount; i++) {
            saveLotto(user);
        }
    }

    private void saveLotto(User user) {
        int accessCount = ACCESS_COUNT.getValue();
        for (int i = 0; i < accessCount; i++) {
            try {
                user.addLotto(new Lotto(autoCreateLottoNumbers()));
                return;
            } catch (IllegalArgumentException e) {
                ErrorOutputView.printErrorMessage(e.getMessage());
            }
        }
        ProgramExit.run(accessCount);
    }

    private List<Integer> autoCreateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

}
