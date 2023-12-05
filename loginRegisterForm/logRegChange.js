// Button Ref
const buttonRegLog = document.getElementById("buttonRegLog");

// Funcion registro
const createRegister = () => {
    const refSectionForm = document.getElementById("formDiv");

    const form = `
    <form>
                    <div class="mb-3">
                        <label for="email" class="form-label">Correo Electrónico</label>
                        <input type="email" class="form-control" id="email">
                    </div>
                    <div class="mb-3">
                        <label for="password" class="form-label">Contraseña</label>
                        <input type="password" class="form-control" id="password">
                    </div>
                    <div class="mb-3">
                        <label for="password2" class="form-label">Confirmar Password</label>
                        <input type="password" class="form-control" id="password2">
                    </div>
                    <div class="mb-3 form-check">
                            <input class="form-check-input" type="checkbox" id="gridCheck">
                            <label class="form-check-label" for="gridCheck">
                                Acepto Términos y Condiciones
                            </label>
                    </div>
                    <div id="buttons">
                    <button id="buttonSend" type="submit" class="btn mt-3 mb-3">
                    <img src="./media/book.svg">
                    Registrar
                    </button>
                    <button id="buttonRegLog" type="button" class="btn" value="loger">
                    <img src="./media/box-arrow-in-right.svg">
                    Login
                    </button>
                    </div>
                </form>
    `;

    refSectionForm.innerHTML = "";
    refSectionForm.innerHTML = form;

};

// Función Login
const createLogin = () => {
    const refSectionForm = document.getElementById("formDiv");

    const form = `
    <form>
    <div class="mb-3">
        <label for="email" class="form-label">Correo Electrónico</label>
        <input type="email" class="form-control" id="email" aria-describedby="emailHelp">
        <div id="emailHelp" class="form-text">Nunca compartas tus datos con cualquiera</div>
    </div>
    <div class="mb-3">
        <label for="password" class="form-label">Contraseña</label>
        <input type="password" class="form-control" id="password">
    </div>
    <div class="mb-3 form-check">
        <input type="checkbox" class="form-check-input" id="check">
        <label class="form-check-label" for="check">Mantenerme Activo</label>
    </div>
    <div id="buttons">
        <button id="buttonSend" type="submit" class="btn mt-3 mb-3">
            <img src="./media/box-arrow-in-right.svg">
            Logear
        </button>
        <button id="buttonRegLog" type="button" class="btn" value="register">
            <img src="./media/book.svg">
            Registrar
        </button>
    </div>
    </form>
    `;

    refSectionForm.innerHTML = "";
    refSectionForm.innerHTML = form;
};

// Accion
buttonRegLog.addEventListener("click", () => {
    
    const refHeaderForm = document.getElementById("headerForm");
    const buttonValue = buttonRegLog.value;

    if (buttonValue === "register") {
        refHeaderForm.innerHTML = "Registro";
        console.log(buttonValue);
        createRegister();
    } else {
        refHeaderForm.innerHTML = "Iniciar Sesión";
        console.log(buttonValue);
        createLogin();
    }

});