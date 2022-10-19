package method2;

public class Main2 {
    public static void main(String[] args) {
        Input2 input = new Input2();
        input.input("C:\\input.txt");
        Shift2 shift = new Shift2(input.getLineTxt());
        shift.shift();
        Alphabetizer2 alphabetizer = new Alphabetizer2(shift.getKwicList());
        alphabetizer.sort();
        Output2 output = new Output2(alphabetizer.getKwicList());
        output.output("C:\\output.txt");

    }
}
