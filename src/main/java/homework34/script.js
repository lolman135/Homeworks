let display = document.getElementById('display');
let expression = '';

function inputValue(value) {
    if (expression === '' && (value === '/' || value === '*' || value === '-' || value === '+')) {
        return;
    }
    expression += value;
    display.textContent = expression;
}

function calculate() {
    try {
        if (expression.includes('/0')) {
            display.textContent = "Error";
            expression = '';
            return;
        }
        let result = eval(expression);
        display.textContent = result;
        expression = result.toString();
    } catch (error) {
        display.textContent = "Error";
        expression = '';
    }
}

function clearDisplay() {
    expression = '';
    display.textContent = '0';
}

function backspace() {
    expression = expression.slice(0, -1);
    display.textContent = expression || '0';
}
