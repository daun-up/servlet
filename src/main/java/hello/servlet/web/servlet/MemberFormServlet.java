package hello.servlet.web.servlet;

import hello.servlet.domain.member.MemberRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="memberFormServlet", urlPatterns = "/servlet/members/new-form")
public class MemberFormServlet extends HttpServlet {

    // 싱글톤이므로 new MemberRepository 말고 getInstance()로만 가져올 수 있다.
    private MemberRepository memberRepository = MemberRepository.getInstance();

    /*
    로직
     */
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html"); // Content-Type: text/html;charset=utf-8
        response.setCharacterEncoding("utf-8");

        PrintWriter writer = response.getWriter();
        writer.write("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Title</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <form action=\"/servlet/members/save\" method=\"post\">\n" + // servlet/members/save 로 이동!! redirect
                "        username: <input type=\"text\" name=\"username\" />\n" +
                "        age: <input type=\"text\" name=\"age\" />\n" +
                "        <button type=\"submit\">저장</button>\n" +
                "    </form>\n" +
                "</body>\n" +
                "</html>");

    }
}
