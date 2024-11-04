package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.service.Lotto;
import lotto.service.LottoService;
import lotto.view.LottoView;

import javax.swing.text.View;
import java.util.List;

public class LottoController {

  private final LottoService lottoService;
  private final LottoView lottoView;

  public LottoController() {
    this.lottoView = new LottoView();
    this.lottoService = new LottoService(); // Service 초기화
  }

  // 게임 시작 메서드
  public void startGame() {
    System.out.println("구입 금액을 입력해 주세요:");    // view 단으로 이동
    int amount = Integer.parseInt(Console.readLine());  // view 단으로 이동

    lottoView.inputAmount();


    // 로또 구매 및 번호 출력
    List<Lotto> userLottos = lottoService.generateUserLottos(amount);
    System.out.println(userLottos.size() + "개를 구매했습니다.");
    userLottos.forEach(lotto -> System.out.println(lotto.getNumbers()));

    // 당첨 번호 생성
    Lotto winningLotto = lottoService.drawWinningLotto();
    System.out.println("당첨 번호는: " + winningLotto.getNumbers());

    // 당첨 내역 확인
    lottoService.checkWinningNumbers(userLottos, winningLotto);
  }

}
