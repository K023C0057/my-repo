package Calculator;

import java.util.Scanner;

public class SimpleCalculator2 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("簡易電卓アプリへようこそ");
        System.out.println("計算式を入力してください (例: 10 + 5)");
        System.out.println("終了するには 'exit' と入力して下さい");

        while(true) {
            System.out.print("計算式を入力>>");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) break;

            try {
                //入力を空白で分割して数値と演算子を抽出
                String[] parts = input.split(" ");
                if (parts.length != 3) {
                    throw new IllegalArgumentException("式の形が正しくありません。例: 10 + 5");
                }

                //数値と演算子を取得
                double num1 = Double.parseDouble(parts[0]);
                String operator = parts[1];
                double num2 = Double.parseDouble(parts[2]);

                //計算
                double result = switch(operator) {
                    case "+" -> num1 + num2;
                    case "-" -> num1 - num2;
                    case "*" -> num1 * num2;
                    case "/" -> {
                        if (num2 == 0) throw new ArithmeticException("0で割ることはできません");
                        yield num1 / num2;
                        }
                        default -> throw new IllegalArgumentException("無効な演算子です。+, -, *, / のみ使用可能です。");
                    };

                    //結果を表示
                    System.out.println("結果: " + result);

                } catch (Exception e) {
                    System.out.println("エラー: " + e.getMessage());
                }
            }

            System.out.println("プログラムを終了します");
            scanner.close();
        }
    }

