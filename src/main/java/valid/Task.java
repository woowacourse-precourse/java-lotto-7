package valid;

public interface Task<T> {
    T run();

    static <T> T reTryTaskUntilSuccessful(Task<T> task) {
        while(true) {
            try {
                return task.run();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
