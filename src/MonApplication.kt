import java.io.File
import java.io.InputStream

fun AutomateSmiley(): Automate{
    val e0 = Etat("E0")
    val e1 = Etat("E1")
    val e2 = Etat("E2")
    val e3 = Etat("E3")
    val e4 = Etat("E4")

    e0.ajouterTransition('>', e0)
    e0.ajouterTransition(':', e1)
    e0.ajouterTransition(';', e1)
    e1.ajouterTransition('-', e2)
    e1.ajouterTransition('=', e2)
    e2.ajouterTransition('3', e3)
    e2.ajouterTransition(')', e4)

    val etats = mutableSetOf(e0, e1, e2, e3,e4)
    val alphabet = mutableSetOf('>',':',';', '-','=','3', ')')
    val delta = mapOf(
        Pair('>',e0) to e0,
        Pair(':',e0) to e1,
        Pair(';',e0) to e1,
        Pair('-',e1) to e2,
        Pair('=',e1) to e2,
        Pair(':',e2) to e3,
        Pair(';',e2) to e4
    )
    val etatsFinaux = mutableSetOf(e3,e4)

    return Automate(etats, alphabet, delta, e0, etatsFinaux)
}

fun AutomateDate(): Automate {
    return AutomateTXT("src/date.txt")
}

fun AutomateTXT(path: String): Automate {
    val inputStream: InputStream = File(path).inputStream()

    val etats = mutableMapOf<String, Etat>()
    val etatsFinaux = mutableSetOf<Etat>()
    //delta
    val alphabet = mutableSetOf<Char>()
    var etatInit: Etat? = null

    inputStream.bufferedReader().forEachLine { line ->

        if (line.isBlank()) return@forEachLine //continue si la ligne est vide, sinon y'a erreur pr le else

        val mots = line.trim().split(" ")

        when (mots[0]) {

            "init" -> {
                val nom = mots[1]
                etatInit = etats.getOrPut(nom) { Etat(nom) }
            }

            "finals" -> {
                for (i in 1 until mots.size) {
                    val nom = mots[i]
                    val etat = etats.getOrPut(nom) { Etat(nom) }
                    etatsFinaux.add(etat)
                }
            }

            "alphabet" -> {
                for (i in 1 until mots.size) {
                    alphabet.add(mots[i][0])
                }
            }

            "ETAT" -> {
                val nom = mots[1]
                etats.getOrPut(nom) { Etat(nom) }
            }

            else -> {
                val from = etats[mots[0]]
                val to = etats[mots[mots.size - 1]]

                if (from == null) {
                    error("état ${mots[0]} pas défini")
                }

                if (to == null) {
                    error("état ${mots[mots.size - 1]} pas défini")
                }

                for (i in 1 until mots.size) {
                    val symbol = mots[i][0]
                    from.ajouterTransition(symbol, to)
                }
            }
        }
    }

    return Automate(
        etats.values.toMutableSet(),
        alphabet,
        emptyMap(),   //delta vide
        etatInit ?: error("Pas d'état initial"),
        etatsFinaux
    )
}