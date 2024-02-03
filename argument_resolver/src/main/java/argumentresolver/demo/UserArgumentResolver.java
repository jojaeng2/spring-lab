package argumentresolver.demo;

import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import lombok.extern.slf4j.Slf4j;

import jakarta.servlet.http.HttpServletRequest;

@Component
@Slf4j
public class UserArgumentResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().equals(UserDto.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        HttpServletRequest httpServletRequest = webRequest.getNativeRequest(HttpServletRequest.class);
        UserDto userDto = new UserDto();
        userDto.setUserId(httpServletRequest.getSession().getId());
        userDto.setUserLocale(httpServletRequest.getLocale().toString());

        log.warn("resolveArgument userDto : {}", userDto.toString());
        return userDto;
    }
}
