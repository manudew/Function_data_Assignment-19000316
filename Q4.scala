object Q4 extends App{

   
    var acc=new Account("972432903V",11001234,120000.44)
    var acc1=new Account("973654789V",12344621,8000)
    var acc2=new Account("2019345111V",12344623,50000)
    var acc3=new Account("901234567V",12344623,-1500)
    var acc4=new Account("890456876V",12344623,-600)

     var bank:List[Account]=List(acc,acc1,acc2,acc3,acc4)

     val overdraft = (b:List[Account]) => b.filter(x=>x.balance < 0)


    val totalbalance= (b:List[Account]) => b.map(x => (x,x.balance)).reduce( (i,j) => (i._1,i._2 + j._2));

    println("\n\nAccounts with negative balances "+overdraft(bank))
    println("\n\nTotal Balance: "+totalbalance(bank)._2+"\n\n")
    var interest=(b:List[Account])=>b.map( x => {

        x.balance match {
            case i if i>=0 => x deposit x.balance*0.05

            case _ => x withdraw math.abs(x.balance)*0.1
        } 
        x
    } )

    

   println("Accounts after apply the interest: "+interest(bank))

    
}

class Account(id:String,acc:Int,bal:Double){

    var nic:String = id
    var accno:Long = acc
    var balance:Double = bal

    override def toString = "\nNIC: "+nic+"\nAccount No: "+accno+"\nBalance: "+bal+"\n"

    def withdraw(a:Double) = this.balance = this.balance - a

    def deposit(a:Double) = this.balance =  this.balance + a

    def transfer(a:Account,b:Double):Unit ={
        if(this.balance < b)  
            println("Your account balance is not suffient for transaction")
        else 
            withdraw(b) 
            a.deposit(b)
            println("You successfully transfered "+ b +" rupees to account number: " + a.accno + " ....!")
    } 

}