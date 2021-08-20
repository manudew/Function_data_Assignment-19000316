object Q3 extends App{
val acc=new Account("972432903V",11001234,120000.44)
val acc1=new Account("973654789V",12344621,80000)

acc.transfer(acc1,11000)
println(acc1.balance)
}

class Account(id:String,acc:Long,bal:Double){

    var nic:String = id
    var accno:Long = acc
    var balance:Double = bal

    override def toString = "NIC: "+nic+"\nAccount No: "+accno+"\nBalance: "+bal+"\n\n"

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