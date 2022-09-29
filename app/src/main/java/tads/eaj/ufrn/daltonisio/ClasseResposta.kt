package tads.eaj.ufrn.daltonisio

data class ClasseResposta(var resp1:String, var resp2:String, var resp3:String) {

    fun resultadoResposta(): String {
        if (resp1.equals("") || resp2.equals("") || resp3.equals("")) {
            return "Digite valores válidos"
        } else {
            if (resp1.equals("29") && resp2.equals("74") && resp3.equals("2")) {
                return "Você não possui daltonismo"
            } else {
                return "Procure um oftalmologista"
            }
        }
    }

}