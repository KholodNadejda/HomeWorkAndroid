package com.ru.code;
import java.util.Scanner;
import static java.lang.Math.abs;
public class Main {

    public static void main(String[] args) {

        task8();
        task7();
        task6();
        task5();
        task4();
        task3();
        task2();
        task1();
    }

    /**7) (Дополнительно) В переменную записываете количество программистов. В
     зависимости от количества программистов необходимо вывести правильно
     окончание. Например:
     • 2 программиста
     • 1 программиста
     • 10 программистов
     • и т.д.*/
    static void task7(){

        String enteredNumberInString;
        int numProgFull;

        enteredNumberInString = enterNumber("Введите количество программистов:");
        if (enteredNumberInString == null) {
            return;
        }
        numProgFull = Integer.parseInt(enteredNumberInString);
        if(numProgFull > 10) { //для чисел 11, 12, 13, 14 действует исключение в правилах русского языка
            enteredNumberInString = enteredNumberInString.substring(enteredNumberInString.length() - 2);
        }
        if (    Integer.parseInt(enteredNumberInString) == 11 ||
                Integer.parseInt(enteredNumberInString) == 12 ||
                Integer.parseInt(enteredNumberInString) == 13 ||
                Integer.parseInt(enteredNumberInString) == 14 ) {
            System.out.println(numProgFull + " программистов");
            return;
        }
        enteredNumberInString = enteredNumberInString.substring(enteredNumberInString.length() - 1);
        if (Integer.parseInt(enteredNumberInString) == 1) {
            System.out.println(numProgFull + " программист");
        } else if ( Integer.parseInt(enteredNumberInString) == 2 ||
                    Integer.parseInt(enteredNumberInString) == 3 ||
                    Integer.parseInt(enteredNumberInString) == 4) {
            System.out.println(numProgFull + " программиста");
        } else {
            System.out.println(numProgFull + " программистов");
        }
    }

    /**6) Даны 2 числа. Вывести большее из них.*/
    static void task6(){

        String forCheck;

        forCheck = enterNumber("Введите первое число:");
        if (forCheck == null) {
            return;
        }
        int frstNum = Integer.parseInt(forCheck);

        forCheck = enterNumber("Введите второе число:");
        if (forCheck == null) {
            return;
        }
        int secNum = Integer.parseInt(forCheck);

        System.out.println("Число " + Math.max(secNum, frstNum) + " большее");
    }

    static String enterNumber(String varNum){
        String keybordValue = null;
        for (int i = 1; i < 4; i++){ //более удобные параметры цикла, чтобы в код читался понятнее
            System.out.println(varNum);
            try{
                Scanner newScan = new Scanner(System.in);
                keybordValue = String.valueOf(newScan.nextInt()); //если делать статик в классе вне методов то он не вызываектся каждый раз заново и не дает вводить новые строки
            }
            catch (Exception ex)
            {
                System.out.println("Вы ввели некорректное число, осталось попыток: " + (3-i));
            }
        }
        return keybordValue;
    }
    /**
     * 1) В переменную записываем число. Надо вывести на экран сколько в этом
     * числе цифр и положительное оно или отрицательное. Например, "это
     * однозначное положительное число". Достаточно будет определить, является ли
     * число однозначным, "двухзначным или трехзначным и более.
     */
    static void task1(){

        String forCheck;

        forCheck = enterNumber("Введите число:");
        if (forCheck == null) {
            return;
        }
        int numEnter = Integer.parseInt(forCheck);
        if(numEnter < 0){
            System.out.print("Число отрицательное, ");
        } else if(numEnter > 0) {
            System.out.print("Число положительное, ");
        } else {
            System.out.println("Число 0");
            return;
        }
        if (abs(numEnter) > 9 && abs(numEnter) < 100) {
            System.out.println(" двухзначное.");
        } else if (abs(numEnter) < 10) {
            System.out.println(" однозначное.");
        } else {
            System.out.println(" трехзначное и более.");
        }
    }

