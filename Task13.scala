object Task13 extends App {

  def solution(s: String) = {
    val pattern = "^(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$".r
    val l = s.length - 3
    var n = List[String]()
    for (a <- 0 until l; b <- 0 until l - a; c <- 0 until l - a - b) {
      val sb = new StringBuilder(s)
      sb.insert(a + 1, ".")
      sb.insert(a + b + 3, ".")
      sb.insert(a + b + c + 5, ".")
      if (pattern.findFirstIn(sb).nonEmpty) n = pattern.findFirstIn(sb).getOrElse().toString :: n


    }
    n
  }


  println(s"Task 13 = ${solution("25525511135")}")
  // List("255.255.11.135", "255.255.111.35")
}
