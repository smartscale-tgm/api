package io.swagger.error;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class MyErrorController implements ErrorController {

    @RequestMapping("/error")
    @ResponseBody
    public String handleError(HttpServletRequest request) {
        System.out.println("/error");
        System.out.println(request.toString());
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        HttpStatus status = HttpStatus.valueOf(statusCode);

        throw new HttpStatusError(status.toString() + " " + status.getReasonPhrase(), status);
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }

}
