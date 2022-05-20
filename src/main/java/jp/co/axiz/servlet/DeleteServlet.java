package jp.co.axiz.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.axiz.service.ProductService;
/**
 * Servlet implementation class StartAppServlet
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {}
    	
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
    	request.setCharacterEncoding("UTF-8");
    	String strId = request.getParameter("id");
    	
    	if(strId.isEmpty()) {
    		request.setAttribute("flag", 1);
    		request.getRequestDispatcher("delete.jsp").forward(request, response);
    	}
    	
    	int result = new ProductService().delete(strId);
    	//System.out.println(result);
    	if(result == 1) {
    		request.getRequestDispatcher("deleteResult.jsp").forward(request, response);
    	}else {
    		request.setAttribute("msg", "対象のデータはありません");
    		request.getRequestDispatcher("delete.jsp").forward(request, response);
    	}
    }
}
