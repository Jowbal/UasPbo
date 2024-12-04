package view;

import java.util.Scanner;

public class InputView {
    private final Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public int mintaInputAngka(String pesan) {
        System.out.print(pesan);
        return scanner.nextInt();
    }

    public double mintaInputDouble(String pesan) {
        System.out.print(pesan);
        return scanner.nextDouble();
    }

    public String mintaInputString(String pesan) {
        System.out.print(pesan);
        return scanner.nextLine();
    }

    public char mintaInputKarakter(String pesan) {
        System.out.print(pesan);
        return scanner.next().charAt(0);
    }
}
