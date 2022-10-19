package method4;
import java.io.*;
public class Main4 {
    public static void main(String[] args) throws IOException {
        File inFile = new File("C:\\input.txt");
        File outFile = new File("C:\\output.txt");
        Pipe pipe1 = new Pipe();
        Pipe pipe2 = new Pipe();
        Pipe pipe3 = new Pipe();
        Input4 input = new Input4(inFile, pipe1);
        Shift4 shift = new Shift4(pipe1, pipe2);
        Alphabetizer4 alphabetizer  = new Alphabetizer4(pipe2, pipe3);
        Output4 output = new Output4(outFile,pipe3);
        input.transform();
        shift.transform();
        alphabetizer.transform();
        output.transform();

    }
}

