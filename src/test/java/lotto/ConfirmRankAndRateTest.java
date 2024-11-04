package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConfirmRankAndRateTest {


    private  ConfirmRankAndRate instance;

    @BeforeEach
    void init() {
        instance=new ConfirmRankAndRate();
    }

    @Test
    void calRateOfReturnTest1() {

        int[] rankCount={0,0,0,0,0,1};
        instance.setPurchaseAmount(8000);
        instance.setRankCount(rankCount);
        instance.calRateOfReturn();
        assertEquals(0.625,instance.getRateOfReturn());
    }



    @Test
    void check1stTest() {
        List<Integer> winningNum=List.of(1,2,3,4,5,6);
        instance.setLottoWinningNumbers(winningNum);
        Lotto lotto=new Lotto(List.of(1,2,3,4,5,6));
        assertEquals(true,instance.check1st(lotto));


    }

    @Test
    void check2stTest() {
        List<Integer> winningNum=List.of(1,2,3,4,5,8);
        instance.setLottoWinningNumbers(winningNum);
        Lotto lotto=new Lotto(List.of(1,2,3,4,5,7));
        instance.setBonusNumber(7);
        assertEquals(true,instance.check2st(lotto));

    }

    @Test
    void check3stTest() {
        List<Integer> winningNum=List.of(1,2,3,4,5,6);
        instance.setLottoWinningNumbers(winningNum);
        Lotto lotto=new Lotto(List.of(1,2,3,4,5,9));
        assertEquals(true,instance.check3st(lotto));

    }

    @Test
    void check4stTest() {
        List<Integer> winningNum=List.of(1,2,3,4,5,6);
        instance.setLottoWinningNumbers(winningNum);
        Lotto lotto=new Lotto(List.of(1,2,3,4,8,9));
        assertEquals(true,instance.check4st(lotto));

    }

    @Test
    void check5stTest() {
        List<Integer> winningNum=List.of(1,2,3,4,5,6);
        instance.setLottoWinningNumbers(winningNum);
        Lotto lotto=new Lotto(List.of(1,2,3,8,9,10));
        assertEquals(true,instance.check5st(lotto));

    }



    @Test
    void countRankCountTest(){
        instance.setLottoWinningNumbers(List.of(1,2,3,4,5,6));
        instance.setBonusNumber(8);
        List<Lotto> purchasedLottos=new ArrayList<>();
        purchasedLottos.add(new Lotto(List.of(1,2,3,4,5,6)));
        purchasedLottos.add(new Lotto(List.of(1,2,3,4,5,8)));
        purchasedLottos.add(new Lotto(List.of(1,2,3,4,9,10)));
        instance.setPurchasedLottos(purchasedLottos);
        instance.countRankCount();

        int [] actualArray=instance.getRankCount();
        //1등 1개 2등 1개 4등 1개
        int [] expectedArray={0,1,1,0,1,0};
        assertArrayEquals(expectedArray,actualArray);
    }


}
