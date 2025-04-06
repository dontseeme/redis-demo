package cn.lony.redisdemo;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.RabbitTemplateCustomizer;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.atomic.AtomicStampedReference;

class Person {
    private int age;   // 年龄
    private String identityCardID;  // 身份证号码

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getIdentityCardID() {
        return identityCardID;
    }

    public void setIdentityCardID(String identityCardID) {
        this.identityCardID = identityCardID;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (!(obj instanceof  Person)) {
            return false;
        }
        Person personObj = (Person) obj;
        return this.age == personObj.getAge() && this.identityCardID.equals(personObj.getIdentityCardID());
    }

    @Override
    public int hashCode() {
        return age * 37 + identityCardID.hashCode();
    }
}

public class LambdaTest {

    private RabbitTemplate rabbitTemplate;

    @Test
    void test() {
//        String a = "abc";
//        Optional<String> optional = Optional.ofNullable(a);
////        boolean present = optional.isPresent();
////        boolean empty = optional.isEmpty();
////        System.out.println(present);
////        System.out.println(present);
//
//        // optional.ifPresent(System.out::println);
//        optional.ifPresentOrElse((t) -> {
//            System.out.println(t);
//        }, () -> {
//            System.out.println(1);
//        });
//
//        Hashtable<String, String> ht = new Hashtable<>();
//        ht.put("key", null);
        Person jack = new Person();
        jack.setAge(10);
        jack.setIdentityCardID("42118220090315234X");

        Set<Person> personSet = new HashSet<Person>();
        personSet.add(jack);

        jack.setAge(11);
        System.out.println(personSet.contains(jack));


        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        threadLocal.set("sss");


        // 设置初始值 100 及版本号 0
        AtomicStampedReference<Integer> integerRef = new AtomicStampedReference<>(100, 0);
        // 使用 CAS 加版本号一起尝试修改值，当值为 100 且版本号为 0 时，把值改成 200，版本号改成 1
        boolean flag = integerRef.compareAndSet(100, 200, 0, 1);
    }
}
