package lotto.view;

public class Exception {

    public static void typeException(){
        System.out.println("[ERROR] 숫자만 입력해 주세요.");
    }
    public static void numberException() {
        System.out.println("[ERROR] 숫자 형식이 아닙니다.");
    }

    public static void naturalException() {
        System.out.println("[ERROR] 금액은 0 초과이어야 합니다.");
    }

    public static void divisibleException() {
        System.out.println("[ERROR] 금액은 1000 단위여야 합니다.");
    }

    public static void rangeException() {
        System.out.println("[ERROR] 숫자는 1부터 45사이의 숫자여야 합니다.");
    }

    public static void sizeException() {
        System.out.println("[ERROR] 당첨 번호는 6개 입력 가능합니다.");
    }

    public static void overlapException() {
        System.out.println("[ERROR] 중복된 숫자를 입력하셨습니다.");
    }
}
