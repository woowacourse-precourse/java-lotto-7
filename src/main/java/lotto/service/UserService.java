package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.collection.Lotto;
import lotto.collection.LottoTickets;
import lotto.domain.user.User;
import lotto.domain.user.UserRepository;
import lotto.enums.LottoConstant;
import lotto.util.DoLoop;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

import static lotto.view.OutputView.ENTER_PURCHASE_PRICE;
import static lotto.view.OutputView.PURCHASED_LOTTO_COUNT;

public class UserService {
    // 싱글톤 패턴
    private static final UserService instance = new UserService();
    private final UserRepository userRepository = UserRepository.getInstance();

    private UserService() {

    }

    public static UserService getInstance() {
        return instance;
    }

    public User save(String purchasePrice) {
        User user = new User(purchasePrice);
        return userRepository.save(user);
    }

    public User findById(int id) {
        return userRepository.findById(id);
    }

    public User inputPurchasePriceForUser() {
        return DoLoop.run(() -> {
           String purchasePrice = inputPurchasePrice();
           return save(purchasePrice);
        });
    }

    private String inputPurchasePrice() {
        OutputView.printMessage(ENTER_PURCHASE_PRICE);
        return InputView.readLine();
    }

    public void displayPurchaseLottoTickets(User user) {
        LottoTickets lottoTickets = getLottoTicketsByUserId(user);
        OutputView.newLine();
        OutputView.printMessage(lottoTickets.size() + PURCHASED_LOTTO_COUNT.getMessage());
        OutputView.printMessage(getLottoList(lottoTickets));
    }

    private LottoTickets getLottoTicketsByUserId(User user) {
        return user.getLottoTickets();
    }

    private String getLottoList(LottoTickets lottoTickets) {
        StringBuilder sb = new StringBuilder();
        for (Lotto lotto : lottoTickets.getTickets()) {
            sb.append(lotto.getNumbers()).append("\n");
        }
        return sb.toString();
    }

    public void getLottoTickets(User user) {
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
        DoLoop.run(() -> {
            user.addLotto(new Lotto(autoCreateLottoNumbers()));
            return null;
        });
    }

    private List<Integer> autoCreateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
