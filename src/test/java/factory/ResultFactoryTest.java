package factory;

import java.util.List;
import java.util.Map;
import model.Amount;
import model.Lotto;
import model.BonusNumber;
import model.LottoCollection;
import model.Prize;
import model.WinningLottoNum;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ResultFactoryTest {

    private LottoCollection lottoCollection;

    @BeforeEach
    public void testInit() {
        lottoCollection = new LottoCollection();
        List<Integer> nums = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(nums);
        lottoCollection.add(lotto);
    }

    @Test
    void 당첨_테스트_1등() {
        List<Integer> nums = List.of(1, 2, 3, 4, 5, 6);
        WinningLottoNum winningLottoNum = new WinningLottoNum(nums);
        BonusNumber bonusNumber = new BonusNumber(winningLottoNum, "7");
        ResultFactory resultFactory = new ResultFactory(lottoCollection, winningLottoNum, bonusNumber);

        Map<Prize, Integer> result = resultFactory.getResult();

        assertThat(result.get(Prize.FIRST)).isEqualTo(1);
    }

    @Test
    void 당첨_테스트_2등() {
        List<Integer> nums = List.of(1, 2, 3, 4, 5, 8);
        WinningLottoNum winningLottoNum = new WinningLottoNum(nums);
        BonusNumber bonusNumber = new BonusNumber(winningLottoNum, "6");
        ResultFactory resultFactory = new ResultFactory(lottoCollection, winningLottoNum, bonusNumber);

        Map<Prize, Integer> result = resultFactory.getResult();

        assertThat(result.get(Prize.SECOND)).isEqualTo(1);
    }

    @Test
    void 당첨_테스트_3등() {
        List<Integer> nums = List.of(1, 2, 3, 4, 5, 10);
        WinningLottoNum winningLottoNum = new WinningLottoNum(nums);
        BonusNumber bonusNumber = new BonusNumber(winningLottoNum, "7");
        ResultFactory resultFactory = new ResultFactory(lottoCollection, winningLottoNum, bonusNumber);

        Map<Prize, Integer> result = resultFactory.getResult();

        assertThat(result.get(Prize.THIRD)).isEqualTo(1);
    }

    @Test
    void 당첨_테스트_4등() {
        List<Integer> nums = List.of(1, 2, 11, 4, 5, 10);
        WinningLottoNum winningLottoNum = new WinningLottoNum(nums);
        BonusNumber bonusNumber = new BonusNumber(winningLottoNum, "7");
        ResultFactory resultFactory = new ResultFactory(lottoCollection, winningLottoNum, bonusNumber);

        Map<Prize, Integer> result = resultFactory.getResult();

        assertThat(result.get(Prize.FOURTH)).isEqualTo(1);
    }

    @Test
    void 당첨_테스트_5등() {
        List<Integer> nums = List.of(45, 2, 11, 4, 5, 10);
        WinningLottoNum winningLottoNum = new WinningLottoNum(nums);
        BonusNumber bonusNumber = new BonusNumber(winningLottoNum, "7");
        ResultFactory resultFactory = new ResultFactory(lottoCollection, winningLottoNum, bonusNumber);

        Map<Prize, Integer> result = resultFactory.getResult();

        assertThat(result.get(Prize.FIFTH)).isEqualTo(1);
    }

    @Test
    void 미당첨_테스트() {
        List<Integer> nums = List.of(45, 9, 11, 4, 5, 10);
        WinningLottoNum winningLottoNum = new WinningLottoNum(nums);
        BonusNumber bonusNumber = new BonusNumber(winningLottoNum, "7");
        ResultFactory resultFactory = new ResultFactory(lottoCollection, winningLottoNum, bonusNumber);

        Map<Prize, Integer> result = resultFactory.getResult();

        assertThat(result.get(Prize.ZERO)).isEqualTo(1);
    }

    @Test
    void 수익률_5등_테스트(){
        List<Integer> nums = List.of(45, 2, 11, 4, 5, 10);
        WinningLottoNum winningLottoNum = new WinningLottoNum(nums);
        BonusNumber bonusNumber = new BonusNumber(winningLottoNum, "7");
        ResultFactory resultFactory = new ResultFactory(lottoCollection, winningLottoNum, bonusNumber);
        Amount amount = new Amount(5000);
        resultFactory.getResult();

        float earningRate = resultFactory.getEarningRate(amount);

        assertThat(earningRate).isEqualTo(100.00f);
    }

    @Test
    void 수익률_미당첨_테스트(){
        List<Integer> nums = List.of(45, 9, 11, 4, 5, 10);
        WinningLottoNum winningLottoNum = new WinningLottoNum(nums);
        BonusNumber bonusNumber = new BonusNumber(winningLottoNum, "7");
        ResultFactory resultFactory = new ResultFactory(lottoCollection, winningLottoNum, bonusNumber);
        Amount amount = new Amount(5000);
        resultFactory.getResult();

        float earningRate = resultFactory.getEarningRate(amount);

        assertThat(earningRate).isEqualTo(0.00f);
    }
}
