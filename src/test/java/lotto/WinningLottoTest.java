package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class LottoServiceTest {
  
    @DisplayName("당첨번호와 입력받은 로또번호로 당첨결과를 반환한다.")
    @Test
    void compare_lotto() throws Exception{
        //given
        LottoService lottoService = new LottoService(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);
        Lotto issuedLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        //when
        lottoService.getWinnigResult(issuedLotto);
        //then
     
     }
}