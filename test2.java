import java.lang.reflect.Field;
public class test2 {   
    private static int result = 42;  
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        
        // 通过字符串名字获取字段对象
        Field field = test2.class.getDeclaredField("result");
        
        // 设置字段为可访问
        field.setAccessible(true);
        
        // 获取字段的值并输出
        int value = (int) field.get(null);  // 如果是静态变量，第一个参数为null
        System.out.println("value of result: " + value);
    }
}

