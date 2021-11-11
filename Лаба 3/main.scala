
object Hello
{
    def main(args: Array[String]) =
    {
        println(Adts.safeDivide(1, 0));
        println(Adts.isEven(4));
        println(Adts.doubletwice(Some(2)));
        
        println();
        
        println(Sequence.testLastElement(Seq(1,2,3)));
        println(Sequence.testZip(Seq(1,3,4), Seq(6,7,8)));
        println(Sequence.testPalindrom(Seq(2,3,3,2)));
        
        println()
        
        println(Strings.testTakeTwo("heyuaaoruw"));
        println(Strings.testComputation(5,9));
        println(Strings.testInterpolations("Andrey", 20));
        
    }
}
