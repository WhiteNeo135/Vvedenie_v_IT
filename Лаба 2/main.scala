import RecursiveData.{Cons, Leaf, Nil, Node, Tree, testListIntEmpty, testListIntHead, List}
import RecursiveFunctions.{reverse, map, append,flatMap, reversed, mapped, appended, flatMapped}
object main
{
    def main(args: Array[String]): Unit =
    {
        val l = Nil[Int]()
        val l2 = Cons[Int](2, l)

        println(testListIntEmpty(l))
        println(testListIntEmpty(l2))
        
        println()
        
        println(testListIntHead(l))
        println(testListIntHead(l2))

        var tree: Tree[Int] = Node( Node (Leaf(18), Node(Leaf(5), Leaf(6))), Leaf(7))
        println(tree)
        
        println()
        
        println(reversed)
        println(mapped)
        println()
        println(appended)
        println(flatMapped)
    }
}