package steve.spring.jpa.springboot_jpa;

/**
 * @Author steve
 * @Date 2019/8/1
 * @Time 8:45
 * @Version 1.0
 */
public class SynchronizedTest {
    public static void main(String[] args) throws InterruptedException {
        Integer times = 5;
        Account account = new Account(10);
        Thread thread1 = new AccountThreadTest("thread1", account, times);
        Thread thread2 = new AccountThreadTest("thread2", account, times);
        Thread thread3 = new AccountThreadTest("thread3", account, times);
        Thread thread4 = new AccountThreadTest("thread4", account, times);
        Thread thread5 = new AccountThreadTest("thread5", account, times);
        thread1.start();
        Thread.sleep(20);
        thread2.start();
        Thread.sleep(30);
        thread3.start();
        Thread.sleep(40);
        thread4.start();
        Thread.sleep(50);
        thread5.start();
    }
}
