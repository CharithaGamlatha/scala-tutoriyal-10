object Main extends App {

  def countLetterOccurrences(words: List[String]): Int = {
    // Step 1: Use map to transform each word into its length
    val lengths = words.map(_.length)

    // Step 2: Use reduce to sum up the lengths
    val totalLetters = lengths.reduce(_ + _)

    totalLetters
  }

  // Example usage
  val words = List("apple", "banana", "cherry", "date")
  val totalCount = countLetterOccurrences(words)

  println(s"Total count of letter occurrences: $totalCount")
}
