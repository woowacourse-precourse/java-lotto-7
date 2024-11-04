package lotto.sevice;

public class InputValidService {
    public boolean isMoney(String money){
        try{
            int mon = Integer.parseInt(money);
            return mon % 1000 == 0;
        } catch (IllegalArgumentException e){
            return false;
        }
    }

}
