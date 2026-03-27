let currentEquation = '';
const mainDisplay = document.getElementById('main-display');
const historyDisplay = document.getElementById('history-display');

function append(value){
    if (currentEquation === '0' || currentEquation === Error){
        currentEquation = '';
    }
    currentEquation += value;
    updateScreen();
}

function clearAll(){
    currentEquation = '0';
    historyDisplay.innerText = '';
    updateScreen();
}

function deleteLast(){
    if (currentEquation.length > 1){
        currentEquation = currentEquation.slice(0, -1);
    } else {
        currentEquation = '0';
    }
    updateScreen();
}

function updateScreen(){
    mainDisplay.innerText =currentEquation;
}

function insertTemplate(prefix, suffix){
    currentEquation = currentEquation === '0' ? '' : currentEquation;
    currentEquation += prefix + " " + suffix;ç
    updateScreen();
}

async function calculate() {
    if (currentEquation.trim() === '' || currentEquation === '0') return;

    historyDisplay.innerText = currentEquation + " =";

    try {
        const response = await fetch('http://localhost:7000/calculate', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ equation: currentEquation })
        });

        const data = await response.json();

        if (response.ok) {
            currentEquation = data.result.toString();
            updateScreen();
        } else {
            mainDisplay.innerText = 'Error';
            console.error("Error desde Java:", data.error);
        }
    } catch (error) {
        mainDisplay.innerText = 'Error de Red';
        console.error("Fallo de conexión:", error);
    }
}

function requestGraph() {
    console.log("Aquí pediremos a Java los puntos (x, y) de la función: " + currentEquation);
    // document.getElementById('graph-container').style.display = 'block';
    // Lógica futura de Chart.js o Canvas
}