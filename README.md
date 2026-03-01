Petit projet où j'ai décidé de faire des automates en kotlin.
Pour l'instant il y en a seulement 2 :  
- le premier étant un simple automate qui reconnaît des emojis faits à la main dans MonApplication.kt et AutomateSmiley
- le deuxième étant un automate qui reconnaît les jours/mois au format JJ:MM, la fonction AutomateDate lit le fichier date.txt et crée l'automate automatiquement
(bien plus rapide que de le faire à la main).

PS : la fonction date peut être utilisée pour n'importe quel autre automate avec un .txt différent (à l'exception du format qui reste le même), il suffit de changer l'inputStream.

Je reviendrai peut-être dessus un jour pour implémenter correctement le delta et l'utiliser pour un toString, et rajouter d'autres automates.
