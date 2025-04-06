package cn.lony.redisdemo;

import java.util.Optional;

public class OptionalMethods {
    public static void main(String[] args) {
        System.out.println("使用 orElse:");
        System.out.println(getValueWithOrElse());

        System.out.println("\n使用 orElseGet:");
        System.out.println(getValueWithOrElseGet());
    }

    public static Object getValueWithOrElse() {
        return Optional.ofNullable(null).orElse("222222");
    }

    public static Object getValueWithOrElseGet() {
        return Optional.ofNullable(null).orElseGet(OptionalMethods::getDefaultValue);
    }

    public static String getDefaultValue() {
        System.out.println("调用 getDefaultValue() 方法");
        return "默认值";
    }
}
