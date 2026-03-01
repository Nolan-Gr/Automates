fun main() {

    var choix: String
    val accepte = arrayListOf("1", "2")

    do {
        println("1. Smiley 1. ; :  2. - =  3. 3 )")
        println("2. JJ:MM")
        println("99. Arrêt de   l'application")
        println("-------------------------------------------------------")
        print("Votre choix (1-99) ? ")
        choix = readln()

        if (choix == "99") {
            print("Arrêt")
        } else if(choix in accepte) {
            print("Saisissez la chaîne à analyser : ")
            val chaineAnalyse = readln()

            when (choix) {
                "1" -> testerAutomate(chaineAnalyse, AutomateSmiley())
                "2" -> testerAutomate(chaineAnalyse, AutomateDate())
            }
        } else {
            println("Choix invalide")
        }

    } while (choix != "99")

}

private fun testerAutomate(chaine: String, automate: Automate) {

    if (automate.reconnaitre(chaine)) {
        println("OK")
    } else {
        println("KO")
    }
}
