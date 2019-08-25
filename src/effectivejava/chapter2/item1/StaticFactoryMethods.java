package effectivejava.chapter2.item1;

import java.math.BigInteger;
import java.util.*;

/**
 * @Description: 静态工厂方法
 * @Author: Baixin
 * @Create: 2019-08-25 19:44:07
 **/
public class StaticFactoryMethods {
    public static void main(String[] args) {
        BigInteger bigInt = BigInteger.probablePrime(2, new Random());

        Set<SampleEnum> s = Collections.synchronizedSet(EnumSet.noneOf(SampleEnum.class));
    }

    enum SampleEnum {
        ENUM1,
        ENUM2,
        ENUM3;
    }
}
