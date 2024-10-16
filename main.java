import java.io.PrintStream;
import java.util.Scanner;
public class main {
    public static Scanner in = new Scanner(System.in); // Объявляем объект класса Scanner для ввода данных
    public static PrintStream out = System.out; // Объявляем объект класса PrintStream для вывода данных
    public static void main(String[] args) {
      out.println("Введите натуральное число для X: ");
      int X = in.nextInt(); //ввод натурального X
      if (X==0) { //проверка на француза
        out.println("НА НОЛЬ ДЕЛИТЬ НЕЛЬЗЯ, А ЕЩЕ ОН НЕ НАТУРАЛЕН, ВВЕДИТЕ ПОВТОРНО");
        X = in.nextInt(); // повторный ввод натурального X для франзуцов
      }
      out.println("Введите целые числа для A,B,C,D через пробел: ");
      int A = in.nextInt(), B = in.nextInt(), C =in.nextInt(), D = in.nextInt(); //ввод целых A,B,C,D
      int a1 = A % X; // поочередный подсчет отстатка от деления введеных элементов на X
      int b1 = B % X;
      int c1 = C % X;
      int d1 = D % X;
      int min1; // объявление необходимых переменных для работы условий и алгоритмов
      int min2;
      char fin1;
      char fin2;
      boolean same1 = false;
      boolean same2 = false;
      if (a1<=b1) { // попарное определение минимального элемента
        min1 = a1;  // A - минимальный остаток от элемента, запомним остаток и символ
        fin1 = 'A';
        if (a1==b1) {  // учтем случай равенства
           same1 = true;
        }
      }
      else {
        min1 = b1; // B - минимальный остаток от элемента, запомним остаток и символ
        fin1 = 'B';
      }
      if (c1<=d1) { // попарное определение минимального элемента
        min2 = c1; // С - минимальный остаток от элемента, запомним остаток и символ
        fin2 = 'C'; 
        if (c1==d1) { // учтем случай равенства
           same2 = true;
        }
      }
      else {
        min2 = d1; // D - минимальный остаток от элемента, запомним остаток и символ
        fin2 = 'D';
      }
      if (min1 <=min2) { //сравним получившиеся попарные результаты
        if (min1==min2) { //начнем со случая проверок возможных равенств, то есть наличия более одного элемента с минимальным остатком
          if (same1 && same2) { //случай полного равенства, то есть оба параметры same были обозначены как true
            out.println("Элементы имеют одинаковый остаток");
          }
          else {
            if (same1) { //случай равенства A, B и одного элемента из другой пары, то есть same2 остался false
              out.println("Элементы A, B и " + fin2 + " имеют одинаковый минимальный остаток");
            }
            else {
              if (same2) { //случай равенства C, D и одного элемента из другой пары, то есть same1 остался false
                out.println("Элементы " + fin1 + ", С и D имеют одинаковый минимальный остаток");
              }
              else { //случай совпадения элементов из разных пар, в которых все элементы различны.
                out.println("Элементы " + fin1 +" и " + fin2 +" имеют одинаковый минимальный остаток");
              }
            }
          }
        }
        else {
           if (same1) { //min1 - меньше min2, проверяем одинаковы ли элементы.
            out.println("Элементы A и B имеют одинаковый минимальный остаток");
           }
           else { //элементы первой пары различны, поэтому мы выводим один нужный нам из двоих вариантов
            out.println("Элемент " + fin1 + " имеет минимальный остаток");
           }
        }
      }
      else {
        if (same2) { //min2 - меньше min1, проверяем одинаковы ли элементы.
          out.println("Элементы C и D имеют одинаковый минимальный остаток");
         }
         else { //элементы второй пары различны, поэтому мы выводим один нужный нам из двоих вариантов
          out.println("Элемент " + fin2 + " имеет минимальный остаток");
         }
      }
    }
}
