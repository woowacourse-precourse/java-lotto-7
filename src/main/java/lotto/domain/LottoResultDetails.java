package lotto.domain;

public class LottoResultDetails {

    public static void count(Lottos lottos, WinningLottoNumber winningLottoNumber){
        int cnt = 0;

        for(Lotto lotto:lottos.getLottos()){
            boolean checkBonus = false;
            cnt = matchingCount(lotto, winningLottoNumber);
            if(cnt == 5){
                checkBonus = checkBonusInWinningLottoNumber(lotto,winningLottoNumber);
            }
            Rank.of(cnt,checkBonus);
        }
    }

    private static boolean checkBonusInWinningLottoNumber(Lotto lotto, WinningLottoNumber winningLottoNumber){
        boolean checkBonus = false;
        if(lotto.getNumbers().contains(winningLottoNumber.getBonusNumber().getBonus())){
            checkBonus = true;
        }
        return checkBonus;
    }

    private static int matchingCount(Lotto lotto, WinningLottoNumber winningLottoNumber){
        int cnt = 0;
        for(Integer winningNumber : winningLottoNumber.getWinningNumber().getNumbers()){
            if(lotto.getNumbers().contains(winningNumber)){
                cnt++;
            }
        }
        return cnt;
    }
}
