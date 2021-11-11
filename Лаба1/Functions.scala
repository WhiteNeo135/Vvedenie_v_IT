//сделано

/** Напишите отдельные функции, решающие поставленную задачу. 
  * 
  * Синтаксис:
  *   // метод
  *   def myFunction(param0: Int, param1: String): Double = // тело
  * 
  *   // значение
  *   val myFunction: (Int, String) => Double (param0, param1) => // тело
  */
object Functions
{

  /* a) Напишите функцию, которая рассчитывает площадь окружности
   *    r^2 * Math.PI
   */
  def circle(r:Double)= r*r * scala.math.Pi //ready

  // примените вашу функцию из пункта (a) здесь, не изменяя сигнатуру
  def testCircle(r: Double): Double = circle(r) //ready


  /* b) Напишите карированную функцию которая рассчитывает площадь прямоугольника a * b.
   */
  def rectangle(a:Double) (b:Double)= a*b //ready

  // примените вашу функцию из пукта (b) здесь, не изменяя сигнатуру
  def testRectangleCurried(a: Double, b: Double): Double = rectangle(a)(b) //ready


  // c) Напишите не карированную функцию для расчета площади прямоугольника.
  def rectangleUc(a: Double, b: Double): Double= a*b  //ready

  // примените вашу функцию из пункта (c) здесь, не изменяя сигнатуру
  def testRectangleUc(a: Double, b: Double): Double = rectangleUc(a,b) //ready
}
