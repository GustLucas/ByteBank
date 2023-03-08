fun main() {
    val contaWalter = Conta(titular = "Walter White", numero = 1000)

    val contaSkyler = Conta(numero = 1001, titular = "Skyler White")

    contaWalter.printConta()
    contaSkyler.printConta()

    contaWalter.deposita(150000.0)
    contaWalter.saca(1100.0)
    contaWalter.printConta()

    contaWalter.transfere(10000.0, contaSkyler)
    contaSkyler.printConta()

    contaWalter.printConta()

}

class Conta(
    var titular: String,
    val numero: Int = 0
) {
    var saldo = 0.0
        private set


    fun deposita(valor: Double) {
        if (valor > 0) {
            this.saldo += valor
            println("${this.titular}: Deposito realizado no valor de R$$valor ")
        }
    }

    fun saca(valor: Double) {
        if (this.saldo >= valor) {
            saldo -= valor
            println("${this.titular}: Saque realizado. Valor: R$$valor")
            println()
        }
    }

    fun transfere(valor: Double, destino: Conta): Boolean {
        if (saldo >= valor) {
            saldo -= valor
            destino.deposita(valor)
            println("${this.titular}: Transferência de R$$valor realizada para ${destino.titular}")
            println()
            return true
        }
        return false

    }

    fun printConta() {
        println()
        println("-----= Conta ByteBank =-----")
        println("Nome do Títular: ${this.titular}")
        println("Numero da conta: ${this.numero}")
        println("Saldo atual: ${this.saldo}")
        println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=")
        println()
    }
}
