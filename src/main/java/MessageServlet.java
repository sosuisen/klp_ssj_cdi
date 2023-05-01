import java.io.IOException;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.AbstractHistory;

@WebServlet(urlPatterns = { "/message", "/clear" })
public class MessageServlet extends HttpServlet {
	@Inject
	// private History history;
	private AbstractHistory history;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		var path = request.getServletPath();

		if (path.equals("/clear")) {
			history.clear();
			response.sendRedirect("message");
			return;
		}

		request.getRequestDispatcher("/WEB-INF/message.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		var message = request.getParameter("message");

		history.add(message);

		request.getRequestDispatcher("/WEB-INF/message.jsp").forward(request, response);
	}
}
