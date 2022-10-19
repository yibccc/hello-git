package method1;

import java.io.*;
import java.util.*;

public class demo1 {
    private ArrayList<String> kwicList = new ArrayList<String>();
    private ArrayList<String> lineTxt = new ArrayList<String>();
    private BufferedReader inputFile;
    private BufferedWriter outputFile;

    public void main(demo1 kwic) {

        //demo1 kwic = new demo1();
        kwic.input("C:\\input.txt");
        kwic.shift();
        kwic.alphabetizer();
        kwic.output("C:\\output.txt");
    }


    public void input(String fileName) {
        try {
            inputFile = new BufferedReader(new FileReader(fileName));
        } catch (Exception e) {
            e.printStackTrace();
        }
        String line;
        try {
            while ((line = inputFile.readLine()) != null) {
                lineTxt.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
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

    public void shift() {
        //获取每个单词，存入tokens
        Iterator<String> it = lineTxt.iterator();
        while (it.hasNext()) {
            StringTokenizer token = new StringTokenizer(it.next());
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
                kwicList.add(tmp);
            }
        }

    }


    public void alphabetizer() {
        Collections.sort(this.kwicList, new AlphabetizerComparator());
    }

    private class AlphabetizerComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            if (o1 == null && o2 == null) {
                throw new NullPointerException();
            }
            int compareValue = 0;
            char o1c = o1.toLowerCase().charAt(0); //忽略大小写
            char o2c = o2.toLowerCase().charAt(0); //忽略大小写
            compareValue = o1c - o2c;
            return compareValue;

        }

    }
    public void add() throws IOException {
        File f = new File("C:\\output.txt");
        BufferedWriter output = new BufferedWriter(new FileWriter(f,true));//true,则追加写入text文本

        output.write("\r\n");//换行
        output.write("该软件体系结构风格文字说明如下：");
        output.write("\r\n");//换行
        output.write("主程序/子程序风格将系统组织成层次结构，包括一个主程序和一系列子程序。\n"+
                "主程序是系统的控制器，负责调度各子程序的执行。各子程序又是一个局部的控制器，负责调度其子子程序的执行主程序/子程序风格的主要实现机制是模块实现，它将每个子程序都实现为一个模块, 主程序实现为整个系统的起始模块(在很多语言中，即为包含main函数的模块)。依照抽象规格的层次关系，实现模块也被组织为相应的层次机构，通过导入/导出关系相连接。\n" +
                "需要强调的是，虽然主程序/子程序风格非常类似于结构化程序的结构,但是主程序/子程序风格是基于部件与连接件建立的高层结构。\n" +
                "它的部件不同于程序，而是更加粗粒度的模块。而且，在部件的实现模块内部,可以使用结构化分析方法，也可以使用面向对象方法，这并不妨碍整个系统的高层结构符合主程序/子程序风格的约定。"
        );
        output.write("\r\n");//换行
        output.write("\r\n");//换行
        output.write("关键代码如下：");
        output.write("\r\n");//换行
        output.write("public static void main(String[] args) {\n" +
                "\n" +
                "        demo1 kwic = new demo1();\n" +
                "        kwic.input(\"C:\\\\input.txt\");\n" +
                "        kwic.shift();\n" +
                "        kwic.alphabetizer();\n" +
                "        kwic.output(\"C:\\\\output.txt\");\n" +
                "    }");
        output.write("\r\n");//换行
        output.flush();
        output.close();
    }
}
