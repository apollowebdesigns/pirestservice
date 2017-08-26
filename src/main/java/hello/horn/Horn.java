package hello.horn;

public interface Horn {
    default void soundHorn() throws InterruptedException {
        System.out.println("no horn method implemented yet");
    };
}
