# miniProjects 

Questa repository contiene i progetti realizzati per l'esame di **Algortimi e Strutture Dati** dell'anno accademico 2018/2019 presso l'Università di Camerino per il corso di Programmazione L-31.

## Descrizione

L'intento di ogni **miniProject** era quello di comprendere meglio il funzionamento degli algoritmi illustrati durante il corso e sul come implementarli adeguatamente in Java. Discorso analogo per ciò che concerne le strutture dati e il loro comportamento nel medesimo linguaggio di programmazione.

Per ognuno dei mini progetti esposti venivano adoperati dei criteri di valutazione come:
- Efficenza computazionale del codice
- Documentazione ben elaborata
- Superamento dei JUnit Test proposti 

## Tracce dei miniProjects

Di seguito sarà possibile visualizzare nello specifico le tracce di ogni mini progetto per andare a capire meglio lo scopo, e di conseguenza la realizzazione, di quest'ultimi.

### miniProject1

*Traccia del primo mini progetto:*

> Il progetto consiste nel realizzare l’implementazione di Qtre classi la cui struttura viene data già impostata: 
> - **CrivelloDiEratostene**,	una	classe	i	cui	oggetti	costruiscono	un	crivello	per	un	numero	dato	n	e	restituiscono	tutti	i	numeri	primi	minori	o	uguali	di	n	(si	veda	ad	esempio	https://it.wikipedia.org/wiki/Crivello_di_Eratostene)
> - **Factoriser**,	una	classe	singoletto	che	realizza	un	oggetto	attore	che	fa	la	fattorizzazione	in	numeri primi	di	un	dato	numero	intero.	L’oggetto deve	utilizzare un	crivello	per	il	suo	lavoro	e	restituire	il	risultato	come multinsieme di	fattori	primi	(si	veda	ad	esempio	https://it.wikipedia.org/wiki/Fattorizzazione)
> - **MyMultiset**,	una	classe	che	implementa	l’interface Multiset<E> fornita	dal	progetto.	Un	multinsieme è	un	insieme	in	cui	gli	elementi	hanno	una	molteplicità	(cioè	un	numero	di	volte	che	occorrono	nell’insieme).	Se	un	elemento	ha	molteplicità	zero	allora	non	appartiene	all’insieme.	E’	richiesta l’implementazione	di	tutti	i	metodi	della	interface fornita.	
> 
> Il	codice	fornito	è	sottoforma	di	progetto	Maven	(Apache	Maven:	https://maven.apache.org/)	in	Eclipse.	Sono	definiti	per	il	progetto	molti	metodi di	test	realizzati	con	JUnit	4	(https://junit.org/junit4/).	L’implementazione	dovrebbe	passare tutti	i	test	forniti.	

### miniProject2

*Traccia del secondo mini progetto:*

> Il	progetto	consiste	nel:
> 1. Implementare	la	classe	```AVLTree<E>``` e	la	sua	classe	interna	```AVLTreeNode```.	La	struttura	di	entrambe	le	classi	è già	impostata	nella	traccia	e	alcuni	metodi	sono	già	implementati.	Non	è	consentito	cambiare	le	variabili	istanza	che	sono	già	impostate	né	cambiare	l’implementazione	dei	metodi	già	implementati. Sono	definiti	diversi	metodi	di	test	realizzati	con	JUnit	4	(https://junit.org/junit4/). L’implementazione	delle	classi	dovrebbe	passare	tutti	i	test	forniti;
> 2. Eseguire	il	framework	di	valutazione	degli	algoritmi	di	ordinamento	(fornito	nel	codice)	confrontando	le	prestazione	degli	algoritmi	forniti.	In	particolare	l’algoritmo	```AVLTreeSort``` già	fornito	si	basa	sulla	corretta	ed	efficiente	implementazione	della	classe	```AVLTree<E>``` e	della	classe	interna	```AVLTreeNode```.	I	dati	prodotti	dal	framework	di	valutazione	(file	csv, comma-separated	values https://it.wikipedia.org/wiki/Comma-separated_values)	dovranno	essere	elaborati	con	un	foglio	elettronico	(ad	esempio	Excel	o	OpenOffice)	o	con	un	framework	che	permette	l’uso	di	tabelle	di	dati	e	calcoli	statistici	(ad esempio	R,	MatLab	o	Mathematica)	per	calcolare,	per	valori	di	lunghezza	crescenti	delle	sequenze	numeriche generate	casualmente	e	per	ogni	algoritmo	analizzato:
>    + Il	minimo (caso	ottimo)
>    + Il	massimo (caso	pessimo)
>    + La	media	aritmetica	(caso	medio)
>    + La	deviazione	standard	(caso	medio)
>
>    Dei seguenti valori:
>    + Numero	di	confronti	effettuati	dall’algoritmo
>    + Tempo	di	esecuzione	dell’algoritmo	in	nanosecondi.
> 
>    I	valori	elaborati	dovranno	poi	essere	usati	per	creare	dei	grafici	che	permettano	di	valutare	e	confrontare	le	prestazioni	dei	vari	algoritmi.	Tale	valutazione	e	confronto	deve	essere	riportato	in	una	relazione	scritta	in	formato	PDF	contenente	i	grafici	e	il	loro	commento.	In	particolare	i	grafici	delle	prestazioni	dei vari	algoritmi	dovranno	essere	comparati	tra	loro	e	con	i	grafici	delle	funzioni	**f(n)	=	n^2** e	**g(n)	=	n	*	log2 n**.
>
> Il	codice	è	fornito	sottoforma	di	progetto	Maven	(Apache	Maven:	https://maven.apache.org/)	in	Eclipse.	Per	una	corretta	esecuzione	del	framework	di	valutazione	si	devono	evitare	tutte	le	possibili	interferenze	di	altri	processi	in	esecuzione	nel computer	che	si	sta	utilizzando.	

### miniProject3

*Traccia del terzo mini progetto:*

>Il	progetto	consiste	nel:
>1. Implementare	la	classe ```AdjacentListDirectedGraph<V, E> implements Graph<V, E>``` 
>2. Implementare	la	classe	```DijkstraShortestPathComputer<V, E>```
>
> La	struttura	di	entrambe	le	classi,	delle	relative	interfacce e	di	alcune	classi	di	implementazione	di	default	è già	impostata	nella	traccia.	 Vanno	implementati	tutti	i	metodi	richiesti	(segnalati	con	commenti	della	forma	// TODO testo).	La	specifica	precisa	delle	API	è	data	con	commenti	javadoc	del	codice.	
> 
> E’ consentito	introdurre	variabili	istanza	e	metodi	aggiuntivi,	ma	non	cambiare	o	cancellare	quelli	presenti	nella	traccia. Sono	definiti	diversi	metodi	di	test	realizzati	con	JUnit	4	(https://junit.org/junit4/).	L’implementazione	delle	classi	dovrebbe	passare	tutti	i	test	forniti.
> 
> Il	codice	è	fornito	sottoforma	di progetto	Maven	(Apache	Maven:	https://maven.apache.org/)	in	Eclipse.	

## Licenza

L'intera implementazione delle classi è distribuita sotto licenza **MIT** 

```
Copyright (c) 2019 Francesco Coppola

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
```

 

