package lotto.controller;

import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.view.Policy;
import lotto.view.Validator;

public class LottoController {
    private final Policy policy;
    private final InputView inputView;
    private final OutputView outputView;

    private LottoController(Policy policy, InputView inputView, OutputView outputView) {
        this.policy = policy;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public static LottoController newDefaultInstance(Policy policy){
        return new LottoController(policy, new InputView(Validator.newInstance(policy)), new OutputView());
    }

    public void run(){
        // 구입금액 받기
        inputView.inputAmount();
        // 로또 객체 생성
        // 생성한 로또 객체 출력
        // 당첨번호 받기
        // 로또 추첨
        // 통계 출력
    }


}
