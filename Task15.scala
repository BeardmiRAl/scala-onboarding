import scala.annotation.tailrec

object Task15 extends App {

 case class Terrain(y: Int, x: Int)
/*
  def gridinit(grid: Array[Array[Char]],newgrid: Array[Array[Char]]):Array[Array[Char]] = {
    if (grid.isEmpty) newgrid
    else gridinit(grid.tail, Array(newgrid.head, '0' +: grid.head :+ '0') ++ newgrid.tail)
  }

 */
  def fgridinit(grid: Array[Array[Char]], tgrid: Array[Array[(Char,Int)]]): Array[Array[(Char,Int)]] ={
    if (grid.isEmpty) tgrid
    else fgridinit(grid.tail, Array(grid.head.zipWithIndex.filter(_._1 == '1')) ++ tgrid)
  }
/*
  def f2gridinit(grid: Array[Array[Char]], tgrid: Map[Char, Int]):Map[Char, Int] ={
    if (grid.isEmpty) tgrid
    else {
      grid.head.zipWithIndex.filter(_._1 == '1')
      f2gridinit(grid.tail, grid.head.zipWithIndex.filter(_._1 == '1').toMap ++ tgrid)
    }
    }
*/
  def getneighbours(ter: Terrain) = Vector(Terrain(ter.y-1,ter.x),Terrain(ter.y+1,ter.x),Terrain(ter.y,ter.x-1),Terrain(ter.y,ter.x+1))

  @tailrec
  def neighbourssearch(landsforcomp: IndexedSeq[Terrain], lands: IndexedSeq[Terrain], acc: Int,issingle: Boolean = true, visited: IndexedSeq[Terrain]):Int ={
    if (lands.isEmpty) acc+1
    else if (landsforcomp.contains(Terrain(lands.head.y+1,lands.head.x))||
      landsforcomp.contains(Terrain(lands.head.y-1,lands.head.x))||
      landsforcomp.contains(Terrain(lands.head.y,lands.head.x+1))||
      landsforcomp.contains(Terrain(lands.head.y,lands.head.x-1))) {
    neighbourssearch(landsforcomp,lands.tail,acc,false)
        }
    else if (!issingle) neighbourssearch(landsforcomp,lands.tail,acc+2, true)
    else neighbourssearch(landsforcomp,lands.tail,acc+1, true)


  // neighbourssearch(lands.tail, Map(lands.head -> lands.find(x =>  x ==Terrain(lands.head.y+1,lands.head.x))) ++ acc )
}


    //fgridinit(grid.tail, Array(grid.head.indexWhere{x: Char => x == '1'}) ++ tgrid)


  def solution(grid: Array[Array[Char]]) = {
    //  val bgrid = gridinit(grid.reverse, Array(Array('0', '0', '0', '0', '0', '0', '0'), Array('0', '0', '0', '0', '0', '0', '0')))
    //bgrid.foreach { x: Array[Char] => println(x.mkString(" ")) }
    val h = grid.length
    val w = grid(0).length
    //var counter = 0
    //var allroads = List[List[Int]]()
    val tt = fgridinit(grid.reverse,Array[Array[(Char,Int)]]())
    //tt.foreach { x: Array[(Char,Int)] => println(x.mkString(" "))}

    val land_coordinates = for ( i <- tt.indices; node <- tt(i)) yield (i, node._2)
    println(land_coordinates)
    val landlist = for (land <- land_coordinates) yield Terrain(land._1,land._2)
    println(landlist)






    //bgrid.zipWithIndex.foreach {x => println(x._1.mkString("Array(", ", ", ")"))}
    println(f"map ${h}x${w}")
    /*
        for (hi <- 1 to h; wi <- 1 to w) {
          if (bgrid(hi)(wi) == '1') {

          //allroads = check(hi,wi,List[List[Int]]()) :: allroads
          if (!allroads.contains(check(hi,wi,List[List[Int]]()))) counter += 1
          allroads = allroads ::: check(hi,wi,List[List[Int]]())

        }
    */
      /*
    }
    def check(x: Int, y: Int, visited: List[List[Int]]): List[List[Int]] = {
      if (bgrid(y)(x) == '0' || visited.contains(List(y,x))) {


        visited
      }
      else {
        bgrid(y)(x) = 0
        check(x+1,y, List(y,x) :: visited)
        check(x,y-1,List(y,x) :: visited)
          check(x-1,y,List(y,x) :: visited)
            check(x+1,y,List(y,x) :: visited)
      }
    }
    //println(allroads)
    counter
*/
      // for (hi <- 0 until h+2) println(bgrid(hi).collect(_ == '1').mkString("Array(", ", ", ")"))
      /*
    def hasexp(grid: Array[Array[Char]], x: Int, y: Int, counter: Int) = {
      (x,y) match {
        case (grid.length-2, grid(0).length - 2 ) => counter
      }
      }

    hasexp(bgrid,1,1,0)

 */

    neighbourssearch(landlist,landlist,0, false)
  }
  val grid1 = Array(
    Array('1', '1', '1', '1', '0'),
    Array('1', '1', '0', '1', '0'),
    Array('1', '1', '0', '0', '0'),
    Array('0', '0', '0', '0', '0')
  )

  println(s"Task 15 = ${solution(grid1)}") // 1

  val grid2 = Array(
    Array('1', '1', '0', '0', '0'),
    Array('1', '1', '0', '0', '0'),
    Array('0', '0', '1', '0', '0'),
    Array('0', '0', '0', '1', '1')
  )

  println(s"Task 15 = ${solution(grid2)}") // 3

  val grid3 = Array(
    Array('1', '1', '0', '0', '0'),
    Array('1', '0', '1', '0', '0'),
    Array('0', '0', '1', '0', '0'),
    Array('0', '0', '0', '1', '1')
  )

  println(s"Task 15 = ${solution(grid3)}") // 3

  val grid4 = Array(
    Array('1', '0', '0', '0', '0'),
    Array('0', '1', '0', '1', '0'),
    Array('0', '0', '0', '0', '0'),
    Array('1', '1', '0', '1', '1')
  )

  println(s"Task 15 = ${solution(grid4)}") // 5
}
