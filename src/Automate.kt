class Automate (

    // S : ensemble des états
    private val etats: MutableSet<Etat>,

    // A : alphabet
    private val alphabet: MutableSet<Char>,

    // delta
    private val delta: Map<Pair<Char,Etat>,Etat>,

    // S0 : état initial
    private val etatInitial: Etat,

    // Sf : états finaux
    private val etatsFinaux: MutableSet<Etat>
) {

    fun reconnaitre(chaine: String): Boolean {

        var etatCourant = etatInitial

        for (c in chaine) {

            // false si le caractère pas dans l'alphabet
            if (!alphabet.contains(c)) {
                return false
            }

            val suivant = etatCourant.transition(c)
                ?: return false   // false si la transition n'existe pas

            etatCourant = suivant
        }

        // true si état final
        return etatsFinaux.contains(etatCourant)
    }

    // faire un toString avec delta ?

}