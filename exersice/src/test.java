import method4.*;
import method2.Alphabetizer2;
import method2.Input2;
import method2.Output2;
import method2.Shift2;
import method3.*;
import method1.demo1;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class test {
    public static void main(String[] args) throws IOException {
        while(true) {
            System.out.println("请选择你的软件体系结构风格：");
            System.out.println("1.主程序-子程序体系风格\t\t2.面向对象体系风格");
            System.out.println("3.事件系统体系风格\t\t4.管道-过滤器体系风格");
            System.out.println("5.退出");
            int choose1,choose2;
            Scanner in = new Scanner(System.in);
            choose1 = in.nextInt();

            switch(choose1) {
                case 1:
                    demo1 kwic = new demo1();
                    kwic.main(kwic);
                    kwic.add();

                    System.out.println("还想再次选择吗？：1.是\t2.否");
                    choose2 = in.nextInt();
                    if (choose2 == 1){
                        break;
                    } else if (choose2 == 2) {
                        System.out.println("thanks！");
                        System.exit(0);//系统退出
                    }

                case 2:
                    //面向对象
                    Input2 input = new Input2();
                    input.input("C:\\\\input.txt");
                    Shift2 shift = new Shift2(input.getLineTxt());
                    shift.shift();
                    Alphabetizer2 alphabetizer = new Alphabetizer2(shift.getKwicList());
                    alphabetizer.sort();
                    Output2 output = new Output2(alphabetizer.getKwicList());
                    output.output("C:\\\\output.txt");
                    output.add();

                    System.out.println("还想再次选择吗？：1.是\t2.否");
                    choose2 = in.nextInt();
                    if (choose2 == 1){
                        break;
                    } else if (choose2 == 2) {
                        System.out.println("thanks！");
                        System.exit(0);//系统退出
                    }

                case 3:
                    //事件系统
                    KWICSubject kwicSubject = new KWICSubject();
                    //创建观察者
                    Input3 input3 = new Input3("C:\\input.txt");
                    Shift3 shift3 = new Shift3(input3.getLineTxt());
                    Alphabetizer3 alphabetizer3 = new Alphabetizer3(shift3.getKwicList());
                    Output3 output3 = new Output3(alphabetizer3.getKwicList(), "C:\\output.txt");
                    kwicSubject.addObserver(input3);
                    kwicSubject.addObserver(shift3);
                    kwicSubject.addObserver(alphabetizer3);
                    kwicSubject.addObserver(output3);
                    kwicSubject.startKWIC();

                    System.out.println("还想再次选择吗？：1.是\t2.否");
                    choose2 = in.nextInt();
                    if (choose2 == 1){
                        break;
                    } else if (choose2 == 2) {
                        System.out.println("thanks！");
                        System.exit(0);//系统退出
                    }

                case 4:
                    //管道-过滤器
                    File inFile = new File("C:\\input.txt");
                    File outFile = new File("C:\\output.txt");
                    Pipe pipe1 = new Pipe();
                    Pipe pipe2 = new Pipe();
                    Pipe pipe3 = new Pipe();
                    Input4 input4 = new Input4(inFile, pipe1);
                    Shift4 shift4 = new Shift4(pipe1, pipe2);
                    Alphabetizer4 alphabetizer4  = new Alphabetizer4(pipe2, pipe3);
                    Filter output4 = new Output4(outFile,pipe3);
                    input4.transform();
                    shift4.transform();
                    alphabetizer4.transform();
                    output4.transform();

                    System.out.println("还想再次选择吗？：1.是\t2.否");
                    choose2 = in.nextInt();
                    if (choose2 == 1){
                        break;
                    } else if (choose2 == 2) {
                        System.out.println("thanks！");
                        System.exit(0);//系统退出
                    }

                case 5:
                    //退出
                    System.out.println("thanks！");
                    System.exit(0);//系统退出

                default:
                    System.out.println("您输入的操作可能有误，请重新输入。");
                    break;
            }
        }
    }
}
