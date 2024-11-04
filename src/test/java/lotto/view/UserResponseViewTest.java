package lotto.view;

import lotto.model.WinLotto;
import lotto.sevice.LottoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static lotto.view.UserResponseView.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatRuntimeException;
import static org.junit.jupiter.api.Assertions.*;

class UserResponseViewTest {
    LottoService lottoService;

    @BeforeEach
    public void startSetting(){
        lottoService = new LottoService();

    }
    @Test
    void startMessageTest() {
        startMessage();
    }

    @Test
    void countLottoMessageTest() {
        //given
        String money = "10000";
        int cnt = lottoService.countLotto(money);

        //when
        countLottoMessage(cnt);
    }

    @Test
    void randomLottoMessageTest() {
        //given
        List<Integer> ls = List.of(1,2,3,4,5,6);
        //when
        randomLottoMessage(ls);
    }

    @Test
    void winLottoMessageTest() {
        winLottoMessage();
    }

    @Test
    void bonusLottoMessageTest() {
        bonusLottoMessage();
    }

    @Test
    void lottoMessageTest() {
        //given
        int i = 4;
        WinLotto[] win = WinLotto.values();
        for(WinLotto lotto : win){
            if(lotto.getCnt().equals(String.valueOf(i))){
                lotto.setWin(1);
            }
        }
        //when
        lottoMessage(win);
    }

    @Test
    void revenueMessageTest() {
        //given
        double res = 66.454;
        String r = String.format("%.1f", res);
        //when
        revenueMessage(r);
    }

    @Test
    void errorMessageTest() {
        Assertions.assertThrows(IllegalArgumentException.class, ()->
                errorMessage("사용자 입력 잘못됨"));
    }
}