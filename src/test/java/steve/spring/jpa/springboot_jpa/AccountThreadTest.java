package steve.spring.jpa.springboot_jpa;

/**
 * @Author steve
 * @Date 2019/8/1
 * @Time 11:27
 * @Version 1.0
 */
public class AccountThreadTest extends Thread {
    private Account account;
    private Integer times;
    private String threadName;

    public AccountThreadTest() {
    }

    public AccountThreadTest(String name, Account account, Integer times) {
        this.account = account;
        this.times = times;
        this.threadName = name;
    }

    @Override
    public void run() {
        System.out.println(threadName + ">>>>>>>>>");
        for (int i = 0; i < times; i++) {
//            this.account.subNotSync(); // 失败
//            this.account.subThisSync(); // 成功
//            this.account.subObjInAttrSync(); // 成功
//            this.account.subObjInMethodSync(); // 失败
            this.account.subBasicTypeObjectInMethodSync(); //
        }
    }
}
