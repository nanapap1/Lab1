import java.io.PrintStream;
import java.util.Scanner;
public class main {
    public static Scanner in = new Scanner(System.in);
    public static PrintStream out = System.out;
    public static void main(String[] args) {
      out.println("Введите натуральное число для X: ");
      int X = in.nextInt(); //ввод натурального X
      if (X==0) {
        out.println("НА НОЛЬ ДЕЛИТЬ НЕЛЬЗЯ, А ЕЩЕ ОН НЕ НАТУРАЛЕН, ВВЕДИТЕ ПОВТОРНО");
        X = in.nextInt();
      }
      out.println("Введите целые числа для A,B,C,D через пробел: ");
      int A = in.nextInt(), B = in.nextInt(), C =in.nextInt(), D = in.nextInt();
      int a1 = A % X;
      int b1 = B % X;
      int c1 = C % X;
      int d1 = D % X;
      int min1;
      int min2;
      int elem1;
      int elem2;
      char fin1;
      char fin2;
      boolean same1 = false;
      boolean same2 = false;
      if (a1<=b1) {
        min1 = a1;
        elem1 = 1;
        if (a1==b1) {
           same1 = true;
        }
      }
      else {
        min1 = b1;
        elem1 = 2;
      }
      if (c1<=d1) {
        min2 = c1;
        elem2 = 3;
        if (c1==d1) {
           same2 = true;
        }
      }
      else {
        min2 = d1;
        elem2 = 4;
      }
      if (min1 <=min2) {
        if (min1==min2){
          if (same1 && same2){
            out.println("Элементы имеют одинаковый остаток");
          }
          else {
            if (same1) {
              fin2 = (char)('A' + (elem2 - 1));
              out.println("Элементы A, B и " + fin2 + " имеют одинаковый минимальный остаток");
            }
            else {
              if (same2) {
                fin1 = (char)('A' + (elem1 - 1));
                out.println("Элементы " + fin1 + ", С и D имеют одинаковый минимальный остаток");
              }
              else {
                fin1 = (char)('A' + (elem1 - 1));
                fin2 = (char)('A' + (elem2 - 1));
                out.println("Элементы " + fin1 +" и " + fin2 +" имеют одинаковый минимальный остаток");
              }
              
            }
            
          }

        }
        else {
           if (same1) {
            out.println("Элементы A и B имеют одинаковый минимальный остаток");
           }
           else {
            fin1 = (char)('A' + (elem1 - 1));
            out.println("Элемент " + fin1 + " "  + "имеет минимальный остаток");
           }
        }
        
      }
      else {
        if (same2) {
          out.println("Элементы C и D имеют одинаковый минимальный остаток");
         }
         else {
          fin2 = (char)('A' + (elem2 - 1));
          out.println("Элемент " + fin2 + " "  + "имеет минимальный остаток");
         }
      }

   
    }
}
