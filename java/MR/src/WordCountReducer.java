import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
 
import java.io.IOException;
 
/**
 *  reduce阶段一种key只被调用一次
 * 泛型的四个参数:
 * KEYIN: 当前的一个单词
 * VALUEIN: map中输入过来的单词数量
 * KEYOUT: 当前的一个单词
 * VALUEOUT: 单词出现的总次数
 */
public class WordCountReducer extends Reducer<Text, LongWritable,Text,LongWritable> {
    private LongWritable outValue = new LongWritable();
 
    //Iterable<LongWritable>是一个集合(它是集合的最顶端的类,Collection继承了Iterable接口)
 
    @Override
    protected void reduce(Text key, Iterable<LongWritable> values, Context context) throws IOException, InterruptedException {
        //累加单词的数量
        long sum = 0;
        //遍历单词计数数组,将值累加到sum中
        for (LongWritable value : values) {
            sum += value.get();
        }
        outValue.set(sum);
 
        //输出每次最终的计数结果
        context.write(key,outValue);
    }
}