package method3;

public class Main3 {
    public static void main(String[] args) {
        //创建主题
        KWICSubject kwicSubject = new KWICSubject();
        //创建观察者
        Input3 input = new Input3("C:\\input.txt");
        Shift3 shift = new Shift3(input.getLineTxt());
        Alphabetizer3 alphabetizer = new Alphabetizer3(shift.getKwicList());
        Output3 output = new Output3(alphabetizer.getKwicList(), "C:\\output.txt");

        // 将观察者加入主题
        kwicSubject.addObserver(input);
        kwicSubject.addObserver(shift);
        kwicSubject.addObserver(alphabetizer);
        kwicSubject.addObserver(output);
        // 逐步调用各个观察者
        kwicSubject.startKWIC();
    }
}

