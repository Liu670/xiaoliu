import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.util.StringUtils;
 
import java.io.IOException;
/**
 *  map阶段一次只处理一行数据
 * 泛型的四个参数:
 * KEYIN: map()中key的文本偏移量
 * VALUEIN: 当前的一行文本内容
 * KEYOUT: 经过map处理后的一个单词
 * VALUEOUT: 单词每次统计的数量,在mapper中这个就是 1
 */
public class WordCountMapper extends Mapper<LongWritable,Text,Text,LongWritable> {
    //尽可能节省内存资源
    private Text outKey = new Text();
    private LongWritable outValue = new LongWritable(1);
 
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        //如果当前数据不为空
        if (value!=null){
            //获取每一行的数据
            String line = value.toString();
            //将一行数据根据空格分开
//            String[] words = line.split(" ");
            String[] words = StringUtils.split(line,' ');//hadoop的StringUtils.split方法对大数据来说比Java自带的拥有更好的性能
            //输出键值对
            for (String word : words) {
                outKey.set(word);
                context.write(outKey,outValue);
            }
        }
    }
}