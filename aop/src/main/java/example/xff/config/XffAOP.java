package example.xff.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
@Slf4j
public class XffAOP {

    @Around("example.xff.config.XffPointcuts.allService()")
    public void addHttpServletRequest(ProceedingJoinPoint joinPoint) throws Throwable {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();

        String ip = request.getHeader("X-Forwarded-For");
        String browser = "";
        String userIp = request.getRemoteUser();
        String userBrowser = request.getHeader("User-Agent");

        if(userBrowser.contains("Trident")) {												// IE
            browser = "ie";
        } else if(userBrowser.contains("Edge")) {											// Edge
            browser = "edge";
        } else if(userBrowser.contains("Whale")) { 										// Naver Whale
            browser = "whale";
        } else if(userBrowser.contains("Opera") || userBrowser.contains("OPR")) { 		// Opera
            browser = "opera";
        } else if(userBrowser.contains("Firefox")) { 										 // Firefox
            browser = "firefox";
        } else if(userBrowser.contains("Safari") && !userBrowser.contains("Chrome")) {	 // Safari
            browser = "safari";
        } else if(userBrowser.contains("Chrome")) {										 // Chrome
            browser = "chrome";
        }



        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {

            ip = request.getHeader("Proxy-Client-IP");

        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {

            ip = request.getHeader("WL-Proxy-Client-IP");

        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {

            ip = request.getHeader("HTTP_CLIENT_IP");

        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {

            ip = request.getHeader("HTTP_X_FORWARDED_FOR");

        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {

            ip = request.getHeader("X-Real-IP");

        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {

            ip = request.getHeader("X-RealIP");

        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {

            ip = request.getHeader("REMOTE_ADDR");

        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {

            ip = request.getRemoteAddr();

        }


        log.info("ip = {} ", ip);
        log.info("userBrowser = {} ", browser);
        joinPoint.proceed();
    }
}
