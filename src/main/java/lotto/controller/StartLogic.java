package lotto.controller;

import lotto.service.LottoService;

public class StartLogic {

    private final LottoService lottoService = new LottoService();

    public void start(){

        //User가 여러명일 경우 여기서 실행
        //while();
        lottoService.userInput();

    }


}
