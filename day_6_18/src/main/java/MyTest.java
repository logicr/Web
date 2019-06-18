/**
 * @author Jan on 2019/6/18.
 * @version 1.0
 * 抽象类练习，抽象类只不过是在类中加入了抽象方法，
 * 抽象方法没有方法体，必须由子类继承实现
 */

abstract class Model {
    public static final int NUM1 = 1;
    public static final int NUM2 = 2;
    public static final int NUM3 = 3;
    public void say(Integer num) {
        switch (num) {
            case NUM1:
                this.sayHello();
                break;
            case NUM2:
                this.sayBye();
                break;
            case NUM3:
                this.sayLove();
                this.sayBye();
                this.sayHello();
                break;
                default:
                    break;
        }
    }
    /**
     * model 1 say hello
     */
    public abstract void sayHello();

    /**
     * model2 say bye
     */
    public abstract void sayBye();

    /**
     * model 3 say love
     */
    public abstract void sayLove();
}

class Friend extends Model {

    @Override
    public void sayHello() {
        System.out.println("Hello");
    }

    @Override
    public void sayBye() {
        System.out.println("bey");
    }

    @Override
    public void sayLove() {
        System.out.println("No love");
    }

 }
class GirlFriend extends Model {

    @Override
    public void sayHello() {
        System.out.println("No hello");
    }

    @Override
    public void sayBye() {
        System.out.println("No bye");
    }

    @Override
    public void sayLove() {
        System.out.println("Love you");
    }
}

/**
 * 接口，接口可以多继承接口，接口中的的方法也是抽象的，省略了
 */
interface Iinterf {
    /**
     * say yes
     */
    void sayYes();

    /**
     * say dad
     */
    void sayDad();
}

interface Moke {

}

interface Dog {

}

interface Animal extends Moke, Dog, Iinterf {

}

class Li implements Iinterf {

    public void sayYes() {
        System.out.println("YesLi");
    }

    public void sayDad() {
        System.out.println("DadJan");
    }
}

class Ji implements Iinterf {

    public void sayYes() {
        System.out.println("YseJi");
    }

    public void sayDad() {
        System.out.println("DadJ");
    }
}
/**
 * @author Jan
 */
public class MyTest {
    public static void main(String[] args) {
        /*System.out.println("Hello Jan");
        Friend friend = new Friend();
        GirlFriend girlFriend = new GirlFriend();
        friend.say(3);
        girlFriend.say(3);*/
        new Li().sayDad();
        new Ji().sayDad();
    }
}
