object Q1_2 extends App{

    val x = new Rational(3,4)
    val y = new Rational(5,8)
    val z = new Rational(2,7)
    val total= x-y-z

    println(total)


}
class Rational(n:Int,d:Int){
     
    require(d>0,"Denomenator must be greater than zero")
    def numer = n/GCD(math.abs(n),d)
    def denom = d/GCD(math.abs(n),d)
    def this(n:Int)=this(n,1)



    private def GCD(x:Int,y:Int):Int= if(y==0) x else GCD(y,x%y)

    def +(r:Rational) = new Rational(this.numer*r.denom + this.denom*r.numer, this.denom*r.denom)

    def neg = new Rational(-this.numer,this.denom)

    def -(r:Rational) = this + r.neg 

    override def toString = numer + "/" + denom


}