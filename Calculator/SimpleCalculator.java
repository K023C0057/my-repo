package Calculator;

import java.util.Scanner;

public class SimpleCalculator{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("簡易電卓アプリ");
        System.out.println("終了するには'exit'と入力してください");

        while (true){
            System.out.print("最初の数値を入力してください");
            String input1 = scanner.nextLine();
            if (input1.equalsIgnoreCase("exit"))break; 
            
            System.out.print("演算子 (+, -, *, /)を入力してください: ");
            String operator = scanner.nextLine();

            System.out.println("次の数値を入力してください: ");
            String input2 = scanner.nextLine();
            if (input2.equalsIgnoreCase("exit"))break;

            try {
                double num1 = Double.parseDouble(input1);
                double num2 = Double.parseDouble(input2);
                double result = 0;

                switch (operator) {
                    case "+":
                        result = num1 + num2;
                        break;
                    case "-":
                        result = num1 - num2;
                        break;
                    case "*":
                        result = num1 * num2;
                        break;
                    case "/":
                        if (num2 == 0){
                            System.out.println("エラー: 0で割ることはできません");
                            continue;
                        }
                        result = num1 / num2;
                        break;
                    default:
                        System.out.println("エラー: 無効な演算子です。");
                        continue;
                }

                System.out.println("結果" + result);
            } catch (NumberFormatException e) {
                System.out.println("エラー: 無効な数値です");
            }
            {
                
            }
        }
        System.out.println("プログラムを終了します。");
        scanner.close();
    }
}