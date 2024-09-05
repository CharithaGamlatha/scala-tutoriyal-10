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

  // Override the toString method for a readable format
  override def toString: String = s"$numerator/$denominator"
}

object Main extends App {
  val x = new Rational(3, 4)
  println(s"Original: $x")        // Output: Original: 3/4
  println(s"Negated: ${x.neg}")   // Output: Negated: -3/4
}
