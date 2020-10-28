import scala.annotation.tailrec

/*
Даны два не пустых связных списка, представляющих два неотрицательных целых числа.
Цифры хранятся в обратном порядке, и каждый из их узлов содержит одну цифру.
Суммируйте два числа и верните их в виде связанного списка.
*/

object Task6_modified2 extends App {
  case class ListNode(
                       var x: Int = 0,
                       var next: ListNode = null
                     )

  @tailrec
  def hasnext(l1: ListNode, l2: ListNode, t: Int):ListNode = {
      l1 match {
      case null => l1
      case ListNode(x,next) => (l1.x+l2.x ) / 10 match {
        case 0 => {
          l1.x += l2.x + t
          hasnext(next, l2.next, 0)
        }
        case _ => {
          l1.x += l2.x - 10 + t
          hasnext(next, l2.next, 1)
        }
      }
      }
    }

  def solution(l1: ListNode, l2: ListNode) = {
  hasnext(l1,l2,0)
    l1
  }

  val ln1 = ListNode(2, ListNode(4, ListNode(3)))
  val ln2 = ListNode(5, ListNode(6, ListNode(4)))
  println(s"Task 6 = ${solution(ln1, ln2)}")
  // ListNode(7,ListNode(0,ListNode(8,null)))
}