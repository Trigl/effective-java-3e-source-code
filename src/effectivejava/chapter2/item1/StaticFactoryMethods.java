package effectivejava.chapter2.item1;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Random;
import java.util.Set;

/**
 * @Description: 静态工厂方法
 * @Author: Baixin
 * @Create: 2019-08-25 19:44:07
 **/
public class StaticFactoryMethods {
    public static void main(String[] args) {
        BigInteger bigInt = BigInteger.probablePrime(2, new Random());

        Set<SampleEnum> s = Collections.synchronizedSet(EnumSet.noneOf(SampleEnum.class));

        try {
            // 首先要导入数据库驱动jar包、直接复制到文件那里，然后加入到路径
            // 1. 注册驱动，java反射机制
            Class.forName("com.mysql.jdbc.Driver");
            // 2. 创建一个连接对象
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "password");
            // 3. 创建一个sql语句的发送命令对象
            Statement stmt = conn.createStatement();
            // 4. 执行sql,拿到查询的结果集对象
            ResultSet rs = stmt.executeQuery("select * from stu");
            // 5. 输出结果集的数据
            while (rs.next()) {
                System.out.println(rs.getInt("id") + ":" + rs.getString("name"));
            }
            // 6. 关闭连接，命令对象以及结果集。
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    enum SampleEnum {
        ENUM1,
        ENUM2,
        ENUM3;
    }

}
