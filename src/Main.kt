fun main() {

    var choix: String
    val accepte = arrayListOf("1", "2", "3")

    do {
        println("1. Smiley 1. ; :  2. - =  3. 3 )")
        println("2. JJ:MM")
        println("3. plaque d'immatriculation format SIV AA-123-AA")
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
                "3" -> testerAutomate(chaineAnalyse, AutomatePlaque())
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
