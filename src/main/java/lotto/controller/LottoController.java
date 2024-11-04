package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.User;
import lotto.service.LottoService;
import lotto.service.UserService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final UserService userService;
    private final LottoService lottoService;

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public LottoController(){
        this.userService = new UserService(inputView, outputView);
        this.lottoService = new LottoService(inputView, outputView);
    }

    /**
     * 프로그램 시작
     */
    public void run() {
        int lottoTickets = userService.inputAmount();
        User user = createUser(lottoTickets);
        Lotto winningLotto = createWinningLotto();
        winningResultView(user, winningLotto);
    }

    /**
     * 구매한 갯수 만큼의 로또 번호를 유저에 저장
     * @param lottoTickets 구매한 로또 갯수
     * @return 구매한 로또 번호를 가지고 있는 유저
     */
    private User createUser(int lottoTickets) {
        return userService.priceLotto(lottoTickets);
    }

    /**
     * 당첨 번호 저장
     * @return 당첨 번호가 저장된 클래스
     */
    private Lotto createWinningLotto() {
        Lotto lotto = lottoService.winningLottoNumbers();
        return lottoService.bonusLottoNumbers(lotto);
    }

    /**
     * 당첨 결과 계산 및 출력
     * @param user 구매한 로또 번호
     * @param lotto 당첨 번호
     */
    private void winningResultView(User user, Lotto lotto) {
        lottoService.winningResult(user, lotto);
    }
}
