package method4;
import java.io.*;
public class Output4 extends Filter {
    private File file;
    public Output4(File file, Pipe input) {
        super(input, null);
        this.file = file;
    }

    @Override
    public void transform() throws IOException {
        BufferedWriter outputFile =null;
        String line;
        try {
            outputFile = new BufferedWriter(new FileWriter(file));
            while (input.hashNextLine()) {
                outputFile.write(input.readerLine()+"\n");
            }
            outputFile.write("\r\n");//换行
            outputFile.write("该软件体系结构风格文字说明如下：");
            outputFile.write("\r\n");//换行
            outputFile.write("  管道-过滤器模式的体系结构是面向数据流的软件体系结构，主要用于实现复杂的数据多步转换处理。每个处理步骤封装在一个过滤器组件中。数据通过相邻过滤器之间的管道传输。");
            outputFile.write("\r\n");//换行
            outputFile.write("\r\n");//换行
            outputFile.write("关键代码如下：");
            outputFile.write("\r\n");//换行
            outputFile.write("管道类：");
            outputFile.write("\r\n");//换行
            outputFile.write("public class Pipe {\n" +
                    "    private Scanner pipeReader;\n" +
                    "    private PrintWriter pipeWriter;\n" +
                    "    Pipe(){\n" +
                    "        PipedWriter pipedWriter = new PipedWriter();\n" +
                    "        PipedReader pipedReader = new PipedReader();\n" +
                    "        try {\n" +
                    "            pipedWriter.connect(pipedReader);\n" +
                    "        } catch (IOException e) {\n" +
                    "            e.printStackTrace();\n" +
                    "        }\n" +
                    "        pipeReader = new Scanner(pipedReader);\n" +
                    "        pipeWriter = new PrintWriter(pipedWriter);\n" +
                    "    }\n" +
                    "    public String readerLine(){\n" +
                    "        return pipeReader.nextLine();\n" +
                    "    }\n" +
                    "    public boolean hashNextLine(){\n" +
                    "        return pipeReader.hasNext();\n" +
                    "    }\n" +
                    "    public void writerLine(String strLine){\n" +
                    "        pipeWriter.println(strLine);\n" +
                    "    }\n" +
                    "    public void closeReader(){\n" +
                    "        pipeReader.close();\n" +
                    "    }\n" +
                    "    public void closeWriter(){\n" +
                    "        pipeWriter.close();\n" +
                    "    }\n" +
                    "}\n");
            outputFile.write("\r\n");//换行
            outputFile.write("过滤器抽象类：");
            outputFile.write("\r\n");//换行
            outputFile.write("public abstract class Filter {\n" +
                    "    protected Pipe input;\n" +
                    "    protected Pipe output;\n" +
                    "\n" +
                    "    public Filter(Pipe input, Pipe output) {\n" +
                    "        this.input = input;\n" +
                    "        this.output = output;\n" +
                    "    }\n" +
                    "    protected abstract void transform() throws IOException;\n" +
                    "}\n");
            outputFile.write("\r\n");//换行
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
        input.closeReader();
    }
}
