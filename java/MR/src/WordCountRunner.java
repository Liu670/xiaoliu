import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class WordCountRunner extends Configured implements Tool {
 
    public static void main(String[] args) throws Exception {
        ToolRunner.run(new Configuration(),new WordCountRunner(),args);
    }
 
    @Override
    public int run(String[] args) throws Exception {
        //1.获取job
        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf, "word count");
 
        //2.配置jar包路径
        job.setJarByClass(WordCountRunner.class);
 
        //3.关联mapper和reducer
        job.setMapperClass(WordCountMapper.class);
        job.setReducerClass(WordCountReducer.class);
 
        //4.设置map、reduce输出的k、v类型
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(LongWritable.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(LongWritable.class);
        //5.设置统计文件输入的路径,将命令行的第一个参数作为输入文件的路径
        String path = ("hdfs://localhost:8020/data/wordcount/input.txt");
        FileInputFormat.setInputPaths(job,path);
        //6.设置结果数据存放路径,将命令行的第二个参数作为数据的输出路径
        FileOutputFormat.setOutputPath(job,new Path("hdfs://localhost:8020/output"));
        return job.waitForCompletion(true) ? 0 : 1;//verbose：是否监控并打印job的信息
    }
}