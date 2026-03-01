class Etat (val nom: String) {

    private val transitions: HashMap<Char, Etat> = HashMap()

    fun ajouterTransition(symbole: Char, etatSuivant: Etat) {
        transitions[symbole] = etatSuivant
    }

    fun transition(symbole: Char): Etat? {
        return transitions[symbole]
    }
}