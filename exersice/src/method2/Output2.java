package method2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class Output2 {
    private ArrayList<String> kwicList;
    private BufferedWriter outputFile;

    public Output2(ArrayList<String> kwicList) {
        this.kwicList = kwicList;
    }

    public void output(String filename){
        Iterator<String> it = kwicList.iterator();
        try {
            outputFile = new BufferedWriter(new FileWriter(filename));
            while (it.hasNext()) {
                outputFile.write(it.next()+"\n");
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                if (outputFile!=null) {
                    outputFile.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void add() throws IOException {
        File f = new File("C:\\output.txt");
        BufferedWriter output = new BufferedWriter(new FileWriter(f,true));//true,则追加写入text文本

        output.write("\r\n");//换行
        output.write("该软件体系结构风格文字说明如下：");
        output.write("\r\n");//换行
        output.write("面向对象式风格借鉴面向对象的思想组织整个系统的高层结构。\n" +
                "面向对象式风格将系统组织为多个独立的对象，每个对象封装其内部的数据，并基于数据对外提供服务。\n" +
                "不同对象之间通过协作机制共同完成系统任务。\n");
        output.write("\r\n");//换行
        output.write("\r\n");//换行
        output.write("关键代码如下：");
        output.write("\r\n");//换行
        output.write("Input input = new Input();\n" +
                "input.input(\"C:\\\\input.txt\");\n" +
                "Shift shift = new Shift(input.getLineTxt());\n" +
                "shift.shift();\n" +
                "Alphabetizer alphabetizer = new Alphabetizer(shift.getKwicList());\n" +
                "alphabetizer.sort();\n" +
                "Output output = new Output(alphabetizer.getKwicList());\n" +
                "output.output(\"C:\\\\output.txt\");");//换行
        output.flush();
        output.close();
    }
}
