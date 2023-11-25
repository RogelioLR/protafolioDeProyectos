// Check
const lineText = (element) => {
    const refContentHomework = document.getElementById(element.name);

    if (element.checked) {
        refContentHomework.setAttribute("class","text-decoration-line-through");
    } else {
        refContentHomework.setAttribute("class", "");
    }
};

// Eliminar Elemento
const deleteElement = (element) => {
    const elementId = element.name;
    const refHW = document.getElementById(elementId);
    refHW.remove();
};

// Añadir Tareas
const buttonAdd = document.getElementById("addHomeworkButton");
buttonAdd.addEventListener("click", e => {

    const refTitle = document.getElementById("titleHomework");
    const refTextArea = document.getElementById("descriptionHomework");
    const refList = document.getElementById("listHomework");

    const liElement = document.createElement("li");
    const textLi = `
        <div class="ms-2 me-auto">
            <div class="fw-bold">${refTitle.value}</div>
            <p id="contentHomework${refList.childElementCount + 1}">${refTextArea.value}</p>
            <div class="form-check mt-3 mb-3">
                <input class="form-check-input" type="checkbox" name="contentHomework${refList.childElementCount + 1}" onchange="lineText(this)">
                <label class="form-check-label" for="completeHomework">
                    Completar Tarea
                </label>
            </div>
        </div>
        <button type="button" class="btn btn-danger" name="homework${refList.childElementCount + 1}" onclick="deleteElement(this)">
            <img src="./media/deleteImage.png" width="25" height="25">
        </button>
    `;

    liElement.setAttribute("class","list-group-item d-flex justify-content-between align-items-start");
    liElement.setAttribute("id",`homework${refList.childElementCount + 1}`);
    liElement.innerHTML = textLi;
    refList.appendChild(liElement);

    refTitle.value = "";
    refTextArea.value = "";

});
