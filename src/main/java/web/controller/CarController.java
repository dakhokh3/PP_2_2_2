package web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarService;
import web.service.CarServiceImpl;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {
    @GetMapping("/cars")
    public String printCar(@RequestParam(value = "count", required = false) Integer count,
                           Model model) {
        CarService carService = new CarServiceImpl();
        List<Car> cars = new ArrayList<Car>();
        cars.add((new Car("Toyota Supra", "White", 30000)));
        cars.add((new Car("BMW 3", "Black", 32000.5)));
        cars.add((new Car("Lexus RX300", "White", 38000)));
        cars.add((new Car("Ford Focus", "Blue", 20000)));
        cars.add((new Car("Mazda CX-5", "White", 25000)));
        if (count == null) count = cars.size();
        model.addAttribute("cars", carService.getCars(cars, count));
        return "cars";
    }
}
