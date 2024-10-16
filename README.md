## Отчет по лабораторной работе № 1

#### № группы: `ПМ-2401`

#### Выполнил: `Москвитин Марк Александрович`

#### Вариант: `17`

### Cодержание:

- [Постановка задачи](#1-постановка-задачи)
- [Входные и выходные данные](#2-входные-и-выходные-данные)
- [Выбор структуры данных](#3-выбор-структуры-данных)
- [Алгоритм](#4-алгоритм)
- [Программа](#5-программа)
- [Анализ правильности решения](#6-анализ-правильности-решения)

### 1. Постановка задачи

> На вход программы подаются четыре целых чисел A, B, C, D. Необходимо определить число, имеющее наименьший остаток от деления на число X. На вход программы подаются натуральное число X и пять целых чисел A, B, C, D.

- Нам требуется создать алгоритм определения элемента с минимальным остатком от деления на натуральное число X среди введенных четырех целых чисел. Для этого воспользуемся условным оператором if.
- Несмотря на то, что по условию X - натуральное, необходимо отметить, что алгоритмом могут воспользоваться французы, записав 0, поэтому поставим небольшую так называемую защиту от дурака.
- Сначала вычислим остаток от деления на X, и запишем его в соответствующие значения. Постепенным сравнением определим минимальный остаток. 
- Объявим все необходимые переменные, которые понадобятся нам в будущем. 
- Определим минимальный остатков попарно среди остатков от A, B и C, D. Отдельно благодаря переменных логического типа обозначим возможность попарного равенства элементов.
- Далее сравним заранее определенные элементы с минимальным остатков, рассмотрев всевозможные случаи совпадения элементов. Введем название элемента благодаря символьному типу и посчитаем его. Выведем на экран нужный элемент, обозначив это в специальной фразе.

### 2. Входные и выходные данные

**Данные на вход**

По условии на вход нам падается четыре целых числа A,B,C,D и одно натуральное X, что вводится в рамках целочисленного типа данных.

|    Число    | Тип                | min значение    | max значение   |
|-------------|--------------------|-----------------|----------------|
|     X       |  Натуральное число |        1        |    +Infinity   |
|     A       |    Целое число     |    -Infinity    |    +Infinity   |
|     B       |    Целое число     |    -Infinity    |    +Infinity   |
|     C       |    Целое число     |    -Infinity    |    +Infinity   |
|     D       |    Целое число     |    -Infinity    |    +Infinity   |

**Данные на выход**

На выход представляется фраза, уточняющая контекст, в которую подставляется переменная типа char с обозначением, у какого из чисел минимальных остаток при делении на X.

В случае, при котором у элементов одинаковый остаток, выводится лишь специальная фраза.


### 3. Выбор структуры данных

Нам придется работать с целыми и натуральными числами, поэтому для их хранения воспользуемся переменными типо integer. Также не забудем про логические и символьные переменные, которые потребеются нам для проверки равенства в изначальных парах и выводе необходимого ответа.

|               |    Тип (в Java)    | min значение    | max значение   |  Название переменной  |
|---------------|--------------------|-----------------|----------------|-----------------------|
|       X       |      Integer       |        1        |   2147483647   |           X           |
|       A       |      Integer       |   -2147483648   |   2147483647   |           A           |
|       B       |      Integer       |   -2147483648   |   2147483647   |           B           |
|       C       |      Integer       |   -2147483648   |   2147483647   |           C           |
|       D       |      Integer       |   -2147483648   |   2147483647   |           D           |
| Остаток от A  |      Integer       |   -2147483648   |   2147483647   |           a1          |
| Остаток от B  |      Integer       |   -2147483648   |   2147483647   |           b1          |
| Остаток от C  |      Integer       |   -2147483648   |   2147483647   |           c1          |
| Остаток от D  |      Integer       |   -2147483648   |   2147483647   |           d1          |
| Min от a1,b1  |      Integer       |   -2147483648   |   2147483647   |          min1         |
| Min от c1,d1  |      Integer       |   -2147483648   |   2147483647   |          min2         |
|    a1 == b1   |      Boolean       |        -        |        -       |          same1        |
|    c1 == d1   |      Boolean       |        -        |        -       |          same2        |
|A / B - минимум|        Сhar        |        -        |        -       |          fin1         |
|C / D - минимум|        Сhar        |        -        |        -       |          fin2         |


### 4. Алгоритм
**Алгоритм работы программы**
1. Получаем на вход и считываем переменную **X**, выраженную натуральным числом. Проводим проверку на дурака: если ввод ровняется нулю, что допускается при нахождении во Франции, просим совершить пользователя повторный ввод.
2. Получаем на вход и считываем четыре целых числа **A, B, C, D.**
3. Создаем переменные **a1, b1, c1, d1**, для которых программа попеременно присваивает значения в виде остатков от деления **A, B, C, D** на **X**.
4. Объявляем переменные для программы, которые понадобятся нам в будущем: **min1** и **min2** (которым будет присвоено наименьшее значение среди пар **a1_b1** и **c1_d1** соответственно),**fin1** и **fin2** (которые будет присвоено имя минимального элемента в парах), а также логические переменные **same1** и **same2**, которые будут предназначены для ситуации равенства элементов в паре.
5. Программа начинает попарное сравнение. Сначала проверим условие  **a1<=b1**. Если оно является истинным, то **min1** будет присвоено значение **a1**, а **fin1** - **'A'**. Кроме этого, в этот момент будет дополнительно рассмотрено условие **a1==b1**. В случае его истинности, переменной **same1** будет присвоено значение **true**.
Однако если первое условие является ложным, то **min1** будет присвоено значение **b1**, а **fin1** - **'B'**.
6. Аналогично программа рассматривает **c1<=d1**, но уже с переменными **min2**, **same2** и **fin2**.
7. Теперь программа перейдет к рассмотрению  **min1<=min2**. Здесь нас ждут следующие варианты, если это условие истинно:
- Проверяем **min1==min2**. В случае истинности нам следует определить, какое именно количество элементов совпадает. Это проверяется по значениям переменных **same1** и **same2**. Если истины оба - выводим сообщением об одинаковом остатке, если верно только **same1** - выводим оба элемента первой пары и нужный элемент второй, если верно только **same2** - выводим оба элемента второй пары и нужный элемент первой.
- В случае ложного значения **min1==min2** программа проверяет значение **same1**, и в зависимости от этого выводит либо **fin1**, либо оба элемента первой пары.
- Если **min1<=min2** было ложно, то программа аналогично проверяет значение **same1**, и в зависимости от этого выводит либо **fin2**, либо оба элемента второй пары.

**Блок-схема**
```mermaid
%%{
  init: {
    'theme': 'base', 
     'themeVariables': {
        'fontSize': '90%'
      }
     }
}%%


graph TD
 A([Начало]) --> B[Ввести X]
 B --> C{X - натуральное число?}
 C -- "Да" --> D[Ввести целые A,B,C,D]
 C -- "Нет" --> D1[Повторно введите X]
 D1 --> C
 D --> E[Посчитать a1, b1, c1, d1 и объявить min1, min2, same1, same2, fin1 и fin2]
 E --> F{a1<= b1}
 F -- "Да" --> F3[min1=a1, fin1 = 'A']
 F -- "Нет" --> F4[min1=b1, fin1 = 'B']
 F3 --> F1{a1==b1}
 F1 -- "Да" --> F2[same1=true]
 F1 -- "Нет" --> G{с1<= d1}
 F2 --> G
 F4 --> G
 G -- "Да" --> G3[min2=c1, fin2 = 'C']
 G -- "Нет" --> G4[min2=d1, fin2 = 'D']
 G3 --> G1{c1==d1}
 G1 -- "Да" --> G2[same2=true]
 G1 -- "Нет" --> K{min1<= min2}
 G2 --> K
 G4 --> K
 K -- "Да" --> K1{min1==min2}
 K1 -- "Да" --> K2{same1 == true && </br> same2 == true}
 K2 -- "Да" --> P1[Выведи: Элементы имеют одинаковый остаток]
 K2 -- "Нет" --> K4{same1==true}
 K4 -- "Да" --> P2[Выведи: Элементы A, B и fin2, на место которого подставляется значение, имеют одинаковый минимальный остаток]
 K4 -- "Нет" --> K5{same2==true}
 K5 -- "Да" --> P3[Выведи: Элементы fin1, на место которого подставляется значение, и C, D имеют одинаковый минимальный остаток]
 K5 -- "Нет" --> P4[Выведи: Элементы fin1, на место которого подставляется значение, и fin2, на место которого подставляется значение, имеют одинаковый минимальный остаток]
 K1 -- "Нет" --> K7{same1=true}
 K7 -- "Да" --> P7[Выведи: Элементы A и B имеют одинаковый минимальный остаток]
 K7 -- "Нет" --> P8[Выведи: Элемент fin1, на место которого подставляется значение, имеет минимальный остаток]
 K -- "Нет" --> K9{same2==true}
 K9 -- "Да" --> P9[Выведи: Элементы C и D имеют одинаковый минимальный остаток]
 K9 -- "Нет" --> P10[Выведи: Элемент fin2, на место которого подставляется значение, имеет минимальный остаток]
 P1 --> Z([Конец])
 P2 --> Z
 P3 --> Z
 P4 --> Z
 P7 --> Z
 P8 --> Z
 P9 --> Z
 P10 --> Z
```

### 5. Программа

```java
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
 ``` 

### 6. Анализ правильности решения
Программа работает корректно при подстановке всевозможных различных значений.
1. Один элемент с минимальным остатком.
    - **Input**:
        ```
        3 
        3 4 4 4;

        3 
        4 3 4 4;

        3 
        4 4 3 4;

        3 
        4 4 4 3;
        ```
    - **Output**:
        ```
        A;
        B;
        C;
        D
        ```
2. Все элементы равны.
    - **Input**:
        ```
        3 
        4 4 4 4
        ```
    - **Output**:
        ```
        Элементы имеют одинаковый остаток
        ```
3. Равны элементы в первой паре и один из второй.
    - **Input**:
        ```
        3 
        3 3 3 4;

        3 
        3 3 4 3
        ```
    - **Output**:
        ```
        Элементы A, B и C имеют одинаковый минимальный остаток;

        Элементы A, B и D имеют одинаковый минимальный остаток
        ```
4. Равны элементы во второй паре и один из первой.
    - **Input**:
        ```
        3 
        4 3 3 3;

        3
        3 4 3 3
        ```
    - **Output**:
        ```
       Элементы B, С и D имеют одинаковый минимальный остаток;

       Элементы A, С и D имеют одинаковый минимальный остаток;
        ```
5. Равны минимальные элементы первой и второй пары.
    - **Input**:
        ```
        3 
        4 3 3 4;

        3 
        4 3 4 3;

        3
        3 4 3 4;

        3
        3 4 4 3;
        ```
    - **Output**:
        ```
       Элементы B и C имеют одинаковый минимальный остаток;

       Элементы B и D имеют одинаковый минимальный остаток;

       Элементы A и C имеют одинаковый минимальный остаток;

       Элементы A и D имеют одинаковый минимальный остаток;
        ```
6. Элементы первой или второй пары равны и минимальны
    - **Input**:
        ```
        3 
        4 4 5 5;

        3
        4 4 3 3
        ```
    - **Output**:
        ```
       Элементы A и B имеют одинаковый минимальный остаток;

       Элементы C и D имеют одинаковый минимальный остаток
        ```
7. Среди четырех чисел есть только один минимальный элемент
    - **Input**:
        ```
        3 
        4 5 5 5;

        3 
        5 4 5 5;

        3
        5 5 4 5;

        3
        5 5 5 4
        ```
    - **Output**:
        ```
       Элемент A имеет минимальный остаток;

       Элемент B имеет минимальный остаток;

       Элемент C имеет минимальный остаток;

       Элемент D имеет минимальный остаток;
        ```
