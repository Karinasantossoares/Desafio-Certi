package MyFirstSpring.controllers


object NumbersUtil {

    private val unity = arrayOf(
        "", "um", "dois", "três", "quatro", "cinco",
        "seis", "sete", "oito", "nove", "dez", "onze",
        "doze", "treze", "quatorze", "quinze", "dezesseis",
        "dezessete", "dezoito", "dezenove"
    )
    private val hundred = arrayOf(
        "", "cento", "duzentos", "trezentos",
        "quatrocentos", "quinhentos", "seiscentos",
        "setecentos", "oitocentos", "novecentos"
    )
    private val ten = arrayOf(
        "", "", "vinte", "trinta", "quarenta", "cinquenta",
        "sessenta", "setenta", "oitenta", "noventa"
    )
    private val thousand = arrayOf("", "mil")


    fun readNumberExtensive(value: Int): String {
        if (value == 0) return "zero"
        var convertValue = value.toString()
        if (convertValue.length > 5) {
            return "Digite um valor entre -99999 e 99999"
        }
        var resultadoFinal = ""
        var saux: String
        var parteValor: String
        var n: Int
        var unid: Int
        var dez: Int
        var cent: Int
        var contador = 0

        while (convertValue != "0") {
            if (convertValue.length > 3) {
                //Pega os tres primeiros numeros
                parteValor = convertValue.substring(convertValue.length - 3, convertValue.length)
                convertValue = convertValue.substring(0, convertValue.length - 3)
            } else { // última parte do valor
                parteValor = convertValue
                convertValue = "0"
            }
            if (parteValor != "000") {
                saux = ""
                if (parteValor == "100") {
                    saux = "cem"
                } else {
                    n = parteValor.toInt(10) // para n = 371, tem-se:
                    cent = n / 100 // cent = 3 (centena trezentos)
                    dez = n % 100 / 10 // dez  = 7 (dezena setenta)
                    unid = n % 100 % 10 // unid = 1 (unidade um)
                    if (cent != 0) {
                        saux = hundred[cent]
                    }
                    if (n % 100 <= 19) {
                        saux = if (saux.isNotEmpty()) saux + " e " + unity[n % 100] else unity[n % 100]
                    } else {
                        saux = if (saux.isNotEmpty()) saux + " e " + ten[dez] else ten[dez]
                        if (unid != 0) {
                            saux = if (saux.isNotEmpty()) saux + " e " + unity[unid] else unity[unid]
                        }
                    }
                }
                if (contador != 0) saux = saux + " " + thousand[contador]
                resultadoFinal = if (resultadoFinal.isNotEmpty()) "$saux, $resultadoFinal" else saux
            }
            contador += 1
        }
        return resultadoFinal
    }
}