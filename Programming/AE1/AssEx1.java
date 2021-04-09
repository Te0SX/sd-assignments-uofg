/* 
    Instructions - Assessed Exercise 1
    - This exercise tests the things you've learnt in the first week of the semester.
    - Add your code to this file, leaving the main method unchanged (except for task 3).
    - Add all of your methods *below* the main method, in question order.
    - Each of the tasks involves writing a single method. You do not need to add additional main methods.
    - The total number of marks is 22.
    - Read the instructions for each task *carefully*.
    - Submit a single .java file on moodle by the deadline (details on moodle).
    - Do not change the name of the Java file, but ensure you add your name and 
        matric as requested below...
    - You do not need to add any additional import lines.
    - Everything you need to do these tasks is covered in the week 1 lectures and slides.
*/

/*
    Non task-specific marks:
     - Add a comment with your name and matric here - [1 mark]
     - Clear code commenting [1 mark]
     - Use of correct Java variable and method naming conventions [1 mark]
*/
import java.util.Scanner;

public class AssEx1 {
    public static void main(String[] args) {
        String date = "01/01/21";
        
        /* EXAMPLE TASK
            This is just here to show you what you should do.
            Create a method called comment that includes nothing but a single comment.
            It will be called by the line below.
            Look below main to 
        */
        comment();

        /* Task 1 [2 marks]
            Create a method called welcome that:
                - prompts the user to enter their name
                - saves their name in a string variable
                - prints the word "Hello" followed by whatever the user entered, followed by
                - whatever is stored in the String date.
        */
        welcome(date);

        /* Task 2 [3 marks]
            Write a method called divisors that is passed a single integer
            argument n. It should print out (on separate lines) all of the integers
            between 1 and n that divide n exactly (i.e. with remainder zero).
            For example divisors(12) should print:
            1
            2
            3
            4
            6
            12
            Your method *must* use a loop
        */
        int n = 10;
        divisors(n); 

        /* Task 3 [3 marks]
            Write a method called check that takes an integer as an argument and 
            returns a boolean value that is true if the integer is equal to 12, or is greater
            than 5 and less than 10. It should return false otherwise.
            Call the method four times with the integers
            1, 6, 11 and 12 respectively, printing the output each time on a new line. 
            You *must* use the and (&&) operator in your solution
        */
        
        

        
        /* Task 4 [6 marks]
            Write a method called calculator that prompts the user to input 
            an integer, an operator ('+', '-', '*', or '/') and finally another integer.
            The user should enter them *on the same line* and *separated by spaces*.
            (the space separation is important!!)
            The method should then perform the calculation, storing the result
            as a double. The operator '/' should perform floating point (not int) division.
            The full expression including the result should be printed using String.format
            where the result should be 7 characters long and have two digits after the decimal point.
            e.g. if the user types:
            4 / 3
            The program should output:
            "4 / 3 =    1.33"
            You don't need to do any error checking on the user input.
            Hint: if you have the whole expression stored as a String, you can
            split it up using a Scanner initialised with the String.
        */
        calculator();

        /* Task 5 [5 marks]
            Write a method called products. It should takes two integers as arguments, 
            corresponding to a number of rows and a number of columns.
            If either number is less than 0 or bigger than 20, the method should print an 
            error and return. This checking of the row and column numbers should use a separate method that
            checks if a single integer is <0 or >20. This method should be called twice from within products,
            once for the number of rows, once for columns.

            If the number of rows and columns is >=0 and <=20, the method should 
            print a table in which each entry is the product of the row and column positions (which
            go from 1 to the number of rows / columns respectively).


            The table should include heading rows and columns.
            For example, if rows=4 and columns=5, the table should look *exactly* like this:

   |  1  2  3  4  5
-------------------
  1|  1  2  3  4  5
  2|  2  4  6  8 10
  3|  3  6  9 12 15
  4|  4  8 12 16 20

            Each entry should be printed using String.format and its length should be the length of
            the largest value in the table plus one (i.e. in the example above, each entry has length
            3 because the largest value is 20 ("20" is two characters)).
            So, if, for example, the largest number is >= 100 then all lengths should be longer.
            For example, a table with 12 rows and 13 columns should look *exactly* like this:

    |   1   2   3   4   5   6   7   8   9  10  11  12  13
---------------------------------------------------------
   1|   1   2   3   4   5   6   7   8   9  10  11  12  13
   2|   2   4   6   8  10  12  14  16  18  20  22  24  26
   3|   3   6   9  12  15  18  21  24  27  30  33  36  39
   4|   4   8  12  16  20  24  28  32  36  40  44  48  52
   5|   5  10  15  20  25  30  35  40  45  50  55  60  65
   6|   6  12  18  24  30  36  42  48  54  60  66  72  78
   7|   7  14  21  28  35  42  49  56  63  70  77  84  91
   8|   8  16  24  32  40  48  56  64  72  80  88  96 104
   9|   9  18  27  36  45  54  63  72  81  90  99 108 117
  10|  10  20  30  40  50  60  70  80  90 100 110 120 130
  11|  11  22  33  44  55  66  77  88  99 110 121 132 143
  12|  12  24  36  48  60  72  84  96 108 120 132 144 156

            
        */
        products(13,7);
        products(-2,7);
        products(3,6);
        products(12,13);
        products(5,25);
    }

    /*
        Here's an example of how you write the solutions!
        Hint: you may find it easier to comment out method calls above
        until you've written the methods!
    */
    public static void comment() {
        // just a comment!
    }

}