package example.xff.controller;

import example.xff.service.XffService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController("/api")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class XffController {

    private final XffService xffService;


    @GetMapping("/xff")
    public void receiveGet(HttpServletRequest request) {
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

    }
}
