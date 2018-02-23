package ru.chessteam.pages;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Класс - Точка входа приложения
 * Так же здесь будет основная логика приложения (переключение между страницами и т.п.)
 *
 * @author StukalovSS
 */
@Controller
public class MainController {

    /**
     * Точка входа приложения
     * value = "/" - дефолтный адрес - путь
     *
     * @return ---
     */
    @RequestMapping(value = "/", method = RequestMethod.GET) //дефолтный адрес и тип запроса
    public ModelAndView main() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index"); //имя отображения
        return modelAndView;
    }

}
