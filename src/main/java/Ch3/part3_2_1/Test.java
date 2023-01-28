package Ch3.part3_2_1;

public class Test {

    public static void main(String[] args) {
        Runnable hello_world = () -> System.out.println("hello world1");
        Runnable hello_world1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello world2");
            }
        };

        process(hello_world);
        process(hello_world1);
        process(() -> System.out.println("hello world3"));


    }

    public static void process(Runnable runnable){
        runnable.run();
    }
}
