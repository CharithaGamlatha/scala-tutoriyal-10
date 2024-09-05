class Account(private var balance: Double) {

  // Method to deposit money into the account
  def deposit(amount: Double): Unit = {
    require(amount > 0, "Deposit amount must be positive")
    balance += amount
  }

  // Method to withdraw money from the account
  def withdraw(amount: Double): Unit = {
    require(amount > 0, "Withdrawal amount must be positive")
    if (amount <= balance) {
      balance -= amount
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
    } else {
      println(s"Insufficient funds. Transfer of $$${amount} failed.")
    }
  }

  // Method to check the balance of the account
  def checkBalance: Double = balance

  // Method to apply interest based on the balance
  def applyInterest(): Unit = {
    if (balance > 0) {
      balance += balance * 0.05
    } else {
      balance += balance * 0.1
    }
  }

  override def toString: String = s"Account(balance: $$${balance})"
}

class Bank(accounts: List[Account]) {

  // 4.1 List of accounts with negative balances
  def accountsWithNegativeBalances: List[Account] = {
    accounts.filter(_.checkBalance < 0)
  }

  // 4.2 Calculate the sum of all account balances
  def totalBalance: Double = {
    accounts.map(_.checkBalance).sum
  }

  // 4.3 Calculate the final balances of all accounts after applying interest
  def applyInterestToAllAccounts(): Unit = {
    accounts.foreach(_.applyInterest())
  }

  // To display all accounts in the bank
  override def toString: String = accounts.mkString(", ")
}

object Main extends App {
  val acc1 = new Account(1000.0)
  val acc2 = new Account(-200.0)
  val acc3 = new Account(500.0)
  val acc4 = new Account(-50.0)

  val bank = new Bank(List(acc1, acc2, acc3, acc4))

  println(s"Bank accounts: $bank")

  // 4.1 List of accounts with negative balances
  println("Accounts with negative balances: " + bank.accountsWithNegativeBalances.mkString(", "))

  // 4.2 Calculate the sum of all account balances
  println(s"Total balance of all accounts: $$${bank.totalBalance}")

  // 4.3 Apply interest and calculate final balances
  bank.applyInterestToAllAccounts()
  println(s"Bank accounts after applying interest: $bank")
  println(s"Total balance of all accounts after interest: $$${bank.totalBalance}")
}
