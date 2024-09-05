class Account(private var balance: Double) {
  
  // Method to deposit money into the account
  def deposit(amount: Double): Unit = {
    require(amount > 0, "Deposit amount must be positive")
    balance += amount
    println(s"Deposited $$${amount}. New balance is $$${balance}.")
  }

  // Method to withdraw money from the account
  def withdraw(amount: Double): Unit = {
    require(amount > 0, "Withdrawal amount must be positive")
    if (amount <= balance) {
      balance -= amount
      println(s"Withdrew $$${amount}. New balance is $$${balance}.")
    } else {
      println(s"Insufficient funds. Withdrawal of $$${amount} failed.")
    }
  }

  // Method to transfer money from this account to another account
  def transfer(amount: Double, toAccount: Account): Unit = {
    require(amount > 0, "Transfer amount must be positive")
    if (amount <= balance) {
      this.withdraw(amount)
      toAccount.deposit(amount)
      println(s"Transferred $$${amount} to the given account.")
    } else {
      println(s"Insufficient funds. Transfer of $$${amount} failed.")
    }
  }

  // Method to check the balance of the account
  def checkBalance: Double = balance
}

object Main extends App {
  val account1 = new Account(1000.0)
  val account2 = new Account(500.0)

  println(s"Initial balance of Account 1: $$${account1.checkBalance}")
  println(s"Initial balance of Account 2: $$${account2.checkBalance}")

  account1.deposit(200.0)
  account1.withdraw(150.0)
  account1.transfer(300.0, account2)

  println(s"Final balance of Account 1: $$${account1.checkBalance}")
  println(s"Final balance of Account 2: $$${account2.checkBalance}")
}
