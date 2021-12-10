//сдано
import scala.util.{Try, Failure, Success}

/** Реализуйте следующие функции.
  * 
  * List(1, 2) match {
  *   case head :: tail => ???
  *   case Nil          => ???
  *   case l            => ???
  * }
  * 
  * Option(1) match {
  *   case Some(a) => ???
  *   case None    => ???
  * }
  * 
  * Either.cond(true, 1, "right") match {
  *   case Left(i)  => ???
  *   case Right(s) => ???
  * }
  * 
  * Try(impureExpression()) match {
  *   case Success(a)     => ???
  *   case Failure(error) => ???
  * }
  * 
  * Try(impureExpression()).toEither
  * 
  */
object Adts
{

  // a) Дан List[Int], верните элемент с индексом n

  def getNth (list: List[Int], n:Int): Option[Int] = Try(list(n)).toOption

  // примените функцию из пункта (a) здесь, не изменяйте сигнатуру 
  def testGetNth(list: List[Int], n: Int): Option[Int] = getNth(list,n)

  // b) Напишите функцию, увеличивающую число в два раза.
  
  def doubletwice(n:Option[Int]):Option[Int] = n.map(_*2) //Try(n*2).toOption

  // примените функцию из пункта (b) здесь, не изменяйте сигнатуру
  def testDouble(n: Option[Int]): Option[Int] = doubletwice(n)

  // c) Напишите функцию, проверяющую является ли число типа Int четным. Если так, верните Right. В противном случае, верните Left("Нечетное число.").

  def isEven(n:Int):Either[String, Int] = Option(n%2) match
  {
    case Some(0)=> Right(0)
    case Some(1)=>Left("Нечетное число")
  }

  // примените функцию из пункта (c) здесь, не изменяйте сигнатуру
  def testIsEven(n: Int): Either[String, Int] = isEven(n)

  // d) Напишите функцию, реализующую безопасное деление целых чисел. Верните Right с результатом или Left("Вы не можете делить на ноль.").

  def safeDivide(a:Int, b:Int): Either[String, Int]= Try(a/b) match
  {
    case Success(value)=> Right(value)
    case Failure(error) =>Left("Вы не можете делить на ноль")
  }

  // примените функцию из пункта (d) здесь, не изменяйте сигнатуру
  def testSafeDivide(a: Int, b: Int): Either[String, Int] = safeDivide(a,b)

  // e) Обработайте исключения функции с побочным эффектом вернув 0.

  def oldGoodJava(impure: String => Int, str: String):Try[Int] = Try(impure(str)) match 
  {
    case Success(value) => Success(value)
    case Failure(error) => Failure(error)
  }

  // примените функцию из пункта (e) здесь, не изменяйте сигнатуру
  def testGoodOldJava(impure: String => Int, str: String): Try[Int] =oldGoodJava(impure,str) 

}
