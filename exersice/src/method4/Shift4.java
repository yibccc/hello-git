package method4;

import java.util.*;
import java.io.*;
public class Shift4 extends Filter {

    public Shift4(Pipe input, Pipe output) {
        super(input, output);
    }

    @Override
    public void transform() throws IOException {
        //获取每个单词，存入tokens
        while (input.hashNextLine()) {
            StringTokenizer token = new StringTokenizer(input.readerLine());
            ArrayList<String> tokens = new ArrayList<String>();
            int i = 0;
            //循环添加单词
            int count = token.countTokens();
            while (i < count) {
                tokens.add(token.nextToken());
                i++;
            }

            //display(tokens);
            //切割各个单词，不断改变起始值和利用loop实现位移。
            for (i = 0; i < count; i++) {
                StringBuffer lineBuffer = new StringBuffer();
                int index = i;
                for (int f = 0; f < count; f++) {
                    //从头继续位移
                    if (index >= count)
                        index = 0;
                    //存入StringBuffer
                    lineBuffer.append(tokens.get(index));
                    lineBuffer.append(" ");
                    index++;
                }
                String tmp = lineBuffer.toString();
                output.writerLine(tmp);
            }
        }
        input.closeReader();
        output.closeWriter();
    }
}
