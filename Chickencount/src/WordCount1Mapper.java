import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.*;

public class WordCount1Mapper extends MapReduceBase implements Mapper<LongWritable, Text, Text, IntWritable> {
    private Text word = new Text();
    private Text chicken = new Text("love");
	private final static IntWritable one = new IntWritable(1);

	public void map(LongWritable key, Text value, OutputCollector<Text, IntWritable> output, Reporter reporter) throws IOException {

		//String valueString = value.toString();
		//String[] SingleCountryData = valueString.split(",");
		StringTokenizer itr = new StringTokenizer(value.toString());
	      while (itr.hasMoreTokens()) {
	        word.set(itr.nextToken());
	        if(word.equals(chicken)) {
	        output.collect(word, one);
	        }
	      }
	}
}
