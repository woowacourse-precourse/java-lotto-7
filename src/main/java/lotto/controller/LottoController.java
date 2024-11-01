package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoManager;
import lotto.model.LottoMember;
import lotto.view.ManagerInputView;
import lotto.view.MemberInputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {

    private final MemberInputView memberInputView;
    private final ManagerInputView managerInputView;
    private final OutputView outputView;

    public LottoController() {
        this.memberInputView = new MemberInputView();
        this.managerInputView = new ManagerInputView();
        this.outputView = new OutputView();
    }

    public void run() {
        //구매자가 상품을 주문
        outputView.printGetPrice();
        Integer price = memberInputView.getPrice();
        LottoManager lottoManager = new LottoManager(price);

        //구매자가 상품을 사고 관리자가 상품을 구매자에게 넘겨줌
        Integer purchasedLottoTotal = lottoManager.purchaseLotto();

        LottoMember lottoMember = new LottoMember();
        for (Lotto lotto : lottoManager.getPurchasedLotto()) {
            lottoMember.setPurchasedLotto(lotto); // Lotto 객체를 추가
        }

        outputView.printPurchasedLottoCount(purchasedLottoTotal);
        outputView.printLottoPurchaseList(lottoMember.getPurchasedLotto());

        //관리자는 로또 번호를 생성함(로또 당첨 정기일이라 생각)
        outputView.printLottoNumber();
        List<Integer> lottoNumbers = managerInputView.getLottoNumbers();
        outputView.printLottoBonusNumber();
        Integer bonusNumber = managerInputView.getLottoBonusNumber();

        //구매자가 구매한 상품을 관리자에게 넘겨 당첨 여부와 수익률에 대해서 출력을 요청
        //관리자는 구매자가 구매한 상품과 생성된 로또 번호를 통해 당첨 수익률을 계산하고 당첨 통계를 구매자에게 응답.
        lottoManager.isLottoResult(lottoNumbers, bonusNumber);

        // 로또 몇등 당첨되었는지의 정보를 저장
        lottoMember.setLottoResult();

        //구매자에서 요청 내역 출력

    }
}
