import java.text.DateFormat.Field;

public class test {
        int num1 = 12;
        int num2 = 5;
        int result1 = num1/num2;

        double result2 = num1/num2;
        double result3 = num1/num2 + 0.0;
        double result4 = num1/(num2 + 0.0);
        double result5 = (double)num1/num2;
        double result6 = (double)(num1/num2);
    public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
        test t1 = new test();
        
        //System.out.println(t1.result1);
        String text = "num1 = 12;\nnum2 = 5;\nresult1 = num1/num2;\nresult2 = num1/num2;\nresult3 = num1/num2 + 0.0;\nresult4 = num1/(num2 + 0.0);\nresult5 = (double)num1/num2;\nresult6 = (double)(num1/num2);\n";
        System.out.print(text);
        int i = 1;
        while (i<7){
            String s = "result" + i;
            i++;
            // 通过字符串名字获取字段对象
            java.lang.reflect.Field field = test.class.getDeclaredField(s);
            // 设置字段为可访问
            field.setAccessible(true);
            // 获取字段的值并输出
            Object value = field.get(t1);  
            // 如果是静态变量，第一个参数为null,非静态变量则实例化之后引用
            // Object 类型是 Java 中的通用对象类型。当使用反射机制获取字段的值时，由于不确定具体字段的类型，因此将字段的值作为通用的 Object 类型返回
            if (field.getType() == int.class) {
                int intValue = (int) value;
                System.out.println("Value of " + field.getName() + ": " + intValue);
            } else if (field.getType() == double.class) {
                double doubleValue = (double) value;
                System.out.println("Value of " + field.getName() + ": " + doubleValue);
            }
        }
    }
}
