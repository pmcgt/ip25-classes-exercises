import exercises.Calculator;

void main() {
    startCalculator();
}

void startCalculator() {
    Calculator calculator = new Calculator();
    String userInput = "";

    printInstruction();
    while(!userInput.equals("s")){
        printCalculator(calculator);
        do {
            userInput = IO.readln();
        }while (!isValidInput(userInput));
        handleUserInput(calculator, userInput);
    }
}

void handleUserInput(Calculator calculator, String userInput) {
    char option = userInput.charAt(0);
    if(option == 's') {
        IO.println("See you space cowboy!");
    } else if (option == 'c') {
        calculator.reset();
    }else if (option == 'u') {
        calculator.undo();
    } else {
        updateValue(calculator, option, userInput);
    }
}

void updateValue(Calculator calculator, char option, String userInput) {
    if(userInput.substring(1).isEmpty()) {
        return;
    }

    double number = Double.parseDouble(userInput.substring(1));
    if (option == '+') {
        calculator.add(number);
    } else if (option == '-') {
        calculator.subtract(number);
    } else if (option == '*') {
        calculator.multiply(number);
    } else {
        calculator.divide(number);
    }
}

boolean isValidInput(String userInput) {
    if(userInput.isEmpty()) {
        return false;
    }

    if(!isValidOption(userInput.charAt(0)))  {
        IO.println("Invalid option selected, try again");
        return false;
    }

    String numberInput = userInput.substring(1);
    if(!isValidNumber(numberInput)) {
        IO.println("Invalid number selected, try again");
        return false;
    }

    return true;
}

boolean isValidOption(char option) {
    char[] validOptions = {'s','c','u','+','-','*','/'};
    for (int i = 0; i < validOptions.length; i++) {
        if (validOptions[i] == option){
            return true;
        }
    }
    return false;
}

boolean isValidNumber(String str) {
    for (int i = 0; i < str.length(); i++) {
        if(str.charAt(i) == '.'){
            continue;
        }
        if(str.charAt(i) < '0' || str.charAt(i) > '9') {
            return false;
        }
    }
    return true;
}

void printInstruction() {
    IO.println("~Welcome to the Calculator~");
    IO.println("Enter the operation you want to execute followed by a number:");
    IO.println("+ -> addition");
    IO.println("- -> subtraction");
    IO.println("* -> multiplication");
    IO.println("/ -> division");
    IO.println("example -> +4\n");
    IO.println("u -> undo last operation");
    IO.println("c -> reset to zero");
    IO.println("s -> exit");
    IO.println("Have fun!\n");
}

void printCalculator(Calculator calculator) {
    IO.println("| " + calculator.value() +  " |");
}