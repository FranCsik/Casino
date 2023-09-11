# Casino
Trabajo práctico realizado en Orientación a Objetos

Consigna: 

Tragamonedas

El equipo de analistas ha finalizado el relevamiento y cotización de un sistema que gestiona la configuración y el funcionamiento de las máquinas tragamonedas de un casino. Se solicita que se modele e implemente el sistema relevado con la información detallada según el relevamiento realizado.

	Una máquina tragamonedas se caracteriza por un número fijo de casillas que utiliza para formar la combinación. En cada casilla se mostrará una fruta que puede ser banana, frutilla, guinda, manzana, sandía o uva. 
	Cada máquina tiene una recaudación (la cantidad de dinero que contiene en un momento determinado). 
	Al crear una máquina se le asigna una recaudación inicial para dar premios y de esa manera empezar a operar. 
	La recaudación se irá incrementando con las jugadas no ganadoras de los usuarios y se reducirá cuando se concedan los premios.
	La máquina también tiene un valor de recaudación mínimo, cuando se alcanza ese valor se debe mostrar un mensaje en pantalla de juego indicando que se ha alcanzado la recaudación mínima y existe posibilidad de no poder pagar los próximos premios.
	Cada máquina gestiona el conjunto de premios que puede dar, por lo que el sistema debe permitir el alta y baja de premios para cada una de las máquinas.
	Cada premio consiste en una combinación concreta de frutas a la que le corresponde una cantidad fija de dinero. Nótese que el número de frutas de la combinación dependerá de la máquina tragamonedas en la que se va a registrar dicho premio. Por tanto, en una máquina sólo podrán registrarse aquellos premios cuyo tamaño de la combinación coincida con el número de casillas de dicha máquina. Por ejemplo, si se creó una máquina con tres casillas, las combinaciones premiadas deberían ser del tipo:
  	una combinación de tres frutillas premio $500, 
  	una combinación de dos frutillas y una pera $ 100.
  	Una combinación de dos manzanas y una uva $250.
	Cuando un jugador desea jugar en una máquina debe ingresar dinero para tener crédito disponible. Solo se puede jugar si el crédito disponible en la máquina es igual o superior al coste de la jugada. El precio de una jugada es fijo para cada máquina. 
	Para conseguir el crédito, el cliente debe concurrir a la caja y comprar crédito. Se le entregará un ticket con un número que deberá ingresar en la maquina donde quiere jugar para acreditar el importe y poder jugar.
	El crédito se incrementa cada vez que se consiga un premio o bien cuando se ingrese dinero.	
	Cuando se desee cobrar el crédito disponible, se le pedirá a la máquina que emita un comprobante para presentar en la caja y que hagan la liquidación. Una ver solicitado el comprobante no se podrá volver a jugar hasta que se ingrese nuevamente crédito.
 
	Cada jugada generará aleatoriamente una combinación de frutas del tamaño de la combinación fijado en la máquina y se comprobará si: 
	dicha combinación tiene premio (es decir, se encuentra entre los premios registrados)
	el premio por conceder es menor o igual que la recaudación.
