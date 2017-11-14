# PrimeTables
Generates a multiplication table of primes.

# How to run

This program was tested using Java 8 on a MacOS/Linux environment.

Running command: java -jar PrimeTables.jar

Then, insert the number of primes you would like to generate.

The program shall return the multiplication matrix.

The IDE Eclipse was used during the implementation. TestNG in Netbeans might not support all tests.

Git address https://github.com/leoncard/PrimeTables/

# What I'm pleased with

I have studied the sieve of Eratosthenes before implementing, I know that there are possible improvements but I'm happy that I did.

As my first experience with TDD, I'm pleased that I took sometime studying it before implementing and that I could improve my programming skills. I enjoyed this way of programming because we are ensuring that the program passes the tests from the beginning. It could be adopted by more companies than it is now.

This is my first try on making small commits as well. I believe it is a good practice because it is easier to revert to a previous version if necessary, and facilitates the merging, it also keeps the dev team updated.

I tried to increase extensibility by using the strategy patterns. For instance, this approach enables to implement different kinds of algorithms and pass to the abstract constructor. Same approach was taken to compute the matrix product and the display, which facilitates maintenance and re-use.

Because I had 7 days to finish, I decided to play a bit more with TDD before committing my final solution, specially the refactor part, this has slowed me a bit but in the end I improved my knowledge on the subject, so I am happy with it.

# What you would improve with more time

I would spend more time trying to decouple the code, specially testing other kinds of patterns for this specific problem to see the difference in code cohesion and decoupling, and also to improve my Refactoring skills on TDD.

I knew the algorithm to solve the problem when I started implementing but because I wasn't used to TDD yet I spent lots of time trying to understand how to provide the minimum code to pass the tests. I did Red, Green, Refactor, implementing the failing test, then the minimum production code to pass the test and refactoring. If I had more time I would spend more time practicing TDD.

I would also add more tests for Branch and Path Coverage as TDD not always cover all cases.

I would think on other kinds of outputs as the currently is not optimal. I am considering that the output is only for visualization purposes. If N is too big it is not interesting to show everything in the console. An approach that enables the user to navigate and an efficient search algorithm like binary search could improve readability.
