Practica Refacció UF3 Entorns

Quins son els canvis?
1. Canvi de nom de les cariables, l'objectiu es fer les variables mes entenedores per po der utilitzar-les facilment.

Abans ------ Despres

`parser ------ lector`

`reader ------ llegir`

`obj ------ objecte`

`jsonArray ------ convertir`

`o -------- persona`

2. Creo les variables vName i vAge per poder separar l'objecte creat, gràcies a això podem utilitzar la variable creada i no tota la estona la sentencia d'objecte

`Object vName = jsonObject.get("name");
`

`Object vAge = jsonObject.get("age");
`

Finalment tenen un control d'errors perque name sigui un String i Age un Long

`if (!(vName instanceof String)) {
throw new InvalidNameException("Invalid valor per name" ); }`

`if (!(vAge instanceof Long)) {
throw new InvalidNameException("Invalid valor per age" ); }`

3. El catch ha sigut modificat, primerament tindra el catch per l'error del bucle per si no llegeix l'arxiu, i despres te un ltre catch pel control d'errors de les variables

4. Per finalitzar en el main hem posa be la ruta de examples.json(per llegir les dades) i ha sigut mogut a una altre classe fora de la que estaba, tot això per tenir-ho mes net i organtizat