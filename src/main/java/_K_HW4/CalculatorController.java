package _K_HW4;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RequestMapping("/calculator")
@RestController
public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping
    public String hello() {
        return "Добро пожаловать в калькуляор";
    }

    @GetMapping("/plus")
    public String plus(@RequestParam Integer num1 ,@RequestParam Integer num2) {

        var sum = calculatorService.plus(num1, num2);
        return num1 + " + " + num2 + " = " + sum;
    }

    @GetMapping("/minus")
    public String minus(@RequestParam Integer num1 ,@RequestParam Integer num2) {

        var sum = calculatorService.minus(num1, num2);
        return num1 + " - " + num2 + " = " + sum;
    }
    @GetMapping("/multiply")
    public String multiply(@RequestParam Integer num1 ,@RequestParam Integer num2) {

        var sum = calculatorService.multiply(num1, num2);
        return num1 + " * " + num2 + " = " + sum;
    }
    @GetMapping("/divide")
    public String divide(@RequestParam Integer num1 ,@RequestParam Integer num2) {

        var sum = calculatorService.divide(num1, num2);
        if (num2 == 0) {
            return "на 0 делить нельзя";
        }
        return num1 + " / " + num2 + " = " + sum;
    }
}
