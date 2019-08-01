package steve.spring.jpa.springboot_jpa;

/**
 * @Author steve
 * @Date 2019/8/1
 * @Time 8:46
 * @Version 1.0
 */
public class Account {
    private Integer amount;

    public Account(Integer amount) {
        this.amount = amount;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public void subNotSync(){
        if (this.amount > 0) {
            this.amount --;
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("amount: "+amount);
    }
    public void subThisSync(){
        synchronized (this) {
            if (this.amount > 0) {
                this.amount --;
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("amount: " + this.amount);
    }
    public void subObjInAttrSync(){
        synchronized (this) {
            if (this.amount > 0) {
                this.amount --;
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("amount: " + this.amount);
    }
    // 预测无法锁住
    public void subObjInMethodSync(){
        Object o = new Object();
        synchronized (o) {
//            o = 2;// 测试失败
            if (this.amount > 0) {
                this.amount --;
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("amount: " + this.amount);
    }
    public void subBasicTypeObjectInMethodSync(){
        String a = "   ";
        synchronized (a) {
            a = "aaa";
//            o = 2;// 测试失败
            String b = a;
            if (this.amount > 0) {
                this.amount --;
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("amount: " + this.amount);
    }
}
