//сдано
import scala.annotation.tailrec

/** Напишите свои решения в тестовых функциях.
  * 
  * Seq(1, 2) match {
  *   case head +: tail => ???
  *   case Nil          => ???
  *   case s            => ???
  * }
  * 
  * https://www.scala-lang.org/api/2.12.0/scala/collection/Seq.html
  */
// Примечание: напишите функции с хвостовой рекурсией

object Sequence
{

  /* a) Найдите последний элемент Seq.
   *    
   */
  def testLastElement[A](seq: Seq[A]) = seq.last

  /* b) Объедините две Seqs (то есть Seq(1, 2) и Seq(3, 4) образуют Seq((1, 3), (2, 4))) - если Seq длиннее игнорируйте оставшиеся элементы.
   *    
   */
  def testZip[A](a: Seq[A], b: Seq[A]): Seq[(A, A)] = a.take(2).zip(b.take(2))

  /* c) Проверьте, выполняется ли условие для всех элементов в Seq.
   *    
   */
  def testForAll[A](seq: Seq[A])(cond: A => Boolean): Boolean = false

  /* d) Проверьте, является ли Seq палиндромом
   *    
   */
  def testPalindrom[A](seq: Seq[A]): Boolean = if (seq.size == 1) true
  else if (seq.nonEmpty && seq.head == seq.last)
    testPalindrom(seq.tail.dropRight(1))
  else
    seq match
    {
      case Nil => true
      case _ => false
    }

  /* e) Реализуйте flatMap используя foldLeft.
   *    
   */
  def testFlatMap[A, B](seq: Seq[A])(f: A => Seq[B]): Seq[B] =
  {
    val tmp = seq.map(f) 
    tmp.foldLeft(Seq[B]())((outCurr, outAcc) => outCurr ++ outAcc)
  }
}


/*seq match
  {
    case Nil=>true
    case seq.size==1 => true
    case head==last =>testPalindrom(seq.tail.dropRight(1))
    case _=>false
  }*/