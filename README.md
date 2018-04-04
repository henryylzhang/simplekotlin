# Greetings!

This homework is designed to force you to exercise your knowledge of the Kotlin programming language. This homework does not involve Android in any way.

Your task is simple: Make the code compile, and make all the unit tests pass. You may not change the tests that already exist in the code; you will also be asked to add a few tests, as well.

## Tools
In order to complete this homework, you will need a command-line installation of Kotlin, since Android Studio does not permit us to write Kotlin shell applications. There are several ways to obtain Kotlin, all of which are described [here](https://kotlinlang.org/docs/tutorials/command-line.html), but, summarized, consist of:

* *Download the Kotlin compiler directly.* It is found on the Kotlin website.
* *Use SDKMAN!* SDKMAN is a Unix-friendly Java-ecosystem installation manager. It will work on any *nix environment, which includes both macOS and most flavors of Linux. If you are running a recent build of Windows 10, it also works well inside the Ubuntu Shell (Windows Subsystem for Linux).
* *Use Homebrew for macOS.* Homebrew is by far the best option, but unfortunately it only works for macOS.

You may want a decent text editor for working with this assignment; VisualStudio Code comes highly recommended (it's what I used to create the assignment), and naturally you can use Android Studio itself to edit the files.

To run Kotlin code, first compile it at the command-line with

    kotlinc main.kt -include-runtime -d main.jar

The `-d` parameter tells Kotlin to compile the code into a single JAR file as the output. The `-include-runtime` flag tells Kotlin to include the Kotlin standard library as part of the generated JAR file. As a result, running the code should be as simple as

    java -jar main.jar

However, for purposes of this exercise, you can also use Kotlin as a scripting tool, by giving the file a `.kts` extension and running `kotlinc` with the `-script` parameter:

    kotlinc -script main.kts

This the expected use for this assignment.

***NOTE:*** The `main.kts` file will not run when you first check this code out; your job will be to make the code run and pass all the tests (that is, no "!" appearing in the output). You are not permitted to change the code below the "DO NOT CHANGE BELOW THIS LINE" comment--commenting out tests so that the tests "pass" is considered bad form, professionally. (Practically speaking, however, temporarily commenting them out so you can be certain some tests pass is acceptable, so long as you remember to uncomment them again.)

## To obtain this code...
... you must first obtain a copy of the source. Do that by cloning this repository:

    git clone https://bitbucket.org/TedNeward/uw-android-simplekotlin simplekotlin

This will create a local copy of the project. However, in order to *store* your changes to your own GitHub account, you need to create a new repository on GitHub (call it `simplekotlin`), and then change the project's settings to point to that new repository as the remote origin.

    git remote set-url origin https://github.com/[your-ID]/simplekotlin.git

This will work regardless of whether you got the syntax of the URL correct or not, so do a quick push to make sure it all worked correctly:

    git push

Git will ask you for your username and password, then (if everything was done correctly), it will upload the code to the new repository, and this is your new "home" for this project going forward. Verify the files are there by viewing your GitHub project through the browser.

***NOTE:*** Your grade for this assignment (and all future assignments) will be based on what we see in the GitHub repository, and nothing else. If it isn't in GitHub, it doesn't exist.

## The assignment
The code is broken into a sequence of sections. Your job is to implement the body of each section, so that the tests will pass.

The first section is intended as an opportunity to experiment with `when`. The `whenFn` takes an `Any` argument, and depending on the value of that argument, will return a String containing "world", "zero", "one", "Say what?" or "I don't understand", according to the following table:

* If it is "Hello", return "world"
* If it is any other string, return "I don't understand"
* If it is 0, return "zero"
* If it is 1, return "one"
* If it is any number between 2 and 10, return "low number"
* If it is any other number, return "a number"
* Otherwise, return "I don't understand"

The second section is to explore some function syntax. First, write two global functions, "add" and "sub" (subtract), which do exactly as you might expect: take two integers, and add them ("add") or subtract them ("sub") and return the result. Then, write a third function, called "mathOp", which takes two integers and a function argument that takes two integers and returns an int. In the body of `mathOp`, call the passed-in function argument with the two integer arguments, and return the result. (In other words, `mathOp` will simply turn around and call the function argument passed in.)

The third section is to explore classes. You are to create a standard "POJO"-type class called "Person", which should have three properties (firstName, a String; lastName, a String; and age, an Int), provide a constructor that takes all three properties as arguments, provides an "equals" implementation that tests whether two Persons hold the same values, and an appropriate "hashCode" implementation. (See "Effective Java", Item 9, for details if you've never seen this before.) Define a read-only "debugString" property on it that returns a String containing the Person data in a format like this: "[Person firstName:Ted lastName:Neward age:45]".

The fourth section is to explore classes and operator overloading. Create a class, "Money", that has two properties, "amount" and "currency". "Currency" can be one of "USD", "EUR", "CAN" and "GBP". "Amount" is a standard Int. Define the properties such that "amount" can never be less than zero, and that "currency" can only be one of those four symbols. Define a public method, `convert`, that takes a String argument for the currency type to convert to, and return a new Money instance with the amount converted. Conversion rates should be as follows: 10 USD converts to 5 GBP; 10 USD converts to 15 EUR; 12 USD converts to 15 CAN. (Make sure you can convert in both directions!) Define the "+" operator on Money to return a new instance of Money that adds the amount, converting the currency to the first (left-hand) Money's currency. So adding (10 USD) + (5 GBP) should return a result in USD. Similarly, adding (5 GBP) + (10 USD) should return the result in GBP.


