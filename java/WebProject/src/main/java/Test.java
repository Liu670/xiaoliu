import java.math.BigDecimal;

public class Test {

    public static void main(String[] args) {
        double n1 = 0.1;
        double n2 = 0.2;
        // 0.1+0.2=0.30000000000000004
        System.out.printf("%s+%s=%s\n",n1,n2,(n1+n2));
        // 解决小数精度问题 （计算不准确，计算机底层进行二进制计算时，会丢失精度）
        BigDecimal num1 = new BigDecimal(Double.toString(n1));
        BigDecimal num2 = new BigDecimal(Double.toString(n2));
        BigDecimal num = num1.add(num2);
        System.out.println("解决计算不准确,下面是正确结果输出：");
        System.out.printf("正确结果：%s+%s=%s",n1,n2,num);
    }
}