    /**
     * 2) Треугольник существует только тогда, когда сумма любых двух его сторон
     * больше третьей. Определить существует ли такой треугольник. Дано: a, b, c –
     * стороны предполагаемого треугольника. Требуется сравнить длину каждого
     * отрезка-стороны с суммой двух других. Если хотя бы в одном случае отрезок
     * окажется больше суммы двух других, то треугольника с такими сторонами не
     * существует
     */
    static void task2(){
        String forCheck;

        forCheck = enterNumber("Введите сторону AB треугольника АВС:");
        if (forCheck == null) {
            return;
        }
        int sideAB = Integer.parseInt(forCheck);

        forCheck = enterNumber("Введите сторону ВС треугольника АВС:");
        if (forCheck == null) {
            return;
        }
        int sideBC = Integer.parseInt(forCheck);

        forCheck = enterNumber("Введите сторону СА треугольника АВС:");
        if (forCheck == null) {
            return;
        }
        int sideCA = Integer.parseInt(forCheck);

        if ((sideAB + sideBC) > sideCA && (sideAB + sideCA) > sideBC && (sideBC + sideCA) > sideAB){
            System.out.printf("Треугольник со сторонами %d, %d, %d существует", sideAB, sideBC, sideCA);
        } else {
            System.out.printf("Треугольник со сторонами %d, %d, %d не существует", sideAB, sideBC, sideCA);
        }
        System.out.println();
    }

    /**3) Дано целое число. Если оно является положительным, то прибавить к нему 1.
     //Если отрицательным, то вычесть из него 2. Если нулевым, то заменить его на
     //10. Вывести полученное число.
     */
    static void task3(){
        String forCheck;

        forCheck = enterNumber("Введите число:");
        if (forCheck == null) {
            return;
        }
        int numForTask = Integer.parseInt(forCheck);

        if (numForTask > 0){
            System.out.printf("Результат: %d", (numForTask+1));
        } else if (numForTask<0) {
            System.out.printf("Результат: %d", (numForTask-2));
        } else {
            System.out.print("Результат: 10");
        }
        System.out.println();
    }

    /**4) Даны 3 целых числа. Найти количество положительных чисел в исходном
     наборе.
     */
    static void task4() {
        String forCheck;
        int numOfNum = 0;
        for (int i = 0; i<3; i++) {
            forCheck = enterNumber("Введите " + (i+1) + " число: ");
            if (forCheck == null) {
                return;
            }
            if (Integer.parseInt(forCheck) > 0) {
                numOfNum++;
            }
        }
        System.out.printf("В исходном наборе положительных чисел: %d", numOfNum);
        System.out.println();
    }

    /**5) Даны 3 целых числа. Найти количество положительных и отрицательных
     чисел в исходном наборе.
     */
    static void task5() {

        int posNum = 0;
        int negNum = 0;
        String forCheck;

        for (int i = 0; i<3; i++) {
            forCheck = enterNumber("Введите " + (i+1) + " число: ");
            if (forCheck == null) {
                return;
            }
            if (Integer.parseInt(forCheck) > 0) {
                posNum++;
            }
            if (Integer.parseInt(forCheck) < 0) {
                negNum++;
            }
        }
        System.out.printf("В исходном наборе положительных чисел: %d.\nВ исходном наборе отрицательных чисел: %d.", posNum, negNum);
        System.out.println();
    }

    static void task8() {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите строку:");
        String S = in.nextLine();
        for (int i = 0; i<S.length(); i++){
            for (int j = i+1 ; j<S.length(); ++j ){
                if(S.charAt(i) == S.charAt(j) && S.charAt(i) != ' '){
                    System.out.printf("Первый повторяющийся символ: %s", S.charAt(i));
                    System.out.println();
                    return;
                }
            }
        }
        System.out.println("Повторяющихся символов нет.");
    }
}