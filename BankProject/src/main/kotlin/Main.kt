var accountBalance :Int = (0..1000).random()

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

    println("The current balance is $accountBalance dollars")

    val money :Int = (0..1000).random()
    println("The amount you transferred is $money dollars")

    var output = 0;

    output = deposit(money)

    println("Output: $output \nCurrent balance: $accountBalance")
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

//checking and credit
fun withdraw(amount :Int) :Int{
    accountBalance -= amount
    println("You successfully withdrew $amount dollars.")
    return amount
}

fun debitWithdraw(amount :Int) :Int {
    if(amount <= accountBalance) {
        withdraw(amount)
    } else {
        println("Not enough money on this account! The current balance is $accountBalance dollars." +
                "\nThe amount you withdrew is 0 dollars.")
    }
    return amount
}

//checking and debit
fun deposit(amount :Int) :Int {
    accountBalance += amount
    println("You successfully withdrew $amount dollars. The current balance is $accountBalance")
    return amount
}

fun creditDeposit(amount :Int) :Int {
    if(accountBalance == 0) {
        println("You don't have to deposit anything in order to pay off the account " +
                "since it has already been paid off.")
        return accountBalance
    } else if(accountBalance + amount > 0) {
        println("Deposit failed. You tried to pay off an amount greater than the credit balance" +
                "The ckecking balance is $accountBalance dollars")
        return 0
    } else if(amount == accountBalance) {
        accountBalance = 0
        println("You have paid off this account!")
        return amount
    } else {
        deposit(amount)
    }
    return amount
}