package webmvc.org.springframework.web.servlet.mvc.tobe;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import webmvc.org.springframework.web.servlet.ModelAndView;

public class HandlerExecution {

    private final Method method;

    public HandlerExecution(final Method method) {
        this.method = method;
    }

    public ModelAndView handle(final HttpServletRequest request, final HttpServletResponse response) throws Exception {
        return (ModelAndView) method.invoke(getHandlerClass(), request, response);
    }

    private Object getHandlerClass()
            throws InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        return method.getDeclaringClass().getDeclaredConstructor().newInstance();
    }
}
