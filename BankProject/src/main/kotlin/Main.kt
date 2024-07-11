fun main(args: Array<String>) {
    printWelcomeMessage()

    //comment the line below to go with random account selection
    val selectedOption :Int = readln().toInt()

    //uncomment this section to go with user input selection
    /*
    var selectedOption :Int = 0;
    var accountType :String = ""

    while(accountType == "") {
        println("Choose an option (1, 2 or 3)")
        selectedOption = (1..5).random()
        println("The selected option is $selectedOption")
        accountType += assignAccountType(selectedOption)
        println("You have created a $accountType account.")
    }
    */

    //comment the line below to go with random account selection
    println("The selected option is $selectedOption")

    //comment the line below to go with random account selection
    val accountType :String = assignAccountType(selectedOption)

}

fun printWelcomeMessage() {
    println("Welcome to your banking system." +
            "\nWhat type of account would you like to create?" +
            "\n1. Debit account" +
            "\n2. Credit account" +
            "\n3. Checking account" +
            "\nChoose an option (1, 2 or 3)")
}

fun assignAccountType(selectedOption :Int) :String {
    var result :String = ""
    when (selectedOption){
        1 -> result = "debit"
        2 -> result = "credit"
        3-> result = "checking"
    }

    return result
}