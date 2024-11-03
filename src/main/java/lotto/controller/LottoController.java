package lotto.controller;

import lotto.domain.User;
import lotto.service.UserService;

public class LottoController {

    private final UserService userService;

    public LottoController(){
        this.userService = new UserService();
    }

    public void run(){
        int lottoTickets  = userService.inputAmount();
        User user = userService.priceLotto(lottoTickets);
    }
}
