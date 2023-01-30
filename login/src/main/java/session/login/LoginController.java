package session.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
public class LoginController {
  private static final String LOGIN_MEMBER = "LOGIN_MEMBER";


  @GetMapping("/login")
  public String login(HttpServletRequest request) {
    HttpSession session = request.getSession(true);

    session.setAttribute(LOGIN_MEMBER, 123);
    return "ok";
  }

  @GetMapping("/logout")
  public String logout(HttpServletRequest request) {
    HttpSession session = request.getSession(false);

    if (session != null) {
      session.invalidate();
    }
    return "ok";
  }
}
