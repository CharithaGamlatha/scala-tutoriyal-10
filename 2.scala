class Rational(n: Int, d: Int) {
  require(d != 0, "Denominator cannot be zero")

  // Calculate the greatest common divisor
  private val gcdValue: Int = gcd(n.abs, d.abs)

  // Simplify the numerator and denominator
  val numerator: Int = n / gcdValue
  val denominator: Int = d / gcdValue

  // Auxiliary constructor for Rational with default denominator 1
  def this(n: Int) = this(n, 1)

  // Method to calculate GCD using Euclidean algorithm
  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

  // Method to negate the rational number
  def neg: Rational = new Rational(-numerator, denominator)

  // Method to subtract another rational number from this one
  def sub(that: Rational): Rational = {
    val newNumerator = this.numerator * that.denominator - that.numerator * this.denominator
    val newDenominator = this.denominator * that.denominator
    new Rational(newNumerator, newDenominator)
  }

  // Override the toString method for a readable format
  override def toString: String = s"$numerator/$denominator"
}

object Rational {

}

object Main extends App {
  val x = new Rational(3, 4)
  val y = new Rational(5, 8)
  val z = new Rational(2, 7)

  val result = x.sub(y.sub(z))
  println(s"The result of x y - z where x=3/4, y=5/8, z=2/7 is: $result")
}
