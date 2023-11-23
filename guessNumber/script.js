console.log("Adivina el Numero");

// Numero Aleatorio
const number = Math.floor(100*Math.random());

// Referencia del Formulario
const refFormulary = document.forms["formNumber"];

// Referencia del Boton
const refButton = document.getElementById("buttonNumber");

// Referencia del Historial
const refHistory = document.getElementById("history");

// Referencia Imagen
const refImg = document.getElementById("imageNumber");

// Funcion comparadora
const compareNumbers = (number, suppose) => {
    let answer = "";
    if (number === suppose) {
        answer = `Lo Has Adivinado, Mi Número es: ${number}`;
        refImg.setAttribute("src","./media/exito.png");
    } else if (number < suppose){
        answer = "Tu Número es Mayor";
    } else {
        answer = "Tu Número es Menor";
    }
    return answer;
};

// Funcion de Imprimir
const printAnswer = (answer) => {
    refHistory.innerHTML = `${answer}`;
};

// Función de Verificacion Numerica
const verifyNumber = myNumber => {
    if (myNumber <= 100 && myNumber >= 0) {
        printAnswer( `Intento (${counter}): ${compareNumbers(number, myNumber)}` );
    } else {
        printAnswer("Entrada no válida");
    }
};

// Evento de click
let counter = 0;
refButton.addEventListener("click", event => {

    counter++;
    const myNumber = parseInt(refFormulary.elements["numberSuppose"].value);
    verifyNumber(myNumber);

});
