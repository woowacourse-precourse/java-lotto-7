package lotto.controller;

import lotto.service.UserService;

public class LottoController {

    private final UserService userService;

    public LottoController(){
        this.userService = new UserService();
    }

    public void run(){
        int purchaseAmount = userService.inputAmount();
    }
}
