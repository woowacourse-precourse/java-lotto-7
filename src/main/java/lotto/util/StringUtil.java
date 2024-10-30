package lotto.util;

public class StringUtil {
    public static Integer parseToPositiveInt(String strNum){
        try{
            int num = Integer.parseInt(strNum);
            if (num <= 0) {
                throw new IllegalArgumentException("[ERROR] 0 또는 음수 값을 입력 할 수 없습니다.");
            }
            return num;
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 1-45 사이의 값을 입력해 주세요.");
        }
    }
}
