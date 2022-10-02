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

        String ip = findIP(request.getHeader("X-Forwarded-For"), request);
        String browser = findBrowser(request.getHeader("User-Agent"));
        log.info("ip = {} ", ip);
        log.info("userBrowser = {} ", browser);
        joinPoint.proceed();
    }

    private String findBrowser(String info) {
        String browser = "Unknown";
        if(info.contains("Trident")) browser = "ie";
        else if(info.contains("Edge")) browser = "edge";
        else if(info.contains("Whale")) browser = "whale";
        else if(info.contains("Opera") || info.contains("OPR")) browser = "opera";
        else if(info.contains("Firefox")) browser = "firefox";
        else if(info.contains("Safari") && !info.contains("Chrome")) browser = "safari";
        else if(info.contains("Chrome")) browser = "chrome";
        return browser;
    }

    private String findIP(String ip, HttpServletRequest request) {
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
        return ip;
    }
}
